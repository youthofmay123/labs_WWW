<%@ page import="vn.iuh.edu.fit.onthigiuaky_ver3.models.LoaiThuoc" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/25/2024
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Loai Thuoc JSP</title>
</head>
<body>
<h1>Loai Thuoc JSP</h1>
<a href="themLoaiThuoc.jsp">Them loai thuoc</a>

<table>
    <tr>
        <th style="border: 1px gray solid; padding: 5px">Ma Loai Thuoc</th>
        <th style="border: 1px gray solid; padding: 5px">Ten Loai thuoc</th>
    </tr>

        <% List<LoaiThuoc> listLoaiThuoc = (List<LoaiThuoc>) request.getAttribute("listLoaiThuoc"); %>
        <% for (LoaiThuoc loaiThuoc: listLoaiThuoc) {
        %>
        <tr>
            <td style="border: 1px gray solid; padding: 5px"><%=loaiThuoc.getMaLoai()%></td>
            <td style="border: 1px gray solid; padding: 5px"><%=loaiThuoc.getTenLoai()%></td>
        </tr>
        <%
            }
        %>

</table>
</body>
</html>
