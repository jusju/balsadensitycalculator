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
		<img src="images/sil-tunnus-sininen.jpg" width="100" height="100"
			class="ribbon" />
	</div>


	<h1>Tunnistaudu</h1>
	<table border="1">
		<form action="JukkaController">

			<input type="hidden" name="thickness"> 
			<input type="hidden" name="length"> 
			<input type="hidden" name="width"> 
			<input type="hidden" name="weight">

			<th>
			<td></td>
			<td></td>
			<td></td>
			</th>
			<tr>
				<td></td>
				<td>Salasana (vinkki: maailman tarkoitus lukema)</td>
				<td><input type="password" name="salasana"></td>
			</tr>

			<tr>
				<td></td>
				<td></td>
				<td><input type="submit" class="btn btn-success" name="action"
					value="Laske"></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
			</tr>

		</form>
	</table>


</body>
</html>
