package cutomer_db;

import java.sql.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author suriya
 */
@WebService(serviceName = "customer")
public class customer {

    @WebMethod(operationName = "add")
    public String add(@WebParam(name = "c_id") int c_id, @WebParam(name = "cust_name") String cust_name, @WebParam(name = "ph_num") String ph_num) {
        //TODO write your implementation code here:
        try{
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/customerd");
           
            String query = "INSERT into customers Values(?,?,?)";
            PreparedStatement pst = c.prepareStatement(query);
            pst.setInt(1,c_id);
            pst.setString(2,cust_name);
            pst.setString(3,ph_num);
            
            int row=pst.executeUpdate();
            if(row>0){
                return "Inserted Successfully!";
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return null;
    }

    @WebMethod(operationName = "edit")
    public String edit(@WebParam(name = "c_id") int c_id, @WebParam(name = "cust_name") String c_name, @WebParam(name = "ph_num") String ph_num) {
        //TODO write your implementation code here:
        StringBuilder result = new StringBuilder();
        String newline = System.getProperty("line.separator");
        try{
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/customerd");
           
            String query = "UPDATE customers set cust_name=?, ph_num=? where c_id=?";
            PreparedStatement pst = c.prepareStatement(query);
            pst.setInt(3,c_id);
            pst.setString(1,c_name);
            pst.setString(2,ph_num);
            
            int row=pst.executeUpdate();
            if(row>0)
                return "Updated Successfully!";
           
        }
        catch(Exception e){
            e.getMessage();
        }
        
        return  result.toString();
    }
}
