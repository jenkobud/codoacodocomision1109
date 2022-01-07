package controllers;

import models.PartakersDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "PartakersController", value = "/PartakersController")
public class PartakersController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String state = request.getParameter("state");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        Integer id = Integer.parseInt(request.getParameter("partakerId"));
        Integer age = Integer.parseInt(request.getParameter("age"));
        Date registeredDate = Date.valueOf(request.getParameter("registered-date"));
        String add = request.getParameter("add");
        Boolean isNewUser = Boolean.valueOf(add);
        PartakersDAO partakersDAO = new PartakersDAO();

        try {
            if (isNewUser){ partakersDAO.addNewPartaker(name, lastname, age, registeredDate, state, email, address); }
            else{ partakersDAO.modifyPartakerById(id, name, lastname, age, registeredDate, state, email, address); }
        }catch (SQLException e){
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath()+"/partakers-abm.jsp");
    }
}
