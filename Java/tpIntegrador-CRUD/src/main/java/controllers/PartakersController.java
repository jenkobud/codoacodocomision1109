package controllers;

import models.PartakersDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "PartakersController", value = "/PartakersController")
public class PartakersController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String remove = request.getParameter("remove");
        Integer id = Integer.parseInt(request.getParameter("id"));
        PartakersDAO partakersDAO = new PartakersDAO();
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        if (!remove.contains("true")) response.sendRedirect(request.getContextPath()+"/partakers-abm.jsp");
        pw.write("<!DOCTYPE html>");
        pw.write("<html lang=\"es\">");
        pw.write("<head>");
        pw.write("  <meta charset=\"UTF-8\">");
        pw.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        pw.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        pw.write("  <meta name=\"description\" content=\"\">");
        pw.write("  <meta name=\"author\" content=\"jenkobud, and Bootstrap contributors\">");
        pw.write("  <meta name=\"generator\" content=\"jenkobud\">");
        pw.write("  <title>Log in / Sign in</title>");
        pw.write("  <link rel=\"canonical\" href=\"https://getbootstrap.com/docs/5.0/examples/sign-in/\">");
        pw.write("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"");
        pw.write("    integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");
        pw.write("  <link href=\"signin.css\" rel=\"stylesheet\">");
        pw.write("  <link rel=\"stylesheet\" href=\"general-style.css\">");
        pw.write("  <style>");
        pw.write("    .bd-placeholder-img {");
        pw.write("      font-size: 1.125rem;");
        pw.write("      text-anchor: middle;");
        pw.write("      -webkit-user-select: none;");
        pw.write("      -moz-user-select: none;");
        pw.write("      user-select: none;");
        pw.write("    }");
        pw.write("    @media (min-width: 768px) {");
        pw.write("      .bd-placeholder-img-lg {");
        pw.write("        font-size: 3.5rem;");
        pw.write("      }");
        pw.write("    }");
        pw.write("  </style>");
        pw.write("</head>");
        pw.write("<body class=\"text-center green-background\">");
        pw.write("  <main class=\"form-signin rounded-3\" style=\"background-color: cadetblue;\">");
        pw.write("    <div class=\"spacer\"></div>");
        try {
            partakersDAO.deletePartakerById(id);
            pw.write("    <p class=\"\" >Partaker deleted successfully.</p>");
        } catch (SQLException e) {
            e.printStackTrace();
            pw.write("    <p class=\"text-warning\" >Partaker deleted successfully.</p>");
        }
        pw.write("    <div class=\"spacer\"></div>");
        pw.write("    <a href=\"javascript:history.back()\" class=\"btn btn-lg btn-warning\">Go Back</a>");
        pw.write("  </main>");
        pw.write("  <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js\"");
        pw.write("    integrity=\"sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB\"");
        pw.write("    crossorigin=\"anonymous\"></script>");
        pw.write("  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js\"");
        pw.write("    integrity=\"sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13\"");
        pw.write("    crossorigin=\"anonymous\"></script>");
        pw.write("</body></html>");
        pw.close();

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
            partakersDAO.closeDB();
        }catch (SQLException e){ e.printStackTrace(); }
        response.sendRedirect(request.getContextPath()+"/partakers-abm.jsp");
    }
}
