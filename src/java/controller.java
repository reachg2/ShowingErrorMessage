/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author A2A Town
 */
public class controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("user").trim();
        String pass = request.getParameter("pass").trim();
        
        LinkedList <String> errorlist = new LinkedList<String>();
        
        try {
            if(!(user.equals("reach")&&pass.equals("123")))
            {
            if(user==null|| user.isEmpty())
            {
                errorlist.add("The username is empty!");
            }
             if(user.matches(".*\\d.*"))
            {
                errorlist.add("The username must not contain any number!");
            }
            if(pass==null||pass.isEmpty())
            {
                errorlist.add("The password is empty!");
            }
            if(errorlist.isEmpty())
            {
                errorlist.add("The username or password is incorrect!");
            }
            }
            
            if(!(errorlist.isEmpty()))
            {
                request.setAttribute("errorlist",errorlist);
                RequestDispatcher rd = request.getRequestDispatcher("FirstServlet");
                rd.forward(request,response);
            }
            else
            {
                errorlist = null;
                RequestDispatcher rd = request.getRequestDispatcher("SuccessServlet");
                rd.forward(request,response);
            }
        }
        catch(Exception e)
        {
            
        }
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

}
