<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>OE Entertainment</title>
</head>

<body>

<h1>OE Entertainment</h1>

    <div style="margin-bottom:20px;">

        <a href="home">Home</a>

    |

        <a href="favorite">
             Favorite Videos
        </a>

    </div>
<hr>

<c:forEach var="video" items="${videos}">

    <div style="
            border:1px solid gray;
            width:300px;
            padding:10px;
            margin:10px;">

        <img src="${video.poster}"
             width="280"
             height="180">

        <h3>${video.title}</h3>

        <p>Lượt xem: ${video.views}</p>

        <p>${video.description}</p>

        <button>Like</button>
        <button>Share</button>

    </div>

</c:forEach>

</body>
</html>