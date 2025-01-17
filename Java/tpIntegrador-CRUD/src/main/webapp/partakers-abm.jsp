<%@ page import="controllers.PartakersController" %>
<%@ page import="models.PartakersDAO" %>
<%@ page import="models.Partaker" %>
<%@ page import="controllers.LoginController" %>
<%@ page import="java.sql.SQLException" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 1/1/22
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Boolean logged = false;
    if (request.getSession().getAttribute("logged") != null) logged = (Boolean) request.getSession().getAttribute("logged");
    if (!logged) response.sendRedirect(request.getContextPath() + "/login.jsp");
%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="jenkobud, and Bootstrap contributors">
    <meta name="generator" content="jenkobud">

    <title>Partakers CRUD</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <!-- Bootstrap Font-Icons CSS-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

    <!-- Custom styles for this template -->
    <link href="general-style.css" rel="stylesheet">

    <meta name="theme-color" content="#7952b3">


    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>

</head>
<% PartakersDAO partakersDAO = new PartakersDAO(); %>
<body class="green-background text-white">
<nav class="navbar navbar-dark bg-dark" aria-label="First navbar example">
    <div class="container-fluid">
        <a class="navbar-brand" href="<%= request.getContextPath() + "/partakers-abm.jsp"%>">Dashboard</a>
        <div class="dropdown">
            <button class="btn dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown"
                    aria-controls="navbarsExample01" aria-expanded="false">
                <i class="bi bi-person-fill text-white"></i></span><span class="text-white"> <%=request.getSession().getAttribute("user")%></span>
            </button>
            <ul class="dropdown-menu dropdown-menu-dark bg-dark w-100" aria-labelledby="dropdownMenuButton1">
                <li><a class="dropdown-item disabled" href="#"><i class="bi bi-person-fill"></i> <%=request.getSession().getAttribute("user")%></a>
                </li>
                <li>
                    <hr class="dropdown-divider">
                </li>
                <li><a class="dropdown-item" href="#">Log out</a></li>
            </ul>
        </div>

    </div>
</nav>
<main class="container-fuild">
    <div class="spacer"></div>
    <div class="flex text-center">
        <h2>Partakers CRUD</h2>
    </div>
    <div class="spacer"></div>
    <table class="table table-dark table-striped mx-1">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nombre</th>
            <th scope="col">Apellido</th>
            <th scope="col">Edad</th>
            <th scope="col">Fecha de Ingreso</th>
            <th scope="col">Provincia</th>
            <th scope="col">Email</th>
            <th scope="col">Dirección</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Partaker p : partakersDAO.getStudents()){
        %>
                <tr>
                    <th scope="row"><span class="d-none" id="partakerId" name="partakerId"> <%=p.getId()%> </span></th>
                    <td id="nameId" name="name"><%=p.getNames()%></td>
                    <td id="lastNameId" name="lastName"><%=p.getLastnames()%></td>
                    <td id="ageId" name="age"><%=p.getAge()%></td>
                    <td id="registeredDateId" name="registeredDate"><%=p.getRegisteredDate()%></td>

                    <td id="stateId" name="state"><%=p.getProvince()%></td>
                    <td id="emailId" name="email"><%=p.getEmail()%></td>
                    <td id="addressId" name="address"><%=p.getAddress()%></td>
                    <%
                        String editPartakerUrl = request.getContextPath() + "/partakers-modify.jsp"
                        + "?add=false&partakerId="+p.getId()+"&name='"+p.getNames()+"'&lastname='"+p.getLastnames()+"'&age="+p.getAge()+
                                "&registeredDate='"+p.getRegisteredDate()+"'&state='"+p.getProvince()+"'&email='"+p.getEmail()+"'&address='"+p.getAddress()+"'";
                        String removePartakerUrl = request.getContextPath() + "/PartakersController?remove='true'&id=" + p.getId();
                    %>
                    <td><a class="btn btn-warning" href="<%=editPartakerUrl%>"><i class="bi bi-pencil-square"></i></a></td>
                    <td><a class="btn btn-danger" href="<%=removePartakerUrl%>"><i class="bi bi-trash"></i></a></td>
                </tr>
        <% }
            try { partakersDAO.closeDB(); }
            catch (SQLException e) { e.printStackTrace(); }
        %>
        </tbody>
    </table>
    <div class="flex text-center">
        <%
            String addNewUrl = request.getContextPath() + "/partakers-modify.jsp"
                    + "?add=true&partakerId=-1&name=''&lastname=''&age=&registeredDate=''&state=''&email=''&address=''";
        %>
        <a href="<%=addNewUrl%>" class="btn btn-lg btn-success">Add new Partaker <i class="bi bi-person-plus-fill"></i></a>
    </div>
</main>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
</body>

</html>
