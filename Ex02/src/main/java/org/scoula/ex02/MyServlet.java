package org.scoula.ex02;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

// Servlet 등록 + 매핑 자동화
@WebServlet(name="MyServlet", urlPatterns={"/xxx", "/yyy"})
public class MyServlet extends HttpServlet {

    // GET 방식 요청 메서드 오버라이딩
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // MIME Type 지정
        resp.setContentType("text/html;charset=UTF-8");

        // 서버 -> 클라이언트 출력 스트림 얻어오기
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head><title>My Servlet 응답페이지</title></head>");
        out.println("<body>");
        out.println("<h1>Hello MyServlet</h1>");
        out.println("현재 시간: " + LocalDateTime.now().toString());
        out.println("</body>");
        out.println("</html>");
    }
}
