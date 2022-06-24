<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23-06-2022
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if("akay8498".equals((String)request.getAttribute("username")) && "akay8498".equals((String)request.getAttribute("password")))
    {
        %>
        <%="welcome akash"%>
<%
    }

    else
    {

    %>
        <%="not authorized"%>
<%
    }
    %>
</body>
</html>
