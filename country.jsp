<%--
  Assume you have a list of Country objects, each with the following properties: name, capital, currency, and population.
  Using JSTL core and formatting tags, create a table that displays the country information and highlight the top three population in red color.
  --%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="country.country" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   

<!DOCTYPE html>
<html>
<head>  
    <title>country</title>
    <style>
        th{   
            font-size: 24px;
            padding: 25px;
        }
        td{
            font-size: 20px;
            padding: 10px;
        }
        .highlight{ color: red; }   
    </style>
</head>
<body> <center>
        <h1>Country Table</h1><br><br>
     <table border="2px solid" style="border-collapse:collapse">
            <tr id="tr">
                <th>Name</th>
                <th>Capital</th>
                <th>Population</th>
                <th>Currency</th>
            </tr>     
     <% ArrayList<country> country1 = new ArrayList<country>();

        country1.add(new country("India","Delhi",10980041,"Rupee"));
        country1.add(new country("China","Beijing",15000000,"Yuan"));
        country1.add(new country("USA","Washington",20340089,"Dollar"));  
        country1.add(new country("Brazil", "Brasília", 2120700,"BRL"));
        country1.add(new country("Italy", "Rome", 2320910,"Euro"));
        country1.add(new country("Russia", "Moscow", 14395708,"Russian ruble"));
         Collections.sort(country1, new Comparator<country>() {
                    public int compare(country c1, country c2) {
                        return c2.getPopulation() - c1.getPopulation();
                    }
          });
        pageContext.setAttribute("c", country1);
     %>
     <c:forEach var="coun" items="${pagescope.c}" varStatus="loop">
                 <tr  <c:if test="${loop.index < 3}"> class="highlight"></c:if>>
                        <td>"${coun.name}"</td>
                        <td>"${coun.capital}"</td>
                        <td>"${coun.population}"></td>
                        <td>"${coun.currency}"</td> 
                    </tr>      
        </c:forEach>     
        </table> </center>   
</body>
</html>
