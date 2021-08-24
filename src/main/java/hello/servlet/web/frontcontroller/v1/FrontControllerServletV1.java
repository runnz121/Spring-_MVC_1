package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//프론트 컨트롤러는 httpservlet을 상속 받는다
//"/frontcontroller/v1/*" v1하위에 어떠한 url에 들어오든 무조건 호출된다
@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    //key : url, value : controller
    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    //생성자로 호출될 컨트롤러 지정
    //url이 들어오면 new로 해당 컨트롤러가 생성된다.
    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        //request.getRequestURI() 를 적으면 /front-controller/v1/members/new-form 이 부분을 받을 수 있다.
        String requestURI = request.getRequestURI();

        //map 에서 해당 url를 꺼낸다. 그러면 controller에 위에서 생성자로 지정해놓은 객체를 반환하게된다
        //다형성에 의해서 인터페이스를 받는다
        //ControllerV1 controller = new MemberListControllerV1() 랑 같은 의미이다
        ControllerV1 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        controller.process(request, response);
    }
}
