package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name="requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String method = req.getMethod();
    System.out.println(method);

    Enumeration<String> headerNames = req.getHeaderNames();

    while (headerNames.hasMoreElements()) {
      String s = headerNames.nextElement();
      System.out.println("s = " + s);
    }

    req.getHeaderNames().asIterator().forEachRemaining(headerName -> System.out.println("headerName:" + headerName));

    System.out.println("req.getServerName() = " + req.getServerName());
    System.out.println("req.getContentType() = " + req.getContentType());
  }
}
