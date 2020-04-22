/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brkic.milos.fon.fisweb.servlet;

import brkic.milos.fon.fisweb.action.AllDepartmentsAction;
import brkic.milos.fon.fisweb.action.AbstractAction;
import brkic.milos.fon.fisweb.action.AddDepartmentAction;
import brkic.milos.fon.fisweb.action.DeleteDepartmentAction;
import brkic.milos.fon.fisweb.action.EditDepartmentAction;
import brkic.milos.fon.fisweb.action.LoginAction;
import brkic.milos.fon.fisweb.action.SaveDepartmentAction;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author milos
 */
@WebServlet(name = "FrontControler", urlPatterns = {"/app/*"})
public class FrontControler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String page = "/";
               
        AbstractAction action = null;
        
        if(request.getPathInfo().equals("/login"))
            action = new LoginAction();                        
               
        if(request.getPathInfo().equals("/departments"))
            action = new AllDepartmentsAction();
        
        if(request.getPathInfo().equals("/new"))
            action = new AddDepartmentAction();
        
        if(request.getPathInfo().equals("/save"))
            action = new SaveDepartmentAction();
        
        if(request.getPathInfo().startsWith("/delete/"))
            action = new DeleteDepartmentAction();
        
        if(request.getPathInfo().startsWith("/edit/"))
            action = new EditDepartmentAction();
        
        if(action != null)
            page = action.execute(request);
              
        request.getRequestDispatcher(page).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

    @Override
    public void init() throws ServletException {
        super.init();
    }
    
    
}

