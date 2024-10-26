<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 9/21/2024
  Time: 7:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
    <link rel="stylesheet" type="text/css" href="AddProductView.css">
</head>
<body>
<form action="controller" method="get">
    <h1>Add Product</h1>
    <input type="hidden" name="action" value="add"> <br/>
    Enter product name : <input type="text" name="name"/> <br/>
    Enter product description: <input type="text" name="desc"/> <br/>
    Enter product image path: <input type="text" name="imgPath"/> <br/>
    <input type="submit" value="Insert"/>
    <input type="reset"/>
</form>
<form action="controller" method="get">
    <input type="hidden" name="action" value="list"> <br/>
    <input type="submit" value="View List Products"/>
</form>
</body>
</html>
