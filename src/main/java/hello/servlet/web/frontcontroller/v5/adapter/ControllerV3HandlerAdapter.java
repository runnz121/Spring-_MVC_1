package hello.servlet.web.frontcontroller.v5.adapter;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


//v3타입의 컨트롤러를 지원하는 어뎁터
public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    //controllerv3인 경우 true를 반환
    @Override
    public boolean supports(Object handler) {
        //memeberformcontrollerv3
        return (handler instanceof ControllerV3);
    }

    //실제 돌리는 부분
    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        //controllerv3로 handler를 캐스팅
        //handler 가 memeberformcontrollerv3
        ControllerV3 controller = (ControllerV3) handler;
        Map<String, String> paramMap = createParamMap(request);

        //model view를 반환
        ModelView mv = controller.process(paramMap);

        return mv;
    }

    //controllerv3에서 가져옴
    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName,
                        request.getParameter(paramName)));
        return paramMap;
    }
}