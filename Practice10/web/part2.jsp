<%--
  Created by IntelliJ IDEA.
  User: Igor Zhazhky
  Date: 09.09.2017
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Part2</title>
    <jsp:include page="index.jsp"></jsp:include>
</head>
<body>
    <table border="2px">
        <c:forEach var = "i" begin = "1" end = "9">
            <tr>
                <c:forEach var="j" begin="1" end="9">
                    <td>
                        <c:out value = "${i * j}"/>
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
