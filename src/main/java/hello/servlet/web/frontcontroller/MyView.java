package hello.servlet.web.frontcontroller;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MyView {

    private String viewPath; // 6. frontcontrollerv2에서 받아온 값 ("/WEB-INF/views/new-form.jsp") 가 viewpath로 들어가게된다.
    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    //jsp를 호출하는 것을 render라고 표현하기로 함

    //7. render를 호출해서 해당 viewpath를 받아서 랜더링 하게된다.
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);

        //jsp 랜더링
        dispatcher.forward(request, response);
    }
}
