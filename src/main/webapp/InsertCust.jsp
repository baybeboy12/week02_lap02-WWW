<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/13/2023
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Customer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            max-width: 400px;
            margin: 0 auto;
            margin-top: 20px;
        }

        h1 {
            text-align: center;
        }

        label {
            display: block;
            margin-top: 10px;
        }

        input.text {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        button {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 3px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        .btn {
            text-align: center;
        }

        a.corner-link {
            color: #007BFF;
        }
    </style>
</head>
<body>
<header>
    <h1>Insert Customer</h1>
</header>
<div class="container">
    <form action="insertCustomer" method="post">
        <label>Cust ID:</label>
        <input type="text" name="cust_id" class="text" required>
        <label>Họ và Tên:</label>
        <input type="text" name="fullName" class="text" required>

        <label>Số điện thoại:</label>
        <input type="text" name="phone" class="text" required>

        <label>Địa chỉ:</label>
        <input type="text" name="address" class="text" required>

        <label>Email:</label>
        <input type="text" name="email" class="text" required>
        <button type="submit" name="submit" value="submit">Xác nhận</button>
    </form>
    <div class="btn">
        <button class="btn btn-success"><a style="text-decoration: none" class="corner-link" href="listCustomer.jsp">Quay lại danh sách</a></button>
    </div>
</div>
</body>
</html>
