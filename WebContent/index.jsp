<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.DecimalFormat" %>
<html>
<head>
<link rel="shortcut icon" type="image/png" href="favicon.png">
<title>Balsan tiheyslaskuri</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
<style>

#content {
    position: relative;
}
#content img {
    position: absolute;
    top: 0px;
    right: 0px;
}


</style>
	<div id="content">
    	<img src="images/sil-tunnus-sininen.jpg" width="100" height="100" class="ribbon"/>
    </div>


<h1>Balsan tiheyslaskuri</h1>
<table border="1">
<form action="Controller">
  	<th>
   		<td>
  		</td>
  		<td>
  			Arvo  
  		</td>
  		<td>
   		</td>
	</th>
  	<tr>
   		<td>
  		</td>
  		<td>
  			Paksuus (mm)  
  		</td>
  		<td>
  		  	<input type="text"  name="thickness"
  		  	
  		  	<% 
  		  	if(request.getAttribute("thickness") != null) {
  		  		out.println(" value=\""+ request.getAttribute("thickness") + "\"");
  		  	}
  		  	%>
  		  	
  		  	>
   		</td>
	</tr>
	<tr>
   		<td>
  		</td>
  		<td>
  			Pituus (mm)  
  		</td>
  		<td>
  		  	<input type="text"  name="length"
  		  	
  		  	<% 
  		  	if(request.getAttribute("length") != null) {
  		  		out.println(" value=\""+ request.getAttribute("length") + "\"");
  		  	}
  		  	%>
  		  	
  		  	>
   		</td>
	</tr>
	<tr>
   		<td>
  		</td>
  		<td>
  			Leveys (mm)  
  		</td>
  		<td>
  			<input type="text"  name="width"			
  		  	<% 
  		  	if(request.getAttribute("width") != null) {
  		  		out.println(" value=\""+ request.getAttribute("width") + "\"");
  		  	}
  		  	%>
  			
  			>
   		</td>
	</tr>	

	<tr>
   		<td>
  		</td>
  		<td>
  			Paino (g)
  		</td>
  		<td>
  			<input type="text"  name="weight"
  			<% 
  		  	if(request.getAttribute("weight") != null) {
  		  		out.println(" value=\""+ request.getAttribute("weight") + "\"");
  		  	}
  		  	%>
  			
  			
  			>
   		</td>
	</tr>		
	<tr>
   		<td>
  		</td>
  		<td>
  			  
  		</td>
  		<td>
  			<input type="submit" class="btn btn-success" name="action" value="Laske">
  			<input type="submit" class="btn btn-success" name="action" value="I am Feeling Lucky">
   		</td>
	</tr>	
	<tr>
   		<td>
  		</td>
  		<td>
  			Tulos (kg/m3) 
  		</td>
  		<td>
  			<% 
  			if(request.getAttribute("density") != null) {
  				out.println("<b>" + request.getAttribute("density") + "</b>"); 
  			}
  			
  			%> kg/m3 
   		</td>
	</tr>	
	<tr>
   		<td>
  		</td>
  		<td>
  			Tulos (lb/ft3) 
  		</td>
  		<td>
  			<% 
  			if(request.getAttribute("densityft") != null) {
  				out.println("<b>" + request.getAttribute("densityft") + "</b>"); 
  			}
  			
  			%> lb/ft3
   		</td>
	</tr>	
</form>
</table>
<hr>
K�ytt�ji� t�h�n menness�: 
<p id="hits"></p>
<script>
	let hitamount = 0;
	console.log("JUKKA");
	fetch('http://localhost:8080/balsalaskin/HitsServlet')
  	.then(response => response.json())
  	.then(data => document.getElementById("hits").innerHTML = data.hits);
	

	document.getElementById("hits").innerHTML = hitamount;
</script>


</body>
</html>
