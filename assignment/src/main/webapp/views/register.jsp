<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

    <title>Register</title>

    <style>

        body{
            font-family:Arial;
            background:#f5f5f5;
        }

        .register-box{
            width:450px;
            background:white;
            margin:50px auto;
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
            background:green;
            color:white;
            border:none;
        }

        .message{
            color:blue;
        }

    </style>

</head>

<body>

<div class="register-box">

    <h2>Register</h2>

    <form method="post">

        Username

        <input type="text"
               name="username">

        Password

        <input type="password"
               name="password">

        Fullname

        <input type="text"
               name="fullname">

        Email

        <input type="email"
               name="email">

        <button type="submit">

            Register

        </button>

    </form>

    <p class="message">

        ${message}

    </p>

</div>

</body>
</html>