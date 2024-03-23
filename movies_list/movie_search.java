import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
/**
 *
 * @author Suriya
 */
public class movie_search extends HttpServlet {
     Map<String,String> movies = new HashMap<String, String>();
    public void init() throws ServletException{
        movies.put("moonu", "dhanush");
        movies.put("bhairava", "vijay");
        movies.put("varanam aayiram", "surya");
        movies.put("pattas", "dhanush");
        movies.put("aayirathil oruvan", "karhi");
        movies.put("thuppaki", "vijay");
        movies.put("vip", "dhanush");
        movies.put("kodi", "dhanush");
        movies.put("anjaan", "surya");
        movies.put("mersal", "vijay");
        movies.put("nanban", "vijay");
        movies.put("yaaradi nee mohini", "dhanush");
        movies.put("vaathi", "dhanush");
        movies.put("aadhavan", "surya");
        movies.put("jailer", "rajini");
        movies.put("kaithi", "karthi");
        movies.put("nerkonda paarvai", "ajith");
        movies.put("thiruchitrambalam", "dhanush");
        movies.put("singam", "surya");
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String search = request.getParameter("input").toLowerCase();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet movie_search</title>");     
            out.println("<style>");
            out.println("body{ padding:100px; padding-left:200px;}");
            out.println("h1{color:navyblue}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Your Search Results are...</h1><br><br>");

            for(Map.Entry<String, String> x: movies.entrySet()){
                if(x.getKey().equals(search) || x.getValue().equals(search))
                    out.println("<strong>-> "+x.getValue()+" - "+x.getKey()+"</strong><br><br>");
            }
            out.println("<h1>Servlet movie_search at " + request.getContextPath() + "</h1>");
            out.println("</body>");
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
