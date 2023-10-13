<%@ page import="vn.edu.iuh.fit.models.Product" %>
<%@ page import="java.util.Optional" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/13/2023
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
    <h1>Update Product</h1>
</header>
<div class="container">
    <%
        Optional<Product> product = (Optional<Product>) request.getAttribute("loadInfo");
    %>
    <form action="updateProduct" method="post">
        <label>ID:</label>
        <input type="text" name="idProduct" class="text" value="<%=product.get().getProductId()%>"  required>
        <label>Name:</label>
        <input type="text" name="nameUp" class="text" value="<%=product.get().getName()%>" required>

        <label>Description:</label>
        <input type="text" name="descriptionUp" class="text" value="<%=product.get().getDescription()%>" required>

        <label>ManufacturerName:</label>
        <input type="text" name="nsxUp" class="text" value="<%=product.get().getManufacturerName()%>" required>

        <label>Status:</label>
        <select name="statusUp" class="text" required>
            <option value="<%=product.get().getStatus()%>">ACTIVE</option>
            <option value="INACTIVE">INACTIVE</option>
        </select>

        <label>Unit:</label>
        <input type="text" name="unitUp" class="text" value="<%=product.get().getUnit()%>" required>
        <button type="submit" name="submit" value="submit">Xác nhận</button>
    </form>
    <button class="btn btn-success"><a style="text-decoration: none" class="corner-link" href="ListPro.jsp">Quay lại danh sách</a></button>
</div>

</body>
</html>
