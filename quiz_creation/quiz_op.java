import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Suriya
 */
public class quiz_op extends HttpServlet {
    String[] ques = new String[3];
    String[] op1 = new String[3];
    String[] op2 = new String[3];
    String[] op3 = new String[3];
    String[] ans = new String[3];
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(false);
            
            for(int i=0;i<3;i++){
            ques[i] = (String)session.getAttribute("ques"+i);
            op1[i]=(String)session.getAttribute("op1"+i);
            op2[i]=(String)session.getAttribute("op2"+i);
            op3[i]=(String)session.getAttribute("op3"+i);
            ans[i]= (String)session.getAttribute("ans"+i);
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Play Quiz</title>");   
            out.println("<style>");
            out.println("div{font-style:bold; font-size:22px;}");
            out.println(".option{margin-left:50px;}");
            out.println("#a{font-family:Algerian; font-size: 1.4em; margin-left:200px;");
            out.println("</style>");
            
            out.println("</head>");
            out.println("<body style='text-align:left left-margib:100px;'>");
            out.println("<form action='http://localhost:8080/servlet_2/quiz_eval'>");
            for(int i=0;i<3;i++){
            out.println("<br><h2>"+(i+1)+") "+ques[i]+"</h2>");
            out.println("<br><div><input type='radio' class='option' name='opt"+i+"' value='"+op1[i]+"'>"+op1[i]
            +"<input type='radio' class='option' name='opt"+i+"' value='"+op2[i]+"'>"+op2[i]
            +"<input type='radio' class='option' name='opt"+i+"' value='"+op2[i]+"'>"+op3[i]+"</div><br><br><hr>");
            }
            
            out.println("<br><button id='a'>View Results</button>");
            out.println("</form>");
                     
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
