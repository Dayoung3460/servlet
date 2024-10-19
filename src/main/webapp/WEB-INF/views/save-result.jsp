<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <!--
    request.setAttribute 했었던 member 객체를 그냥 꺼내와서 쓸 수 있음.
    프로퍼티 접근법. jsp 표현식.
-->
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
