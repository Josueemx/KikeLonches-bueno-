/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.kikelonches.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.itesm.kikelonches.manager.UserManager;
import mx.itesm.kikelonches.util.DBConnection;

/**
 *
 * @author Morales
 */
@WebServlet(name = "getAllUsuarios", urlPatterns = {"/getAllUsuarios"})
public class GetAllUsuariosServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Map data = new HashMap();
        String err = "Server error: ";
        try {
            DBConnection dBConnection = new DBConnection();
            UserManager userM = new UserManager(dBConnection);
            List usuarios = userM.getAllUsers();
            dBConnection.endConnection();
            
            data.put("success", "true");
            data.put("message", "");
            data.put("usuarios", usuarios);
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
    }// </editor-fold>

}
