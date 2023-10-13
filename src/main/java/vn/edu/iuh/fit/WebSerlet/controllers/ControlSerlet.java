package vn.edu.iuh.fit.WebSerlet.controllers;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.WebSerlet.models.CustModel;
import vn.edu.iuh.fit.WebSerlet.models.EmpModel;
import vn.edu.iuh.fit.WebSerlet.models.ProdModel;

@WebServlet("/")
public class ControlSerlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProdModel productModel = new ProdModel();
        EmpModel employeeModel = new EmpModel();
        CustModel customerModel = new CustModel();
        String action = request.getServletPath();
        switch (action){
            case "/deleteCustomer":
                customerModel.deleteCustomer(request,response);
                break;
            case "/insertCustomer":
                customerModel.insertCustomer(request,response);
                break;
            case "/loadInfIntoUpdateForm":
                customerModel.loadInfIntoUpdateForm(request,response);
                break;
            case "/updateCustomer":
                customerModel.updateCustomer(request,response);
                break;
            case "/deleteEmployee":
                employeeModel.deleteEmp(request,response);
                break;
            case "/insertEmployee":
                employeeModel.insertEmployee(request,response);
                break;
            case "/loadInfEmpIntoUpdateForm":
                employeeModel.loadInfIntoUpdateForm(request,response);
                break;
            case "/updateEmployee":
                employeeModel.updateEmployee(request,response);
                break;
            case "/insertProduct":
                productModel.insertProduct(request,response);
                break;
            case "/deleteProduct":
                productModel.deleteProduct(request,response);
                break;
            case "/loadInfProIntoUpdateForm":
                productModel.loadInfProIntoUpdateForm(request,response);
                break;
            case "/updateProduct":
                productModel.updateProduct(request,response);
                break;
            default:
                break;
        }
    }
}