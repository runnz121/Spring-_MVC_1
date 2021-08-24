package hello.servlet.web.frontcontroller.v2.controller;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MemberFormControllerV2 implements ControllerV2 {
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //myview컨트롤러에 url 패스를 생성자 인자로 넣어줌
        //Myview myview = new Myview() 를 인라인으로 바꿔줌


        //4. frontcontrollerv2에서 받아온 정보를 바탕으로 해당 url 패쓰를 반환한다.
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
