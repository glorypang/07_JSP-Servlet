<%--
  Created by IntelliJ IDEA.
  User: dys11
  Date: 25. 6. 4.
  Time: 오전 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
</head>
<body>
    <%--
        Servlet에서 위임 받은 request, response 사용 가능
    --%>
    username 값: <%=request.getAttribute("username") %><br>
    useraddress 값: <%=request.getAttribute("useraddress") %><br>
</body>
</html>
