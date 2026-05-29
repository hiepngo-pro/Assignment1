<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

    <title>Favorite</title>

    <a href="home">
    Home
    </a>

    <style>

        body{
            font-family:Arial;
            background:#f5f5f5;
        }

        .container{
            width:90%;
            margin:auto;
        }

        .card{
            background:white;
            padding:15px;
            margin-top:20px;
            border-radius:10px;
            box-shadow:0 0 5px gray;
        }

        .btn{
            padding:8px 15px;
            color:white;
            text-decoration:none;
            border-radius:5px;
        }

        .unlike{
            background:red;
        }

        .share{
            background:green;
        }

    </style>

</head>

<body>

<div class="container">

    <h1>Favorite Videos</h1>

    <div class="card">

        <h3>Comedy Show 1</h3>

        <p>Funny comedy performance</p>

        <a class="btn unlike"
           href="unlike?videoId=1">

            Unlike
        </a>

        <a class="btn share"
           href="share?videoId=1">

            Share
        </a>

    </div>

    <div class="card">

        <h3>Comedy Show 2</h3>

        <p>Funny comedy performance</p>

        <a class="btn unlike"
           href="unlike?videoId=2">

            Unlike
        </a>

        <a class="btn share"
           href="share?videoId=2">

            Share
        </a>

    </div>

</div>

</body>
</html>