<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 30/12/21
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="jenkobud, and Bootstrap contributors">
    <meta name="generator" content="jenkobud">
    <title>Log in / Sign in</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">

    <!-- Favicons -->
    <!--
    <link rel="apple-touch-icon" href="/docs/5.0/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="/docs/5.0/assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="/docs/5.0/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
    <link rel="icon" href="/docs/5.0/assets/img/favicons/favicon.ico">
    -->
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

<body class="text-center" style="background-color: #234343;">

<main class="form-signin rounded-3" style="background-color: cadetblue;">
    <form action="<%= request.getContextPath() %>/LoginController" method="post" id="login">
        <img class="mb-4" src="data:image/jpeg;base64,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RoCQG8ZiPeO+VpABsSTLVhL3mBYD5+XHmdduVh4nBucrupUUbfTF5V53WpZi8JCrbeJytwvJ8/XwLgVtxlZuXK6Mukd2P+sXO51PKyNJhmRM83+qonhIuCppzila2STT08SVHPSg1F7yXLfcHrwbX5LQSzG1mwJkA5r3vvfW+4m+6g0Wn6KyhSVWvCDzRjJTbUHbglZX6am6/YFLrV/8kl+DmVtanQrRm3GWXOnFSipLMlb6mjaR7YUne0eHWcPi17+h7fsillwTHPaATOoA1cY+EERtGi5WJd+6QDxv4Kvb+z40d1KDqXdRReapOSaaelm7FBRtbb8cRu1kcVGeZu05cFwsoFtOd0mr2avqmn6p8DgfqKk8Vw4i3O2g+xW3gXgtIlegA86t9AAEQlGTXAiAik5vr8s8PACAdUQABEAARAAEQABFIrqUoyi4uMXF8VyZIGTXFpka/b8twoInVY+GwVOk26cFG/G1+RbSoQj9MYRvxypK/sTBZUxFWoS57iSdZJMxpM6x4rFtNrbAQgAKVmgACIAAikeXPARARSIgAADREABKIAAiAAlEAARAAEQABEAARAAEQABEAARAAEQABEAARAAEQABEAARAAEQABEAARAAEQABEAARAAEQABEAARAAEQABEAARAAEQABEAARAAEQABEAARAAEQABEAARAAEQABEAARAAEQABEAARAAEQABEAARAAEQABEAARAAEQABEAARAAEQABEAARAAEQABEAARAAEQABEAARAAEX//Z" alt="" width="100" height="100">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

        <div class="form-floating">
            <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com">
            <label for="email">Email address</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            <label for="password">Password</label>
        </div>

        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="w-100 btn btn-lg btn-warning" type="submit">Sign in</button>
    </form>
</main>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>

</html>
