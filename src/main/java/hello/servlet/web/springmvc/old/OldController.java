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
    return null;
  }
}
