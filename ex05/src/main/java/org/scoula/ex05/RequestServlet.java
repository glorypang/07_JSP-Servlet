package org.scoula.ex05;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // Scope : page < request < session < application
        // request scope 객체 : 요청 ~ 응답 완료까지 데이터 유지
        // 속성 설정
        req.setAttribute("username", "홍길동");
        req.setAttribute("useraddress", "서울");

        // RequestDispatcher : 요청 발송자
        // -> 현재 서블릿이 처리중인 요청을 다른 서블릿/JSP로 전달하는 객체
        // forward : 요청 위임(HttpServletRequest, HttpServletResponse)
        // - HttpServletRequest : 클라이언트 요청 정보를 담고있는 객체
        // - HttpServletResponse : 클라이언트에게 응답 방법을 가지고 있는 객체

        // "/res.jsp" 에서 제일 앞 "/"
        // == src/main/webapp 폴더
        RequestDispatcher dis = req.getRequestDispatcher("/res.jsp");
        dis.forward(req, res);
    }
}