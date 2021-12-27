<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: woonsik
  Date: 2021/12/27
  Time: 6:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> all = memberRepository.findAll();

    response.setContentType("text/html");
    response.setCharacterEncoding("utf-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
SUCCESS
<table>
    <thead>
    <th>ID</th>
    <th>USER_NAME</th>
    <th>AGE</th>
    </thead>
    <tbody>
        <%
            for (Member member : all) {
                out.write("     <tr>");
                out.write("         <td>" + member.getId() + "</td>");
                out.write("         <td>" + member.getUsername() + "</td>");
                out.write("         <td>" + member.getAge() + "</td>");
                out.write("     </tr>");
            }
        %>
    </tbody>
</table>
<a href="/index.html">메인</a>
</body>
</html>
