package controllers;

import entities.Station;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositories.GasStationRepository;
import validators.StationValidator;


@WebServlet(name = "AddStationServlet", urlPatterns = {"/AddStationServlet"})
public class AddStationServlet extends HttpServlet {

    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GasStationRepository gsRep = new GasStationRepository();
        Station station = new Station(request.getParameter("orgname"), request.getParameter("country"), request.getParameter("city"),
                request.getParameter("street"), tryParseToInt(request.getParameter("capacity")));
        StationValidator validator = new StationValidator();
        List<String> errorList = validator.checkAddition(station);
        if (errorList.isEmpty()) {
            gsRep.addNewStation(station);
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
