package org.scoula.ex02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/response")
public class ResponseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        // MIME 타입 설정
        resp.setContentType("text/html;charset=UTF-8");

        // 클라이언트와 연결된 문자 데이터 출력 스트림 얻어오기
        PrintWriter out = resp.getWriter();

        // HTML 작성 및 출력
        out.print("<html><body>");
        out.print("<h1>ResponseServlet 요청 성공</h1>");
        out.print("<p>현재 시간: " + new java.util.Date() + "</p>");
        out.print("<a href='/'>홈으로</a>");
        out.print("</body></html>");
    }
}