<%--
  Created by IntelliJ IDEA.
  User: Igor Zhazhky
  Date: 09.09.2017
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Part1</title>
    <jsp:include page="index.jsp"></jsp:include>
</head>
<body>
<table border="1px">
    <% for (int i = 1; i < 10; i++) {
    %>
    <tr><%
        for (int j = 1; j < 10; j++) {%>
        <td>
            <%=i * j%>
        </td>
        <%}%>
    </tr>
    <% } %>
</table>
</body>
</html>
