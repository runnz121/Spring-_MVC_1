package hello.servlet.web.springmvc.v1;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


//controller컴포넌트는 안에 component가 같이 들어있다
@Controller
//@Component
//@RequestMapping //클래스 레벨에 선언이 되면 자동으로 맵핑된다.
public class SpringMemberFormControllerV1 {
    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {

        return new ModelAndView("new-form");
    }
}
