
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1> <%= "Hello World!" %> </h1>
<h2>Al parece esta es la página "index" del programa.</h2>
<br/>
<h3>Para ingresar a una clase que cree o modifique un html solo se tiene que escribir como un tag href común.</h3>
<% String hrefExample = "<a href=\"nombre_de_clase\">whatever</a>"; %>
<p> Like: <%= hrefExample %></p>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>