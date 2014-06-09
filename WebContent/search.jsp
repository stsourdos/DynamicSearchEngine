<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src="movImgs.js"></script>
<script type="text/javascript" src="checkUncheck.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>

<%@ include file="static1.html" %>
<%@ page import="java.util.List,java.util.ArrayList" %>

<div class="questionnaire">

<h3>Activities:</h3><hr>
	<table>
	<tr><td>
	<form id="questions" action="Searcher" method="post">
	
		<input type="checkbox" id="c1" name="activities" value="swimming" onClick="uncheck(2)"/>
		<label for="c1"><span></span>Swimming</label><br>
		</td><td>
		<input type="checkbox" id="c2" name="activities" value="diving" onClick="uncheck(2)"/>
		<label for="c2"><span></span>Diving</label><br>
	</td></tr>
	<tr><td>
		<input type="checkbox" id="c3" name="activities" value="hiking" onClick="uncheck(2)"/>
		<label for="c3"><span></span>Hiking</label><br>
		</td><td>
		<input type="checkbox" id="c4" name="activities" value="water sports" onClick="uncheck(2)"/>
		<label for="c4"><span></span>Water Sports</label><br>
	</td><tr><td>
		<input type="checkbox" id="c5" name="activities" value="windsurfing" onClick="uncheck(2)"/>
		<label for="c5"><span></span>Wind Surfing</label><br>
		</td><td>
		<input type="checkbox" id="c6" name="activities" value="walking" onClick="uncheck(2)"/>
		<label for="c6"><span></span>Walking</label><br>
	</td><tr><td>
		<input type="checkbox" id="c7" name="activities" value="climbing" onClick="uncheck(2)"/>
		<label for="c7"><span></span>Climbing</label><br>
		</td><td>
		<input type="checkbox" id="c8" name="activities" value="" checked onClick="uncheck(1)"/>
		<label for="c8"><span></span>I don't care</label><br>
	</tr></tr></table>
	<input id="inputsQuestion" name="searchact" type="text" size="50" placeholder="Type Any Other Activity" value="">

<br>
<h3>Sightseeing:</h3><hr>
	<table>
	<tr><td>
		<input type="checkbox" id="s1" name="sightseeing" value="religious" onClick="uncheck(4)"/>
		<label for="s1"><span></span>Religious Monuments</label><br>
		</td><td>
		<input type="checkbox" id="s2" name="sightseeing" value="museum" onClick="uncheck(4)"/>
		<label for="s2"><span></span>Museum</label><br>
	</td></tr><tr><td>
		<input type="checkbox" id="s3" name="sightseeing" value="caves" onClick="uncheck(4)"/>
		<label for="s3"><span></span>Caves</label><br>
		</td><td>
		<input type="checkbox" id="s4" name="sightseeing" value="tradition" onClick="uncheck(4)"/>
		<label for="s4"><span></span>Tradition</label><br>
	</td><tr><td>
		<input type="checkbox" id="s5" name="sightseeing" value="" onClick="uncheck(4)"/>
		<label for="s5"><span></span></label><br>
		</td><td>
		<input type="checkbox" id="s6" name="sightseeing" value="" onClick="uncheck(4)"/>
		<label for="s6"><span></span></label><br>
	</td><tr><td>
		<input type="checkbox" id="s7" name="sightseeing" value="" onClick="uncheck(4)"/>
		<label for="s7"><span></span></label><br>
		</td><td>
		<input type="checkbox" id="s8" name="sightseeing" value="" checked onClick="uncheck(3)"/>
		<label for="s8"><span></span>I don't care</label><br>
	</td></tr></table>
	<input id="inputsQuestion" name="searchact" type="text" size="50" placeholder="Type Any Other Place of Interest" value="">
	    <input id="su" type="submit" value="Search">
<br>
<h3>Type of Geography:</h3><hr>
<select>
  <option value="volvo">Island</option>
  <option value="saab">Town</option>
  <option value="mercedes">Mountainous</option>
  <option value="audi" selected>Any</option>
</select>

<h3>Population Range:</h3><hr>
	<table>
	<tr><td>Minimum</td>
		<td><input type="number" name="quantity" min="1" max="5"></td>
Maximum <input type="number" name="quantity" min="1" max="5"><br>

<h3>Area Range (km2):</h3><hr>
</div>

<%-- Comment <form id="search" action="Searcher" method="post">
	<input id="search" name="search" type="text" placeholder="Insert your Search Term" value="">
    <input id="submit" type="submit" value="Search">
</form>--%>

</body>
</html>