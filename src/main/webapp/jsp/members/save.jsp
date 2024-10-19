<%@ page import="hello.servlet.Domain.Member.Member" %>
<%@ page import="hello.servlet.Domain.Member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: dayoung
  Date: 10/19/24
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // servlet에서는 request, request object가 자동으로 호출됨
  MemberRepository memberRepository = MemberRepository.getInstance();

  request.getParameter("username");
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));

  Member member = new Member(username, age);
  memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
  <li>id=<%=member.getId()%></li>
  <li>id=<%=member.getUsername()%></li>
  <li>id=<%=member.getAge()%></li>
</ul>
<a href="/index.html">Main</a>

</body>
</html>
