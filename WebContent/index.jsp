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
  		  	<input type="number"  name="thickness"
  		  	
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
  			Pituus (cm)  
  		</td>
  		<td>
  		  	<input type="number"  name="length"
  		  	
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
  			Leveys (cm)  
  		</td>
  		<td>
  			<input type="number"  name="width"			
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
  			<input type="number"  name="weight"
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
  			<input type="submit"  name="action" value="Laske">
  			<input type="submit"  name="action" value="I am Feeling Lucky">
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
  			
  			out.println(request.getAttribute("density")); 
  			
  			
  			%> kg/m3
   		</td>
	</tr>	

</form>
</table>


</body>
</html>
