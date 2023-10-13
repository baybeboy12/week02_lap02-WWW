<%@ page import="vn.edu.iuh.fit.Services.EmployeeService" %>
<%@ page import="vn.edu.iuh.fit.models.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/13/2023
  Time: 4:06 PM
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
            max-width: 800px;
            margin: 0 auto;
            margin-top: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }

        th {
            background-color: #007BFF;
            color: #fff;
        }

        tbody tr:nth-child(odd) {
            background-color: #f4f4f4;
        }

        tbody tr:nth-child(even) {
            background-color: #fff;
        }

        .btn {
            text-align: center;
        }

        a.corner-link {
            color: #007BFF;
        }

        .btn-primary {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 5px 10px;
            border-radius: 3px;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }

        .btn-warning {
            background-color: #ffc107;
            color: #333;
            border: none;
            padding: 5px 10px;
            border-radius: 3px;
        }

        .btn-warning:hover {
            background-color: #e0a800;
        }

        .bi-trash, .bi-pencil-square {
            margin-right: 5px;
        }
    </style>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12 mt-4">
            <table class="table table-hover">
                <thead class="table-light">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Address</th>
                    <th scope="col">Dob</th>
                    <th scope="col">Email</th>
                    <th scope="col">FullName</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Status</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <%
                    EmployeeService services = new EmployeeService();
                    List<Employee> list = services.getAllEmp();
                    for (Employee dsEmp: list) {
                %>
                <tbody style="background: #f4f4f4">
                <tr>
                    <td><%=dsEmp.getEmpId()%>
                    </td>
                    <td><%=dsEmp.getAddress()%>
                    </td>
                    <td><%=dsEmp.getDob()%>
                    </td>
                    <td><%=dsEmp.getEmail()%>
                    </td>
                    <td>
                        <%=dsEmp.getFullName()%>
                    </td>
                    <td><%=dsEmp.getPhone()%>
                    </td>
                    <td><%=dsEmp.getStatus()%>
                    </td>
                    <td>
                        <button class="btn btn-primary bi bi-trash"
                                name="delete"><a style="text-decoration: none" href="deleteEmployee?idEmployee=<%=dsEmp.getEmpId()%>">Delete</a>
                        </button>
                        <button class="btn btn-warning bi bi-pencil-square"
                                name="update"><a style="text-decoration: none" href="loadInfEmpIntoUpdateForm?employeeID=<%=dsEmp.getEmpId()%>">Update</a></button>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>

    <button class="btn btn-success" ><a style="text-decoration: none" class="corner-link" href="InsertEmp.jsp">Thêm employee</a></button>
    <button class="btn btn-success"><a style="text-decoration: none" class="corner-link" href="index.jsp">Quay lại menu</a></button>


</div>
</body>
</html>
