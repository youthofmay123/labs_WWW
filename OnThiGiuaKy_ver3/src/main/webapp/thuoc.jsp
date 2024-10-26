<%@ page import="vn.iuh.edu.fit.onthigiuaky_ver3.models.Thuoc" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.iuh.edu.fit.onthigiuaky_ver3.models.LoaiThuoc" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/25/2024
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Thuoc JSP</title>
  </head>
  <body>
    <h1>Thuoc JSP</h1>
    <a href="thuoc?action=them-thuoc">Them thuoc</a>
    <% List<LoaiThuoc> loaiThuocList = (List<LoaiThuoc>) request.getAttribute("listLoaiThuoc"); %>
    <form action="thuoc?action=list-thuoc-theo-loai" method="post">
      <select name="select-loai-thuoc">
          <%
        for(LoaiThuoc loaiThuoc : loaiThuocList)
        {
      %>
        <option value="<%=loaiThuoc.getTenLoai()%>"><%=loaiThuoc.getTenLoai()%></option>
      <%
        }
      %>
        <input type="submit" value="Lọc">
    </form>

    </select>
    <table>
      <tr>
        <th style="border: 1px gray solid; padding: 5px">Ma Thuoc</th>
        <th style="border: 1px gray solid; padding: 5px">Ten thuoc</th>
        <th style="border: 1px gray solid; padding: 5px">Gia</th>
        <th style="border: 1px gray solid; padding: 5px">Nam san xuat</th>
        <th style="border: 1px gray solid; padding: 5px">Loai thuoc</th>
      </tr>

      <% List<Thuoc> listThuoc = (List<Thuoc>) request.getAttribute("listThuoc"); %>
      <% for (Thuoc thuoc: listThuoc) {
      %>
      <tr>
        <td style="border: 1px gray solid; padding: 5px"><%=thuoc.getMaThuoc()%></td>
        <td style="border: 1px gray solid; padding: 5px"><%=thuoc.getTenThuoc()%></td>
        <td style="border: 1px gray solid; padding: 5px"><%=thuoc.getGia()%></td>
        <td style="border: 1px gray solid; padding: 5px"><%=thuoc.getNamSX()%></td>
        <td style="border: 1px gray solid; padding: 5px"><%=thuoc.getLoaiThuoc().getTenLoai()%></td>
      </tr>
        <%
          }
        %>

    </table>
  </body>
</html>
