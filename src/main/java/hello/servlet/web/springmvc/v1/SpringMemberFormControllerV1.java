package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// spring이 자동으로 스프링 빈으로 등록
// 컴포넌트 스캔의 대상
// RequestMappingHandlerMapping은 스프링 빈 중에서 @RequestMapping or @Controller
// 가 붙어있는 경우(클래스 레벨에), 매핑 정보로 인식함. 내가 처리할 수 있는 핸들러(컨트롤러)구나!
@Controller

// 이 두개를 합친게 @Controller 임
//@Component - 빈 등록
//@RequestMapping - RequestMappingHandlerMapping이 얘를 찾아냄
public class SpringMemberFormControllerV1 {
  // 요청정보 매핑
  // 해당 url이 호출되면 process 메소드 호출됨
  // 메서드명은 맘대로 지어도됨
  // ModelAndView를 반환해야됨
  @RequestMapping("/springmvc/v1/members/new-form")
  public ModelAndView process() {
    return new ModelAndView("new-form");
  }
}
