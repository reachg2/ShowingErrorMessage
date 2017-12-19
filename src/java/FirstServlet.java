/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author A2A Town
 */
public class FirstServlet extends HttpServlet {

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
        LinkedList <String> errorlist = (LinkedList) request.getAttribute("errorlist"); 
        try 
        {
          if(errorlist!=null)
          {
              out.println("<font color='red'>");
              out.println("<b>");
              out.println("<p>Error Login!</p>");
              out.println("</br>");
              for(int i=0;i<errorlist.size();i++)
              {
                  out.println("</br>"+(i+1)+"."+errorlist.get(i));
              }
              out.println("</br>");
              out.println("<p>-------------------------------------------------</p>");
              
              out.println("</br>");
              out.println("</br>");
              out.println("</b>");
              out.println("</font>");
              
          }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FirstServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='controller' method='post'>");
            out.println("Username: <input type='text' name='user'></br>");
            out.println("Password: <input type='password' name='pass'></br>");
            out.println("<input type='submit' value='Login'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>"); 
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
