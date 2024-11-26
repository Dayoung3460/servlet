package hello.servlet.web.frontController.v5.adapter;

import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.v4.ControllerV4;
import hello.servlet.web.frontController.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
  @Override
  public boolean supports(Object handler) {
    return (handler instanceof ControllerV4);
  }

  @Override
  public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
    ControllerV4 controller = (ControllerV4) handler;

    HashMap<String, String> paramMap = createParamMap(request);
    HashMap<String, Object> model = new HashMap<>();

    String viewName = controller.process(paramMap, model);

    ModelView mv = new ModelView(viewName);
    mv.setModel(model);

    return mv;
  }

  private HashMap<String, String> createParamMap(HttpServletRequest request) {
    HashMap<String, String> paramMap = new HashMap<>();
    request.getParameterNames().asIterator().forEachRemaining(paramName ->
            paramMap.put(paramName, request.getParameter(paramName))
    );
    return paramMap;
  }
}
