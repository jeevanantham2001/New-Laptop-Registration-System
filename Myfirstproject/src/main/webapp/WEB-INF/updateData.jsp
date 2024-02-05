<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
</head>
<body>
<form action="/updateData" method="post">
<h2>Updation Page</h2>
<div class="box">
<label>Enter the Laptop Id</label> <br>
<input type="text" name="id"><br>
<label>Enter the Laptop brand</label><br>
<input type="text" name="brand"><br>
<label>Enter the Laptop price</label><br>
<input type="text" name="price"><br><br>
<div class="box1"><button>Submit</button></div>
</div>
</form>
</body>
</html>