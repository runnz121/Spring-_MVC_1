package hello.servlet.web.frontcontroller.v3;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//1. "/front-controller/v3/*" 이게 호출된다
@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {
    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new
                MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new
                MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new
                MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

       //createparamamp은 메소드 extraction으로 갖고온것
        //3. 여기서 파라미터를 뽑아 paramMap 으로 반환해준다.
        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);

        //5. memberformcontroller에서 받아온 논리이름 new-form이 view-name에 담기게된다.
        String viewName = mv.getViewName();
        //Myview view = new MyView("/WEB-INF/views/" + viewName + ".jsp");
        //대신에 resolver를 만들어서 위의 코드를 해결해줌(물리모델)

        //6.viewresolver가 논리이름을 바탕으로 물리이름을 호출 할 것이다.(new-form받아서)
        MyView view = viewResolver(viewName);

        //8.viewresolver가 render를 호출한다( myview)
        view.render(mv.getModel(), request, response);
    }

//2. createpramamp을 통해 http request의 파라미터를 모두 추출해낸다
    private Map<String, String> createParamMap(HttpServletRequest request) {

        //paramap을 만들고 모든 파라미터 이름을 다 갖고온다
        Map<String, String> paramMap = new HashMap<>();

        request.getParameterNames().asIterator() ///key, value 값으로 해당 값을 갖고온다
               .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

    //7. 논리이름을 받아서 물리이름으로 바꿔줌
    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}