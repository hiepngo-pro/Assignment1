<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

    <title>Login</title>

    <style>

        body{
            font-family:Arial;
            background:#f5f5f5;
        }

        .login-box{
            width:400px;
            background:white;
            margin:100px auto;
            padding:30px;
            border-radius:10px;
            box-shadow:0 0 10px gray;
        }

        input{
            width:100%;
            padding:10px;
            margin-top:10px;
            margin-bottom:20px;
        }

        button{
            width:100%;
            padding:10px;
            background:#007bff;
            color:white;
            border:none;
        }

        .error{
            color:red;
        }

    </style>

</head>

<body>

<div class="login-box">

    <h2>Login</h2>

    <form method="post">

        Username

        <input type="text"
               name="username">

        Password

        <input type="password"
               name="password">

        <button type="submit">

            Login

        </button>

    </form>

    <p class="error">

        ${message}

    </p>

</div>

</body>
</html>