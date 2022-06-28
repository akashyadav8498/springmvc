<%@ page import="com.springmvc.controller.User" %>
<%@ page import="org.springframework.ui.Model" %>
<%@ page import="java.io.PrintWriter" %><%--
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

<form action="logout">

    <label>Log out:</label><br>
    <input type="submit" name="action" value="logout">
</form>
<h1>
<% Object o = request.getAttribute("message");
   String username = (String) request.getAttribute("username");

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
<%=username %>


<%
       HttpSession session1 =  request.getSession(true);
       session1.setMaxInactiveInterval(1);

        if(session1==null){
            %>
    <%="session time out!!!!"%>
    <%
        }
    }


%>


</h1>
</body>
</html>
