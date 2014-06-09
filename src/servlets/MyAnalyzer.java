package servlets;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.apache.lucene.analysis.standard.StandardFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.analysis.util.StopwordAnalyzerBase;
import org.apache.lucene.util.Version;
 
import java.io.IOException;
import java.io.Reader;


/*Κλάση η οποία βασίζεται στην κλάση StandardAnalyzer με μόνη διαφορά 
 * την προσθήκη ενός επιπλέον φίλτρου στο τέλος στην διαδικασία της ανάλυσης.
 * Συγκεκριμένα χρησιμοποιούμε το αλγόριθμο Porter για το stemming.(γραμμή κώδικα: 58)*/
public final class MyAnalyzer extends StopwordAnalyzerBase {
	
	public static final int DEFAULT_MAX_TOKEN_LENGTH = 255;
	private int maxTokenLength = DEFAULT_MAX_TOKEN_LENGTH;
	public static CharArraySet STOP_WORDS_SET = StopAnalyzer.ENGLISH_STOP_WORDS_SET; 
	
	public MyAnalyzer(Version matchVersion, CharArraySet stopWords) {
		
		super(matchVersion, stopWords);
	}
	
	public MyAnalyzer(Version matchVersion) {

		this(matchVersion, STOP_WORDS_SET);
	}
	
	public MyAnalyzer(Version matchVersion, Reader stopwords) throws IOException {

		this(matchVersion, loadStopwordSet(stopwords, matchVersion));
	}
	
	public void setMaxTokenLength(int length) {

		maxTokenLength = length;
	}
	
	public int getMaxTokenLength() {

		    return maxTokenLength;
	}
	
	@Override
	protected TokenStreamComponents createComponents(final String fieldName, final Reader reader) {

		final StandardTokenizer src = new StandardTokenizer(matchVersion, reader);
		src.setMaxTokenLength(maxTokenLength);
		TokenStream tok = new StandardFilter(matchVersion, src);
	    tok = new LowerCaseFilter(matchVersion, tok);
	    tok = new StopFilter(matchVersion, tok, stopwords);
	    /*Τα token περνάνε απο διαδικασία stemming με τον αλγόριθμο Porter*/
	    tok = new PorterStemFilter(tok);
	    return new TokenStreamComponents(src, tok) {
		
	    @Override
	    protected void setReader(final Reader reader) throws IOException {
		        src.setMaxTokenLength(MyAnalyzer.this.maxTokenLength);
		        super.setReader(reader);
	    }
	    };
	}
}
