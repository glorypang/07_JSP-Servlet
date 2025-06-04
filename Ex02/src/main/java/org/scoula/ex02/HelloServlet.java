package org.scoula.ex02;

import java.io.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        // "/lifecycle" url로 첫 요청 시 Servlet instance가 생성 되면서 1회만 실행됨

        System.out.println("=== init() 호출 ===");
        // 초기화 작업
        super.init();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("=== doGet() 호출 ===");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<p>현재 시간: " + new java.util.Date() + "</p>");
    }




    @Override
    public void destroy() {
        // 서버 재배포 시 기존 Servlet Instance를 파괴하기 위해 1회만 수행됨
        System.out.println("=== destroy() 호출 ===");
        // 정리 작업
        super.destroy();
    }
}