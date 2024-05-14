<%-- 
    Document   : emp.display
    Created on : 12 May, 2024, 12:42:30 PM
    Author     : suriya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>emp_details</title>
        <style>
            body{
                text-align: center;
                background-color: whitesmoke;
            }
            table,th,td{
                padding: 10px;
                border-collapse: collapse;
                border: 2px grey solid;
            }
            table{
                margin-left: 35%;
            }
            th{
                font-size: 16px;
                background-color: lightsteelblue;
            }
            tr:hover{
                background-color: lightgray;
            }
        </style>
    </head>
    <body>
        <h1>Employee Details</h1>
        
        <table>
            <tr>
                <th>S.No</th>
                <th>Question / Query</th>
                <th>Answer</th>
            </tr>
            <tr>
                <td>1 </td>
                <td>The total number of employees in the database</td>
                <td><%=session.getAttribute("rs1").toString()%></td>
            </tr>
            <tr>
                <td>2 </td>
                <td>The average salary of all employees</td>
                <td><%=session.getAttribute("rs2")%></td>
            </tr>
            <tr>
                <td>3 </td>
                <td>The highest salary among all employees</td>
                <td><%=session.getAttribute("rs3")%></td>
            </tr>
        </table>
    </body>
</html>
