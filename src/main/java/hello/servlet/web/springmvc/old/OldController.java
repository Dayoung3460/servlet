package hello.servlet.web.springmvc.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// spring이 필요한 핸들러 매핑, 핸들러 어댑터를 구현해놨음
// 스프링 빈의 이름(/springmvc/old-controller)으로 핸들러(컨트롤러: OldController) 찾음
// 이 컨트롤러(핸들러)를 실행할 수 있는 핸들러 어댑터를 찾아서 실행
// 어댑터가 handleRequest 실행해줌
@Component("/springmvc/old-controller")
public class OldController implements Controller {

  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    System.out.println("oldController");
    // spring boot는 InternalResourceViewResolver라는 뷰 리졸버를 자동으로 등록
    // 이 때 application.properties 에 등록한
    // spring.mvc.view.prefix=/WEB-INF/views/
    //spring.mvc.view.suffix=.jsp
    // 설정 정보를 사용해서 등록함

    // InternalResourceViewResolver: jsp 처리할 수 있는 뷰 반환
    // 타임리프 뷰 반환하는 뷰 리졸버는 또 따로 있고
    return new ModelAndView("new-form");
  }
}
