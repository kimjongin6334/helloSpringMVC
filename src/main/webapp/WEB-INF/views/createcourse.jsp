<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2024-03-11
  Time: 오후 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/main.css" >

</head>
<body>
<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="course">
    <table class="formtable">
        <tr>
            <td class="label"> 년도:</td>
            <td><sf:input class="control" rows="10" cols="10" path="name"/>  <br/>
                <sf:errors path="name" class="error"/>
            </td>
        </tr>
        <tr>
            <td class="label"> 학기:</td>
            <td><sf:input class="control" rows="10" cols="10" path="email"/> <br/>
                <sf:errors path="email" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 교과목명:</td>
            <td><sf:textarea class="control" type="text" path="text"/> <br/>
                <sf:errors path="text" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 담당교수:</td>
            <td><sf:textarea class="control" type="text" path="text1"/> <br/>
                <sf:errors path="text1" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 학점:</td>
            <td><sf:textarea class="control" rows="10" cols="10" path="text2"/> <br/>
                <sf:errors path="text2" class="error" />
            </td>
        </tr>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="수강신청"/> </td>
        </tr>
    </table>
</sf:form>
</body>
</html>