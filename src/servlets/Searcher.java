package servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.util.WordlistLoader;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
/**
 * Servlet implementation class HomePage
 */
public class Searcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Document hitDoc;
	public static IndexSearcher is;
	public static ScoreDoc[] hits;
	public static String indexDir = "C:\\Users\\stavros\\Documents\\SearchEngine\\index_directory";

    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");
		String searchTerm = request.getParameter("search");
		
		/*Ορισμός καταλόγου που βρίσκεται το index (παράμετρος). Θα χρησιμοποιηθεί στην ανάκτηση. Ακόμα, ορίζουμε το αρχείο
		 *common words, προκειμένου να τις παραλήψουμε από το ερώτημα.*/
		File path = new File(indexDir);
		Directory dir = FSDirectory.open(path);
		
		IndexReader dr = DirectoryReader.open(dir);
		is = new IndexSearcher(dr);
		File common = new File(indexDir.substring(0, indexDir.length()-15) + "common_words");
		FileReader reader = new FileReader(common);
		
		/*Ορίζουμε τα πεδία στα οποία θα εκτελέσουμε την αναζήτηση*/
		String[] fields = {"title","description","activities"};
		Analyzer analyzer = new MyAnalyzer(Version.LUCENE_47, WordlistLoader.getWordSet(reader, Version.LUCENE_47));
		MultiFieldQueryParser parser = new MultiFieldQueryParser(Version.LUCENE_47, fields, analyzer);
		
	    Query q = null;
		try {
			q = parser.parse(searchTerm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    long start = System.currentTimeMillis();
	    hits = is.search(q, null, 30).scoreDocs;
	    long end = System.currentTimeMillis();
	    
	    System.err.println("Found " + hits.length + " document(s) (in " + (end - start) + " miliseconds) that match the query: '" + searchTerm + "'.");
	    List<String> results = new ArrayList<String>();
	    if (hits.length > 0)
	    {
	    	/*Για κάθε ένα από τα ανακτημένα i συγγράμματα*/
		    for (int i=0; i < hits.length; i++){
		    	hitDoc = is.doc(hits[i].doc);
		    	
		    	/*Εμφάνιση τίτλου συγγράμματος και αριθμού στην διεπαφή.*/
		        
		        results.add(hitDoc.get("title"));
		        
		        
		        /*Εμφάνιση συγγραφέα συγγράμματος στην διεπαφή.*/
		        results.add(hitDoc.get("description"));
		        
		        
		        /*Εμφάνιση περιγραφής συγγράμματος στην διεπαφή.*/
		        results.add(hitDoc.get("activities"));
		        
		        
		        /*Εμφάνιση γενικών πληροφοριών ανάκτησης, όπως αριθμό κειμένων και διάρκεια.*/
		        //System.out.println("Found " + hits.length + " document(s) (in " + (end - start) + " miliseconds) that match the query: '" + searchTerm + "'.");
		    }
	    }
	    else
	    	results.add("No document(s) found (in " + (end - start) + " miliseconds) that match the query: '" + searchTerm + "'.");
	    
	    ServletContext sc = this.getServletContext();
	    request.setAttribute("searcher", results);
	    RequestDispatcher rd = sc.getRequestDispatcher("/results.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
