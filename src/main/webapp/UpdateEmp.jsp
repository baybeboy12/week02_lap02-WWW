<%@ page import="vn.edu.iuh.fit.models.Employee" %>
<%@ page import="java.util.Optional" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/13/2023
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Employee</title>
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

        input.text, select.text {
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
    <h1>Update Employee</h1>
</header>
<div class="container">
    <%
        Optional<Employee> em = (Optional<Employee>) request.getAttribute("employee") ;
    %>
    <form action="updateEmployee" method="post">
        <label>ID:</label>
        <input type="text" name="ID" class="text" value="<%=em.get().getEmpId()%>" required>

        <label>Họ và Tên:</label>
        <input type="text" name="fullNameUp" class="text" value="<%=em.get().getFullName()%>" required>

        <label>Số điện thoại:</label>
        <input type="text" name="phoneUp" class="text" value="<%=em.get().getPhone()%>"required>

        <label>Địa chỉ:</label>
        <input type="text" name="addressUp" class="text" value="<%=em.get().getAddress()%>" required>

        <label>Email:</label>
        <input type="text" name="emailUp" class="text"  value="<%=em.get().getEmail()%>" required>

        <label>Date of birth:</label>
        <input type="date" name="dateUp" class="text" value="<%=em.get().getDob()%>" required>

        <label>Status:</label>
        <select name="statusUp" class="text" required>
            <option value="<%=em.get().getEmpId()%>>">ACTIVE</option>
            <option value="INACTIVE">INACTIVE</option>
        </select>

        <button type="submit" name="submit" value="submit">Xác nhận</button>

    </form>
    <button class="btn btn-success"><a style="text-decoration: none" class="corner-link" href="ListEmp.jsp.jsp">Quay lại danh sách</a></button>
</div>
</body>
</html>
