package hello.servlet.web.frontController.v1;

import hello.servlet.web.frontController.v1.Controller.MemberFormControllerV1;
import hello.servlet.web.frontController.v1.Controller.MemberListControllerV1;
import hello.servlet.web.frontController.v1.Controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// /front-controller/v1/ 를 포함한 모든 하위 url
@WebServlet(name="FrontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {
  private Map<String, ControllerV1> controllerMap = new HashMap<>();

  // /front-controller/v1/memBers/new-form 에서
  // form action='save'
  // 상대경로로 되어있음
  // /front-controller/v1/memBers/save
  // 이 경로로 오게됨
  public FrontControllerServletV1() {
    controllerMap.put("/front-controller/v1/memBers/new-form", new MemberFormControllerV1());
    controllerMap.put("/front-controller/v1/memBers/save", new MemberSaveControllerV1());
    controllerMap.put("/front-controller/v1/memBers", new MemberListControllerV1());
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // ex) /front-controller/v1/memBers/new-form
    String requestURI = request.getRequestURI();
    ControllerV1 controller = controllerMap.get(requestURI);
    if(controller == null) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
      return;
    }

    controller.process(request, response);
  }
}
