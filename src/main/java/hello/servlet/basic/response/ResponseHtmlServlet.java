package hello.servlet.basic.response;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html")
public class ResponseHtmlServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        //Content-Type: text/html;charset=utf-8
        response.setContentType("text/html"); //html이라고 알려줘야함(렌더링 뭘로 할건지)
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();

        //body부분에 html 태그를 담아 보냄으로서 html랜더링됨
        writer.println("<html>");
        writer.println("<body>");
        writer.println(" <div>안녕?</div>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
