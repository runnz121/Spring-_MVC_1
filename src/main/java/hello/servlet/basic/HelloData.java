package hello.servlet.basic;

//JSON객체 파싱을 위한 클래스
//자바 프로퍼티 접근법

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class HelloData {
    private String username;
    private int age;
    //==== lombok 생성 코드 ====//
//    public String getUsername() {
//        return username;
//    }
//    public void setUsername(String username) {
//        this.username = username;
//    }
//    public int getAge() {
//        return age;
//    }
//    public void setAge(int age) {
//        this.age = age;
//    }
}
