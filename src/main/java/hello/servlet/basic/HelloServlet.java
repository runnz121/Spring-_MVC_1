package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello") //hello로 오면 이게 실행된다.
public class HelloServlet extends HttpServlet { //httpservlet을 상속 받는다

    @Override//httpservlet을 위한 service method 호출(url 호출시 서블렛 컨테이너가 살행하는 메소드)
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("req = " + req);//서버로부터의 요청
        System.out.println("res = " + resp);//요청으로부터의 응답

        //요청메세지를 받아옴
        String username = req.getParameter("username");// getParameter로 쿼리 파라미터를 조회할 수 있다.
        System.out.println("username =" + username);

        //응답메세지를 보냄
        resp.setContentType("text/plain"); //요청메세지 타입
        resp.setCharacterEncoding("utf-8"); //요청메시지 인코딩 타입
        resp.getWriter().write("hello " + username);//getWriter는 http body에 메세지를 쓰게 함
        //http://localhost:8080/hello?username=김

    }
}
