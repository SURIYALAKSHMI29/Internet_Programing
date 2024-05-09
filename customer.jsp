<%-- 
Create a web service application that allows users to add and edit customer information in a
database, and returns a list of customers. Use Java, JAX-RS, and JDBC to connect to the
database. Create a web service client in Java to invoke the web service
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <h2>Customer details</h2>
        <form action='customers.jsp' method='POST'>
            Customer id: <input type="number" name="id"><br><br>
            Name: <input type="text" name="name"><br><br>
            Ph number: <input type="text" name="num"><br><br>
            
            <select name='select'>
                <option selected disabled>Select operation</option>
                <option value='insert'>Insert</option>
                <option value='edit'>Edit</option><br><br>
            </select>
            
            <input type="submit" value='Process' onsubmit="add()"> <br>
        </form>
    </body>

    <%-- start web service invocation --%><hr/>
    <%
        if (request.getMethod().equals("POST")) {
            // Retrieve data from the database based on the selected date range
            int c_id = Integer.parseInt(request.getParameter("id"));
            String c_name = request.getParameter("name");
            String ph_num = request.getParameter("num");
            String select = request.getParameter("select");
            
     if(select.equals("insert")){       
    try {
	demo.Customer_Service service = new demo.Customer_Service();
	demo.Customer port = service.getCustomerPort();
	 
	int cId = 0;
	java.lang.String custName = "";
	java.lang.String phNum = "";
	java.lang.String result = port.add(c_id, c_name, ph_num);
	out.println("Result = "+result);
    } catch (Exception ex) {
	out.println(ex.getMessage());
    } 
  }
     
     else if(select.equals("edit")){ 
        try {
	demo.Customer_Service service = new demo.Customer_Service();
	demo.Customer port = service.getCustomerPort();

	int cId = 0;
	java.lang.String custName = "";
	java.lang.String phNum = "";
	java.lang.String result = port.edit(c_id, c_name, ph_num);
	out.println(result);
    } catch (Exception ex) {
        out.println(ex.getMessage());
    }}
        }
    %>
<hr/>

</html>   
