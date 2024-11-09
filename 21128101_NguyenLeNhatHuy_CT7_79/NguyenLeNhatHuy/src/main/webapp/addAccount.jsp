<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 10/26/2024
  Time: 7:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Them moi</title>
</head>
<body>
    <div style="display: flex; justify-content: center; align-items: center">
        <form  action="account?action=them-tai-khoan" method="post">
            <h4 style="padding: 0">Form them tai khoan</h4>
            <input style="margin: 10px; width: 250px" name="accountNumber" type="text" placeholder="Nhap so tai khoan "> <br/>
            <input style="margin: 10px; width: 250px" name="ownerName" type="text" placeholder="Nhap ho ten "> <br/>
            <input style="margin: 10px; width: 250px" name="cardNumber" type="text" placeholder="Nhap so the "> <br/>
            <input style="margin: 10px; width: 250px" name="ownerAddress" type="text" placeholder="Nhap dia chi "> <br/>
            <input style="margin: 10px; width: 250px" name="amount" type="text" placeholder="Nhap so tien "> <br/>
            <input style="margin: 10px; width: 250px" type="submit" value="Them tai khoan">
        </form>
    </div>

</body>
</html>
