<!DOCTYPE>
<html>
<head>
<title>Homepage</title>
</head>
<body>
	${ list }
	<form action="displayuser">
		UID : <br> <input type="text" name="uid" /> <br> <input
			type="submit" />
	</form>
	<div class="diplayuser" id="div1">
		<p id="user">Username: ${user.name}</p>
		<p id="user">Uid: ${user.uid}</p>
		<p id="user">Username: ${user.password}</p>
	</div>
	<button title="listall" onclick="listall" />
</body>
<script>
	
</script>
</html>