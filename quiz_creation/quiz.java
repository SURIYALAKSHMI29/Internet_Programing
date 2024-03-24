import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Suriya
 */
public class quiz extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String question = request.getParameter("q1");
            String op1 = request.getParameter("opt1");
            String op2 = request.getParameter("opt2");
            String op3 = request.getParameter("opt3");
            String ans = request.getParameter("ans");
            
            HttpSession session = request.getSession();
            session.setAttribute("ques",question);
            session.setAttribute("op1",op1);
            session.setAttribute("op2",op2);
            session.setAttribute("op3",op3);
            session.setAttribute("ans",ans);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>quiz_creation_successful</title>");   
            out.println("<style>");
            out.println("h1{ color:purple; padding:70px;}");
            out.println("a{font-size:30px; color:black; font-style:italic;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body style='text-align:center'>");
            out.println("<h1>Successfully created your quiz!</h1>");
            out.println("<a href='http://localhost:8080/servlet_2/quiz_op'>Start your Quiz</a>");
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
