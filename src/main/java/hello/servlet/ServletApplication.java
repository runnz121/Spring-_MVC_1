package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ServletComponentScan //자동으로 서블릿 등록해주는 컴포넌트
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
//		이 부분을 Application properties에 설정을 해놓으면 호출되어서 적용됨
//		@Bean
//		InternalResourceViewResolver internalResourceViewResolver(){
//			return new InternalResourceViewResolver("/WEB-INF/views",".jsp");
//		}
//

	}
//스프링 빈 직접 등록
//		@Bean
//		TestController testController() {
//			return new TestController();
//		}
//}
}
