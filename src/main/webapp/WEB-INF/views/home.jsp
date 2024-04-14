  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <html>
  <head>
    <title>학사 정보 시스템 홈페이지</title>
  </head>
  <body>
  <h1>학사 정보 시스템</h1>

  <!-- 누구나 접근 가능한 항목 -->
  <p><a href="${pageContext.request.contextPath}/courses">학년별 이수 학점 조회</a></p>
  <p><a href="${pageContext.request.contextPath}/createcourse">수강 신청하기</a></p>
  <p><a href="${pageContext.request.contextPath}/course-registration-inquiry">수강 신청 조회</a></p>

  <!-- 로그인한 사용자만 접근 가능한 항목 -->
  <c:if test="${pageContext.request.userPrincipal != null}">
    <form id="logoutForm" action="${pageContext.request.contextPath}/logout" method="post">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      <input type="submit" value="로그아웃" />
    </form>
  </c:if>

  <!-- 로그인하지 않은 사용자를 위한 로그인 링크 -->
  <c:if test="${pageContext.request.userPrincipal == null}">
    <p><a href="${pageContext.request.contextPath}/login">로그인</a></p>
  </c:if>
  </body>
  </html>
