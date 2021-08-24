package hello.servlet.web.frontcontroller.v2;
import hello.servlet.web.frontcontroller.MyView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public interface ControllerV2 {

    //controllerv1와 같은 구조이지만 Myview를 반환하는걸로 수정
    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
