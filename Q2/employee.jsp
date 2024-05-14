<%-- 
    Document   : employee
    Created on : 11 May, 2024, 2:54:08 PM
    Author     : suriya
 
 Assume you have a database schema that contains a table called "employees" with the following columns:
employee_id (int, primary key),first_name (varchar), last_name (varchar), salary (double)

Write a JSP program that connects to the database using JDBC and retrieves the following information:
1.	The total number of employees in the database.
2.	The average salary of all employees.
3.	The highest salary among all employees.

Once you have retrieved this information, create a JSP page that displays this information in a table format.-->
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Details</title>
    </head>
    <body>
        <%
              try{
                  Connection c=DriverManager.getConnection("jdbc:derby://localhost:1527/model_lab");
                  Statement st1 = c.createStatement();
                  Statement st2 = c.createStatement();
                  Statement st3 = c.createStatement();
                  
                   String q1 ="Select count(emp_id) from employees";
                   String q2 ="Select avg(salary) from employees";
                   String q3 ="Select max(salary) from employees";
                 
                   ResultSet rs1 = st1.executeQuery(q1);
                   ResultSet rs2 = st2.executeQuery(q2);
                   ResultSet rs3 = st3.executeQuery(q3);
              
                   if(rs1.next() && rs2.next() && rs3.next()){
                        session.setAttribute("rs1", rs1.getInt(1));             
                        session.setAttribute("rs2", rs2.getDouble(1));
                        session.setAttribute("rs3", rs3.getDouble(1));
                        response.sendRedirect("emp_display.jsp");
                   }
              }
              catch(Exception e){ %>
                   <h3>Sorry, unexpected error occured!</h3>
                <%  e.getMessage(); 
              }
        %>
    </body>
</html>
