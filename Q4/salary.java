import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author suriya
 */
public class salary extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String id = request.getParameter("id");
            String desg = request.getParameter("desg");
            Double pay = Double.valueOf(request.getParameter("pay"));
            Double hra = 0.03* pay;
            Double da = 0.1*pay;
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet salary</title>");            
            out.println("</head>");
            out.println("<body><center>");
            out.println("<h1>Employee details</h1><fieldset>");
            out.println("<h2>Employee Name: "+name+"</h3>");
            out.println("<h3>Employee ID: "+id+"</h3>");
            out.println("<h3>Designation: "+desg+"</h3>");
            out.println("<h3>Basic Pay: "+pay+"</h3>");
            out.println("<h3>HRA(3% of bp) : "+hra+"</h3>");
            out.println("<h3>DA(10% of bp) : "+da+"</h3>");
            out.println("</fieldset></center></body>");
            out.println("</html>");
        }
    }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
