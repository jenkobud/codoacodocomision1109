<%@ page import="models.Partaker" %>
<%@ page import="java.sql.Date" %><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 1/1/22
  Time: 17:40
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

  <title>Modify Partakers</title>

  <!-- Bootstrap core CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

  <!-- Bootstrap Font-Icons CSS-->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

  <!-- Custom styles for this template -->
  <link href="general-style.css" rel="stylesheet">
  
  <style>
    html{ height: 100%; }
  </style>

</head>

<body class="green-background h-100">
  <nav class="navbar navbar-dark bg-dark" aria-label="First navbar example">
    <div class="container-fluid">
      <a class="navbar-brand" href="<%= request.getContextPath() + "/partakers-abm.jsp"%>">Dashboard</a>
      <div class="dropdown">
        <button class="btn dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown"
                aria-controls="navbarsExample01" aria-expanded="false">
          <i class="bi bi-person-fill text-white"></i></span><span
                class="text-white"> <%=request.getSession().getAttribute("user")%></span>
        </button>
        <ul class="dropdown-menu dropdown-menu-dark bg-dark w-100" aria-labelledby="dropdownMenuButton1">
          <li><a class="dropdown-item disabled" href="#"><i
                  class="bi bi-person-fill"></i> <%=request.getSession().getAttribute("user")%>
          </a>
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>
          <li><a class="dropdown-item" href="#">Log out</a></li>
        </ul>
      </div>

    </div>
  </nav>
  <main class="container text-center">
    <div class="spacer"></div>
    <div class="spacer"></div>
    <form class="p-2 rounded-3" action="<%=request.getContextPath()%>/PartakersController" method="post" style="background-color: cadetblue;">
      <div class="container text-white">
        <h2 id="formTitle">Modify Partaker</h2>
      </div>
      <div class="spacer"></div>
      <div class="container flex justify-content-center">
        <!--id(oculto), nombre, apellido, fechaIngreso, edad, email, direccion, provincia-->
        <input class="d-none" name="add" value="${param.add}">
        <input id="partakerId" class="d-none" name="partakerId" value="${param.partakerId}">
        <div class="row">
          <div class="col-6">
            <label for="nameId" class="form-label">Nombre</label>
            <input id="nameId" type="text" class="form-control" placeholder="Jorge" value=${param.name} aria-label="name" name="name"></div>
          <div class="col-6">
            <label for="apellidoId" class="form-label">Apellido</label>
            <input id="apellidoId" type="text" class="form-control" placeholder="Lopez" value=${param.lastname} aria-label="lastname" name="lastname">
          </div>
        </div>
        <div class="row">
          <div class="col-9">
            <label for="fechaId" class="form-label">Fecha de Ingreso</label>
            <input id="fechaId" type="date" class="form-control" placeholder="2021-11-03 09:52:22" value=${param.registeredDate} aria-label="registered-date" name="registered-date">
          </div>
          <div class="col-3">
            <label for="ageId" class="form-label">Edad</label>
            <input id="ageId" type="number" class="form-control" placeholder="34" value=${param.age} aria-label="age" name="age">
          </div>
        </div>
        <div class="row">
          <div class="col-12">
            <label for="emailId" class="form-label">Email</label>
            <input id="emailId" type="email" class="form-control" placeholder="email@gmail.com" value=${param.email} aria-label="email" name="email">
          </div>
        </div>
        <div class="row">
          <div class="col-6">
            <label for="stateId" class="form-label">Provincia</label>
            <input id="stateId" type="text" class="form-control" placeholder="Chubut" value=${param.state} aria-label="state" name="state">
          </div>
          <div class="col-6">
            <label for="addressId" class="form-label">Dirección</label>
            <input id="addressId" type="text" class="form-control" placeholder="Av. Siempreviva 1023" value=${param.address} aria-label="address" name="address">
          </div>
        </div>
        <div class="row flex justify-content-around mt-3">
          <div class="col-4 flex text-center"><button id="upload-button" class="btn btn-lg btn-success">Update</button></div>
          <div class="col-4 flex text-center"><a href="javascript:history.back()" class="btn btn-lg btn-danger">Cancel</a></div>
        </div>
      </div>
    </form>
  </main>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
  integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
  crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
  integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
  crossorigin="anonymous"></script>
<script>
    const queryString = window.location.search; // ?product=shirt&color=blue&newuser&size=m
    const urlParams = new URLSearchParams(queryString);
    const isNewUser = urlParams.get('add');
    if (isNewUser == "true"){
      document.getElementById("formTitle").innerText = "New Partaker";
      document.getElementById("upload-button").innerText = "Add New";
    }
</script>
</body>
</html>
