<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 1/1/22
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify Partaker</title>
</head>
<body>

<script>
    const queryString = window.location.search; // ?product=shirt&color=blue&newuser&size=m
    const urlParams = new URLSearchParams(queryString);
    //Example, change it for partakers REMOVE
    const product = urlParams.get('product') // shirt
</script>
</body>
</html>
