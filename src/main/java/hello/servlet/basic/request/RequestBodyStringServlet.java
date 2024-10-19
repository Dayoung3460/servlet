package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 메세지 바디 내용을 바이트 코드로 받아옴
    ServletInputStream inputStream = request.getInputStream();
    // 바이트 코드를 스트링으로 변환. 인코딩 방식 알려주기 utf-8
    String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

    System.out.println("messageBody = " + messageBody);
    response.getWriter().write("ok");
  }
}
