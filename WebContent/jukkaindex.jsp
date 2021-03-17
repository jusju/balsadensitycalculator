<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="virhe.jsp"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="engine.Balsalevy" %>

<html>
<head>
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
<form action="JukkaController">
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
	
		<tr>
   		<td>
  		</td>
  		<td>
  			Grain (g)
  		</td>
  		<td>
  			<input type="text"  name="grain"
  			<% 
  		  	if(request.getAttribute("grain") != null) {
  		  		out.println(" value=\""+ request.getAttribute("grain") + "\"");
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
   		</td>
	</tr>	
	<tr>
   		<td>
  		</td>
  		<td>
  			Tulos  
  		</td>
  		<td>
  			<% 
  			if(request.getAttribute("density") != null) {
  				out.println(request.getAttribute("density")); 
  			}
  			
  			%> kg/m3
   		</td>
	</tr>
	

		

</form>
</table>
<br>
<br>
<%
ArrayList<Balsalevy> balsat = new ArrayList<Balsalevy>();
balsat = (ArrayList<Balsalevy>)request.getAttribute("balsat");
%>

<table border="1">
<tr>
<td>ID</td>
<td>tiheys</td>
<td>grain</td>
<td>paksuus</td>
<td>leveys</td>
<td>pituus</td>
<td>DELETE</td>
</tr>

<% 
for(int i=0; i < balsat.size(); i++) {
	out.println("<tr>");
	Balsalevy balsalevy = (Balsalevy)balsat.get(i);
	out.println("<td>" + balsalevy.getId() + "</td>");
	out.println("<td>" + balsalevy.getTiheys() + "</td>");
	out.println("<td>" + balsalevy.getGrain() + "</td>");
	out.println("<td>" + balsalevy.getPaksuus() + "</td>");
	out.println("<td>" + balsalevy.getLeveys() + "</td>");
	out.println("<td>" + balsalevy.getPituus() + "</td>");
	out.println("<td><a href=\"JukkaController?deleteid=" + balsalevy.getId()  + "\">DELETE</a></td>");
	out.println("</tr>");
	
}
%>

</table>





</body>
</html>
