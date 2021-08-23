package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {

        ServletInputStream inputStream = request.getInputStream();// request.getInputStream() : message body의 내용을 bite코드로 얻을 수 있다.
        String messageBody = StreamUtils.copyToString(inputStream, // StreamUtils.copyToString : 스프링이 제공하는 유틸리티로 inputstream값을 꺼내온다 이떄 인코딩 정보를 알려줌
                StandardCharsets.UTF_8);
        System.out.println("messageBody = " + messageBody);
        response.getWriter().write("ok");
    }
}
