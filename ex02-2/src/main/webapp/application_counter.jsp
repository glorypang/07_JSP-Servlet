<%@ page contentType="text/html; charset=UTF-8" %>
<%
    // 애플리케이션 범위의 카운터
    Integer visitCount = (Integer)application.getAttribute("visitCount");
    if (visitCount == null) {
        visitCount = 0;
    }
    visitCount++;
    application.setAttribute("visitCount", visitCount);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>애플리케이션 카운터</title>
</head>
<body>
<h1>이 페이지의 총 방문 횟수: <%= visitCount %></h1>
<p>서버 정보: <%= application.getServerInfo() %></p>
</body>
</html>