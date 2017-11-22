/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.kikelonches.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.itesm.kikelonches.util.DBConnection;
import com.google.gson.Gson;
import java.util.Map;
import java.util.HashMap;
import mx.itesm.kikelonches.manager.ProductManager;

/**
 *
 * @author Morales
 */
@WebServlet(name = "addProduct", urlPatterns = {"/addProduct"})
public class AddProductServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Map data = new HashMap();
        String err = "Server error: ";
        try {
            String nombre = request.getParameter("P_nombre");
            String descripcion = request.getParameter("P_descripcion");
            String precio = request.getParameter("P_precio");
            String cantidad_inventario = request.getParameter("P_cantidad_inventario");
            
            DBConnection dBConnection = new DBConnection();

            ProductManager productoM = new ProductManager(dBConnection);
            productoM.addProducto(nombre, descripcion, Double.parseDouble(precio), Integer.parseInt(cantidad_inventario));
            dBConnection.endConnection();
            
            data.put("success", "true");
            data.put("message", "");
        } catch (SQLException ex) {
            Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, ex.toString());
            data.put("success", "false");
            data.put("message", err+ex.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, ex.toString());
            data.put("success", "false");
            data.put("message", err+ex.toString());
        } catch (Exception ex){
            Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, ex.toString());
            data.put("success", "false");
            data.put("message", err+ex.toString());
        } finally{
            out.write(new Gson().toJson(data));
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
