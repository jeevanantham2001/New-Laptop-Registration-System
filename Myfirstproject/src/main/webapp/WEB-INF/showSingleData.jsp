<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="showSingleData.css">
</head>
<body style="background-color:blue;">

<%@ page import="java.sql.*" %>
<form action="/getSingleLaptop" method="get">
<label style="color:white;">Enter your Laptop ID:</label><br>
<input placeholder="Enter your Laptop ID" type="number"/>
<button type="submit">Search</button>
</form>
<%
  session.getAttribute("laptop");
 	
%>
<table>
    <tr style="color:red;">
        <th>ID</th>
        <th>BRAND</th>
        <th>PRICE</th>
        <!-- Add more table headers for other properties -->
    </tr>
    <c:forEach var="laptop" items="${id}">
        <tr style="color:white;">
            <td>${laptop.id}</td>
            <td>${laptop.brand}</td>
            <td>${laptop.price}</td>
            <!-- Add more table data cells for other properties -->
        </tr>
    </c:forEach>
</table>


</body>
</html>