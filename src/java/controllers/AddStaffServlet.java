package controllers;

import entities.Staff;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositories.StaffRepository;
import validators.StaffValidator;


@WebServlet(name = "AddStaffServlet", urlPatterns = {"/AddStaffServlet"})
public class AddStaffServlet extends HttpServlet {
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StaffRepository staffRep = new StaffRepository();
        Staff staff = new Staff(tryParseToInt(request.getParameter("station_id")), request.getParameter("surname"), request.getParameter("name"), request.getParameter("gender"),
                request.getParameter("function"), tryParseToInt(request.getParameter("salary")));
        StaffValidator validator = new StaffValidator();
        List<String> errorList = new ArrayList<String>();
        errorList = validator.checkAddition(staff);
        if (errorList.isEmpty()) {
            staffRep.addNewStaff(staff);
        } else {
            request.setAttribute("errors", errorList);
            request.getRequestDispatcher("ErrorList.jsp").forward(request, response);
        }
    }

    public Integer tryParseToInt(String incomeString) {
        Integer outInt;
        try {
            outInt = Integer.parseInt(incomeString);
        } catch (Exception e) {
            outInt = 0;
        }

        return outInt;
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
