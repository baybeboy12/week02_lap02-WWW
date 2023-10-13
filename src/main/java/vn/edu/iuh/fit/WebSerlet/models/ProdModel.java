package vn.edu.iuh.fit.WebSerlet.models;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.Services.ProductService;
import vn.edu.iuh.fit.enums.ProductStatus;
import vn.edu.iuh.fit.models.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class ProdModel {
    private final ProductService services = new ProductService();


    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id =Long.parseLong(request.getParameter("idProduct"));
        boolean rs = services.deletePro(id);
        PrintWriter out = response.getWriter();
        if(rs){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Delete Success!');");
            out.println("location='ListPro.jsp';");
            out.println("</script>");
        }
    }
    public void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        long id = Long.parseLong(request.getParameter("prod_id"));
        String name = request.getParameter("name");
        String des = request.getParameter("description");
        String nsx = request.getParameter("nsx");
        String unit = request.getParameter("unit");
        Product pro = new Product(id,des,nsx,name, ProductStatus.ACTIVE,unit);
        boolean rs = services.insertPro(pro);
        PrintWriter out = response.getWriter();
        if(rs){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Insert Success!');");
            out.println("location='ListPro.jsp';");
            out.println("</script>");
        }
    }
    public void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        long id = Long.parseLong(request.getParameter("idProduct"));
        String name = request.getParameter("nameUp");
        String des = request.getParameter("descriptionUp");
        String nsx = request.getParameter("nsxUp");
        String unit = request.getParameter("unitUp");
        String status = request.getParameter("statusUp");
        ProductStatus statusPro;

        if ("ACTIVE".equals(status)) {
            statusPro = ProductStatus.ACTIVE.ACTIVE;
        } else if ("INACTIVE".equals(status)) {
            statusPro = ProductStatus.IN_ACTIVE.IN_ACTIVE;
        } else {
            statusPro = null;
        }
        Product pro = new Product(id,des,nsx,name, statusPro,unit);
        boolean rs = services.updatePro(pro);
        PrintWriter out = response.getWriter();
        if(rs){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Update Success!');");
            out.println("location='ListPro.jsp';");
            out.println("</script>");
        }
    }
    public void loadInfProIntoUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        long id =Long.parseLong(request.getParameter("productID"));
        Optional<Product> product = services.findById(id);
        request.setAttribute("loadInfo",product);
        request.getRequestDispatcher("UpdatePro.jsp").forward(request,response);
    }
}
