<%@ page import="java.util.List" %>
<%@ page import="vn.com.iuh.fit.backend.repositories.entities.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Products</title>
    <link rel="stylesheet" type="text/css" href="ListProduct.css">
    <script>
        function deleteProduct(productId) {
            if (confirm('Are you sure you want to delete this product?')) {
                window.location.href = 'controller?action=delete&id=' + productId;
            }
        }
    </script>
</head>
<body>
<div class="function-bar">
    <h1>List of Products</h1>
    <form action="controller" method="get">
        <input type="hidden" name="action" value="goAdd"> <br/>
        <input type="submit" value="Add a new product"/>
    </form>
</div>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Image Path</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Product> listProduct = (List<Product>) session.getAttribute("products");
        if (listProduct != null && !listProduct.isEmpty()) {
            for (Product p : listProduct) {
    %>
    <tr>
        <td><%= p.getName() %>
        </td>
        <td><%= p.getDescription() %>
        </td>
        <td><%= p.getImgPath() %>
        </td>
        <td>
            <button type="button" value="eidtProduct" onclick="window.location.href='controller?action=edit&id=<%= p.getId() %>'">Edit</button>
            <button type="button" value="deleteProduct" onclick="deleteProduct(<%= p.getId() %>)">Delete</button>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="3"> No products available</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>