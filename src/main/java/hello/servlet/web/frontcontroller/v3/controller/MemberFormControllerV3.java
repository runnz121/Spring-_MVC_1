package hello.servlet.web.frontcontroller.v3.controller;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> paramMap) {

        //4.논리 이름만 넣는다
       return new ModelView("new-form");
    }
}