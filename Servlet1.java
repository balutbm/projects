package cc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                try {
                    Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
                    PreparedStatement ps=con.prepareStatement("SELECT * FROM CURRENCYTABLE");
                    ResultSet rs=ps.executeQuery();
                    out.println("<select name=countryname>");                    
                    while(rs.next()){
                        out.print("<option>");
                        out.print(rs.getString(1));
                        out.println("</option>");
                    }out.println("</select>");
                    
                    PreparedStatement ps2=con.prepareStatement("SELECT * FROM CURRENCYTABLE");
                    ResultSet rs2=ps.executeQuery();
                    out.println("<select name=currencytype>");                    
                        while(rs2.next()){
                        out.print("<option>");
                        out.print(rs2.getString(2));
                        out.println("</option>");
                    }
                    out.println("</select>");
                } catch (SQLException ex) {
                    Logger.getLogger(Servlet1.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Servlet1.class.getName()).log(Level.SEVERE, null, ex);
            }

            out.println("</html>");
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
