package org.scoula.ex05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request_redirect")
public class RequestRedirectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //속성 설정
        req.setAttribute("username", "홍길동");
        req.setAttribute("useraddress", "서울");

        //redirect == 클라이언트에게 "response_redirect"로 다시 요청하라고 지시
        res.sendRedirect("response_redirect");
    }
}