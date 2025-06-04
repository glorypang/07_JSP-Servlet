<%--
  Created by IntelliJ IDEA.
  User: dys11
  Date: 25. 6. 4.
  Time: 오후 1:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"   %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>JSTL 예제</title>
</head>
<body>
    <h2> c:out - 지정된 범위에 변수 설정</h2>

    <c:set var="username" value="KB_User" scope="request" />
    <p>사용자 이름: ${username}</p>

    <hr>
    <h2> c:out - EL 표현식의 결과나 지정된 값 출력</h2>
    <c:set var="message" value="<b>Hello</b> JSTL!" />

    <p>이스케이프 안 함: <c:out value="${message}" escapeXml="false" /></p>
    <p>이스케이프 함: <c:out value="${message}" /></p>

    <hr>
    <h2> c:if - 단일 조건문 </h2>
    <c:set var="score" value="85" />
    <c:if test="${score >= 90}">
        <p>점수가 90점 이상입니다 (A학점)</p>
    </c:if>
    <c:if test="${score < 60}">
        <p>점수가 60점 미만입니다 (F학점)</p>
    </c:if>

    <hr>
    <h2> c:choose, c:when, c:otherwise - 다중 조건문 </h2>
    <c:set var="grade" value="B" />
    <c:choose>
        <c:when test="${grade eq 'A'}">
            <p>Excellent!</p>
        </c:when>
        <c:when test="${grade eq 'B'}">
            <p>Good!</p>
        </c:when>
        <c:otherwise>
            <p>Try Harder!</p>
        </c:otherwise>
    </c:choose>

    <hr>
    <h2> c:forEach - 반복문 </h2>
    <%-- 숫자 반복 --%>
    <p>1부터 5까지 반복:</p>
    <ul>
        <c:forEach var="i" begin="1" end="5">
            <li>${i}</li>
        </c:forEach>
    </ul>

    <%-- 배열/리스트 반복 --%>
    <c:set var="fruits" value="${['사과', '바나나', '오렌지', '포도']}" />
    <p>과일 목록:</p>
    <ul>
        <c:forEach var="fruit" items="${fruits}" varStatus="status">
            <li>${status.index}. ${fruit} ${status.first ? '(첫 번째)' : ''} ${status.last ? '(마지막)' : ''}</li>
        </c:forEach>
    </ul>

    <hr>

    <c:set var="price" value="12345.678" />
    <c:set var="percentage" value="0.75" />

    <p>일반 숫자: <fmt:formatNumber value="${price}" type="number" /></p>
    <p>통화: <fmt:formatNumber value="${price}" type="currency" currencySymbol="₩" /></p>
    <p>퍼센트: <fmt:formatNumber value="${percentage}" type="percent" /></p>
    <p>소수점 두 자리: <fmt:formatNumber value="${price}" pattern="#,##0.00" /></p>

    <h4>request scope에 세팅된 today 사용</h4>

    <p>
        <b>원본 Date 객체 출력 확인</b><br>
        ${today}
    </p>

    <p>
        <b>날짜만 출력 (type="date")</b><br>
        <fmt:formatDate value="${today}" type="date"/>
    </p>

    <p>
        <b>시간만 출력 (type="time")</b><br>
        <fmt:formatDate value="${today}" type="time"/>
    </p>

    <p>
        <b>날짜와 시간 모두 출력 (type="both")</b><br>
        <fmt:formatDate value="${today}" type="both"/>
    </p>

    <p>
        <b>날짜 짧게, 시간 길게 출력 (dateStyle, timeStyle 조합)</b><br>
        <fmt:formatDate value="${today}" type="both" dateStyle="short" timeStyle="long"/>
    </p>

    <p>
        <b>날짜 길게, 시간 짧게 출력 (dateStyle, timeStyle 조합)</b><br>
        <fmt:formatDate value="${today}" type="both" dateStyle="long" timeStyle="short"/>
    </p>

    <p>
        <b>사용자 정의 패턴 출력 (24시간 형식)</b><br>
        <fmt:formatDate value="${today}" pattern="YYYY-MM-dd HH:mm:ss"/>
    </p>

    <p>
        <b>사용자 정의 패턴 출력 (12시간 형식 + AM/PM)</b><br>
        <fmt:formatDate value="${today}" pattern="YYYY-MM-dd a hh:mm:ss"/>
    </p>

    <c:set var="myString" value="  Hello JSTL Functions!  " />
    <c:set var="email" value="test@example.com" />

    <p>문자열 길이: ${fn:length(myString)}</p>
    <p>앞뒤 공백 제거: '${fn:trim(myString)}'</p>
    <p>모두 대문자: ${fn:toUpperCase(myString)}</p>
    <p>'Functions' 포함 여부: ${fn:contains(myString, 'Functions')}</p>
    <p>'test@example.com'이 '.com'으로 끝나는가? ${fn:endsWith(email, '.com')}</p>
</body>
</html>