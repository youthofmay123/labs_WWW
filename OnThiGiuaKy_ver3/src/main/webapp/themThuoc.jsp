<%@ page import="java.util.List" %>
<%@ page import="vn.iuh.edu.fit.onthigiuaky_ver3.models.LoaiThuoc" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Them Thuoc JSP</title>
</head>
<body>
<%
  List<LoaiThuoc> loaiThuocs = (List<LoaiThuoc>) request.getAttribute("loaiThuocs");
  if (loaiThuocs != null) {
%>
<h1>Them Thuoc JSP</h1>
<form action="thuoc?action=them-thuoc" method="post">
  <input type="text" name="tenThuoc" id="tenThuoc" placeholder="Nhap ten thuoc">
  <input type="text" name="giaThuoc" id="giaThuoc" placeholder="Nhap gia thuoc">
  <input type="text" name="namSanXuat" id="namSanXuat" placeholder="Nhap nam san xuat">

  <select name="tenLoaiThuoc">
    <%
      for (LoaiThuoc loaiThuoc : loaiThuocs) {
    %>
    <option value="<%= loaiThuoc.getTenLoai() %>"><%= loaiThuoc.getTenLoai() %></option>
    <%
      }
    %>
  </select>
  <input type="submit" name="submit" value="Thêm Thuốc">
</form>
<%
} else {
%>
<p>Danh sách loại thuốc trống.</p>
<%
  }
%>
</body>
</html>
