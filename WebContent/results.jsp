<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src="movImgs.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results</title>
</head>
<body>

<%@ include file="static1.html" %>
<%@ page import="java.util.List,java.util.ArrayList" %>
<br><br>
<div class="results">
<%
List<String> results = new ArrayList<String>();
results = (ArrayList<String>)request.getAttribute("searcher");
for(int i=0;i<results.size();i++){
	if(results.get(i)=="#new#")
	{
		out.println("<hr>");
	}
	else
	{
		out.println(results.get(i)+"<br>");
	}
	
}
%>
<hr>


</div>
</body>
</html>