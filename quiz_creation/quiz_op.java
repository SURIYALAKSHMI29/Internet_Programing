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
public class quiz_op extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(false);
            String ques = (String)session.getAttribute("ques");
            String op1=(String)session.getAttribute("op1");
            String op2=(String)session.getAttribute("op2");
            String op3=(String)session.getAttribute("op3");
            String ans= (String)session.getAttribute("ans");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Play Quiz</title>");   
            out.println("<style>");
            out.println("div{font-style:bold; font-size:30px;}");
            out.println(".option{margin-left:50px;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body style='text-align:center'>");
            out.println("<h1>"+ques+"</h1>");
            out.println("<br><div><input type='radio' class='option' name='opt'>"+op1
            +"<input type='radio' class='option' name='opt'>"+op2
            +"<input type='radio' class='option' name='opt'>"+op3+
            "<br><label id='answer' style='visibility:hidden'></label></div>");
            out.println("<br><input type='submit' value='Submit'>");
//            
//            out.println("<script>"
//                    + "function check(){"
//                    +"document.getElementById('answer').style.visibility='visible';"
//                    + "String op= document.getElementsByName('opt'); "
//                    + "let f=0;"
//                    + "for(option in op){ "
//                        + "if(option.checked && option.value==ans){"
//                            + "f=1;"                             
//                            + "document.getElementById('answer').style.color=green;"
//                            + "document.getElementById('answer').innerText='Right Answer';}"
//                    + "}"
//                    + "if(f==0){"
//                        + "document.getElementById('answer').style.color=red;"
//                        +"document.getElementById('answer').innerHTML='Wrong Answer, Right Answer is,';}"
//                    + "}</script>");
            
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
