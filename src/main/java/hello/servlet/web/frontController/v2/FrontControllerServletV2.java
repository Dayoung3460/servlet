package hello.servlet.web.frontController.v2;

import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontController.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontController.v2.controller.MemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// FrontControllerServletV2 객체는 서블릿 컨테이너에 의해 애플리케이션이 시작될 때 자동으로 생성됨
// @WebServlet을 스캔해서
// 서블릿 클래스를 인스턴스화함. 이 과정에서 controllerMap에 데이터가 삽입됨
// 그리고 init() -> 서블릿은 싱글톤으로 관리됨 -> urlPatterns로 정의된 요청이 들어올 때마다 서블릿 매핑시켜서 처리
@WebServlet(name="FrontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {
  private Map<String, ControllerV2> controllerMap = new HashMap<>();

  public FrontControllerServletV2() {
    controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
    controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
    controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String requestURI = request.getRequestURI();
    ControllerV2 controller = controllerMap.get(requestURI);
    if(controller == null) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
      return;
    }

    MyView view = controller.process(request, response);
    view.render(request, response);
  }
}
