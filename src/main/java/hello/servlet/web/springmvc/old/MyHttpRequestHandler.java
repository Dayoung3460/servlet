package hello.servlet.web.springmvc.old;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import java.io.IOException;

// 스프링의 BeanNameUrlHandlerMapping이 실행됨
// 빈이름("/springmvc/request-handler")으로 핸들러 찾아줌
// MyHttpRequestHandler 반환
// 어댑터를 돌다가 맞는 어댑터(HttpRequestHandlerAdapter) 찾으면 handleRequest를 호출해줌
@Component("/springmvc/request-handler")
public class MyHttpRequestHandler implements HttpRequestHandler {

  @Override
  public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("MyHttpRequestHandler.handleRequest");
  }
}
