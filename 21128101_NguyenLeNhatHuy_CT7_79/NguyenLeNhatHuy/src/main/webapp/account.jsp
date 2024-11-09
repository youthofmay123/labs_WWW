<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.nguyenlenhathuy.models.Account" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 10/26/2024
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account JSP</title>
</head>
<body>
<div style="display: flex; justify-content: center; align-items: center">
    <div>
        <h1>Account JSP</h1>
        <%
            List<Account> list = (List<Account>)request.getAttribute("listAccount");
        %>

        <a href="addAccount.jsp">Them moi mot tai khoan</a>
        <form action="account?action=loc-danh-sach" method="post">
            <h4 style="padding: 0">Form loc</h4>
            <select name="luaChon">
                <option value="soTien">Tim kiem theo so tien</option>
                <option value="tenChuTK">Tim kiem theo ten chu tai khoan </option>
            </select>
            <input type="text" name="text" placeholder="Nhap tu khoa tim kiem">
            <input type="submit" name="submit" value="Loc">
        </form>

        <table>
            <tr>
                <th style="border: 1px solid gray; padding: 5px">account number</th>
                <th style="border: 1px solid gray; padding: 5px">owner name</th>
                <th style="border: 1px solid gray; padding: 5px">card number</th>
                <th style="border: 1px solid gray; padding: 5px">owner address</th>
                <th style="border: 1px solid gray; padding: 5px">amount</th>
            </tr>
            <%
                for(Account a : list) {
            %>
            <tr>
                <td style="border: 1px solid gray; padding: 5px"><%= a.getAccountNumber() %></td>
                <td style="border: 1px solid gray; padding: 5px"><%= a.getOwner_name() %></td>
                <td style="border: 1px solid gray; padding: 5px"><%= a.getCardNumber() %></td>
                <td style="border: 1px solid gray; padding: 5px"><%= a.getOwnerAddress() %></td>
                <td style="border: 1px solid gray; padding: 5px"><%= a.getAmount() %></td>
            </tr>
            <% } %>

        </table>
    </div>

</div>
</body>
</html>
