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
    String[] question = new String[3];
    String[] op1 = new String[3];
    String[] op2 = new String[3];
    String[] op3 = new String[3];
    String[] ans = new String[3];
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            for(int i=0;i<3;i++){
            question[i] = request.getParameter("q"+(i+1));
            op1[i] = request.getParameter("opt1_"+(i+1));
            op2[i] = request.getParameter("opt2_"+(i+1));
            op3[i] = request.getParameter("opt3_"+(i+1));
            ans[i] = request.getParameter("ans"+(i+1));
            }       
            HttpSession session = request.getSession();
            
            for(int i=0;i<3;i++){
            session.setAttribute("ques"+i,question[i]);
            session.setAttribute("op1"+i,op1[i]);
            session.setAttribute("op2"+i,op2[i]);
            session.setAttribute("op3"+i,op3[i]);
            session.setAttribute("ans"+i,ans[i]);
            }
            
            /* TODO output your page here. You may use following sample code. */
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
