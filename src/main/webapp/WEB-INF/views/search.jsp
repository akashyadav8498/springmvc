<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        #user {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #user td, #user th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #user tr:nth-child(even){background-color: #f2f2f2;}

        #user tr:hover {background-color: #ddd;}

        #user th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #04AA6D;
            color: white;
        }
    </style>
</head>
<body>

<%
    ArrayList<String> arr = (ArrayList<String>) request.getAttribute("user");
%>
<h1> <%=arr.get(0)%>'s data:</h1>

<table id="user">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Username</th>
    </tr>
    <tr>
        <td><%=arr.get(0)%></td>
        <td><%=arr.get(1)%></td>
        <td><%=arr.get(2)%></td>
        <td><%=arr.get(3)%></td>
    </tr>

</table>



</body>
</html>


