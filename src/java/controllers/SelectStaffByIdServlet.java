package controllers;

import entities.Staff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositories.StaffRepository;


@WebServlet(name = "SelectStaffByIdServlet", urlPatterns = {"/SelectStaffByIdServlet"})
public class SelectStaffByIdServlet extends HttpServlet {


    protected void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StaffRepository staffRep = new StaffRepository();
        Staff staff = staffRep.findStaffById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("station_id", staff.getStationId());
        request.setAttribute("surname", staff.getSurname());
        request.setAttribute("name", staff.getName());
        request.setAttribute("gender", staff.getGender());
        request.setAttribute("function", staff.getFunction());
        request.setAttribute("salary", staff.getSalary());


        request.getRequestDispatcher("UpdateStaffPage.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        execute(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        execute(request, response);
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
