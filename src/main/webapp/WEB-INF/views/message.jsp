<%@ page import="com.springmvc.controller.User" %>
<%@ page import="org.springframework.ui.Model" %><%--
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


<% Object o = request.getAttribute("message");
if(o==null)
{
%>
<%="user not found"%>
<%
    }
    else
    {
%>
<%=(String)o %>
<%
    }
    HttpSession sess = (HttpSession)request.getAttribute("session");
    HttpSession session1 = request.getSession(true);
    String s = (String) session1.getAttribute("username");
%>

<%= s%>
<%=session1%>
<%=sess%>
<%=(Model)request.getAttribute("model")%>
</body>
</html>
