<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            max-width: 800px;
            margin: 0 auto;
            margin-top: 20px;
            text-align: center;
        }

        .corner-links {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }

        .corner-link {
            text-decoration: none;
            padding: 10px 20px;
            background-color: #007BFF;
            color: #fff;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .corner-link:hover {
            background-color: #0056b3;
        }

        .page-title {
            font-size: 24px;
            margin-top: 20px;
        }
    </style>

</head>
<body>
<div class="container">
    <div class="corner-links">
        <a style="text-decoration: none" class="corner-link" href="ListCust.jsp">Customer List</a>
        <a style="text-decoration: none" class="corner-link" href="ListPro.jsp">Product List</a>
        <a style="text-decoration: none" class="corner-link" href="ListEmp.jsp">Employee List</a>
        <a style="text-decoration: none" class="corner-link" >ProductPrice List</a>
        <a style="text-decoration: none" class="corner-link" >Order List</a>
    </div>
    <h1 class="page-title">Xin chào</h1>
</div>
</body>
</html>