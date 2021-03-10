<html>
<head>
<title>Balsa density calculator</title>
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


<h1>Balsa Density Calculator</h1>
<table border="1">
<form action="Controller">
  	<th>
   		<td>
  		</td>
  		<td>
  			Value  
  		</td>
  		<td>
   		</td>
	</th>
  	<tr>
   		<td>
  		</td>
  		<td>
  			Thickness (mm)  
  		</td>
  		<td>
  		  	<input type="number"  name="thickness">
   		</td>
	</tr>
	<tr>
   		<td>
  		</td>
  		<td>
  			Length (cm)  
  		</td>
  		<td>
  		  	<input type="number"  name="length">
   		</td>
	</tr>
	<tr>
   		<td>
  		</td>
  		<td>
  			Width (cm)  
  		</td>
  		<td>
  			<input type="number"  name="width">
   		</td>
	</tr>	

	<tr>
   		<td>
  		</td>
  		<td>
  			Weight (g)
  		</td>
  		<td>
  			<input type="number"  name="weight">
   		</td>
	</tr>		
	<tr>
   		<td>
  		</td>
  		<td>
  			  
  		</td>
  		<td>
  			<input type="submit"  name="action" value="Calculate">
  			<input type="submit"  name="action" value="I am Feeling Lucky">
   		</td>
	</tr>	
	<tr>
   		<td>
  		</td>
  		<td>
  			Result  
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
