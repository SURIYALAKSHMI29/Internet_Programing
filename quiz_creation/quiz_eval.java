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
public class quiz_eval extends HttpServlet {
    String[] option = new String[3];
    String[] answer = new String[3];
    int i,count=0;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Evaluation_page</title>");    
            out.println("<style>");
            out.println("body{ text-align:left; font-size: 20px; margin-left:75px; ; font-family:timesnewroman;}");
            out.println(".w{color:navy; font-style:italic; position:inline;}");
            out.println("#r{margin-left:150px;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<br><br><h2>Your Results are...</h2>");
            
            HttpSession session = request.getSession(false);
            for(i=0;i<3;i++){
                option[i]= request.getParameter(("opt"+i));
                answer[i]=(String)session.getAttribute("ans"+i);
             
                if(option[i].equals(answer[i])){
                    out.println("<br><div>"+(i+1)+" - Correct Answer</div>");
                    count++;
                }
                else{
                    out.println("<br><div>"+(i+1)+" - Wrong Answer.<div class='w'> Correct Answer:"+answer[i]+"</div></div>");
                }
            }
            out.println("<br><br><div id='r'>Your score: "+count+"/3</div>");
            count=0;
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
