import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author suriya
 */
public class greet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (
            PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet greet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
           
            String n=request.getParameter("uname");
            //out.print("Welcome "+n);
            Cookie ck1=new Cookie("uname",n); //creating cookie object
            response.addCookie(ck1); //adding cookie in the response
           
            String lang=request.getParameter("select");
           // out.print("Welcome "+lang);
            Cookie ck2=new Cookie("select",lang); //creating cookie object
            response.addCookie(ck2); //adding cookie in the response
            if(lang.equals("english")){
                out.println("<h1>Hello, "+n+"</h1>");
                out.println("<h2>Have a Nice day!</h2>");
            }
            else if(lang.equals("french")){
                out.println("<h1>Bonjour, "+n+"</h1>");
                out.println("<h2>bonne journée</h2>");
            }
            else if(lang.equals("spanish")){
                out.println("<h1>Holo, "+n+"</h1>");
                out.println("<h2>qué tengas un lindo día!</h2>");
            }
            else if(lang.equals("russian")){
                out.println("<h1>Привет, "+n+"</h1>");
                out.println("<h2>Khoroshego dnya</h2>");
            }
            else if(lang.equals("tamil")){
                out.println("<h1>Vanakam, "+n+"</h1>");
                out.println("<h2>Indraiya naal iniya naalaga amaiyatum!</h2>");
            }
           
            out.println("<center>");
            out.println("</body>");
            out.println("</html>");
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
