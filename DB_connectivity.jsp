<%--
Assume you have a database schema that contains a table called "movies" with the following
columns:
 movie_id (int, primary key)
 title (varchar)
 director (varchar)
 rating (varchar)
 price (double)
Write a JSP program that connects to the database using JDBC and retrieves the following
information:
1. The total number of movies in the database.
2. The average price of all movies.
3. The director with the highest-rated movies (based on the average rating of their
movies).
Once you have retrieved this information, create a JSP page that displays this information in a
table format.
--%>

<%-- 
    Document   : databaseConnectivity
    Created on : 26-Mar-2024, 10:21:02 pm
    Author     : Suriya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DataBase Connectivity</title>
        <style>
            table, td, th{
                border: 2px solid black;
                border-collapse: collapse;
                font-size: 1.2em;
            }
            table{
                height:300px;
                width:600px;
                text-align: center;
            }
            th{
                color:navy
            }
            body{
                font-family: TimesNewRoman;
                background-color: whitesmoke;
            }
        </style>
    </head>
    <body>
    <center>
        <h1 style="color:purple">Movies DataBase</h1><br>
        <% Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/movies");
        Statement st = c.createStatement(); 
        
        //total no.of movies
        String query1="SELECT count(*) from movies";
        ResultSet rs = st.executeQuery(query1);
        rs.next();
     %>   
      
        <table>
                <tr>
                    <th><strong>Statement</strong></th>
                    <th><strong>Result</strong></th>
                </tr>
                           
                <tr>
                    <td><strong>Total no.of movies</strong></td>
                    <td><strong><%=rs.getInt(1)%></strong></td>
                </tr>
        <%
        //average price of movies
        String query2="SELECT avg(price) from movies";
        ResultSet rs2 = st.executeQuery(query2);
        rs2.next(); //Since ResultSet points to the row before the 1st result of data
        %>
     
                <tr>
                    <td><strong>Average of price of all movies</strong></td>
                    <td><strong><%=rs2.getInt(1)%></strong></td>
                </tr>
          <% //director with highest rating
        String query3 ="SELECT director,avg(rating) from MOVIES GROUP BY director ORDER BY avg(rating) DESC FETCH FIRST 1 ROW ONLY";
        ResultSet rs3 = st.executeQuery(query3);
        rs3.next();
        %>       
                <tr>
                    <td><strong>Director with highest Rating</strong></td>
                    <td><strong><%=rs3.getString(1)%></strong></td>
                </tr>
        </table>
     </center>  
    </body>
</html>
