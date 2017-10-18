<%--
  Created by IntelliJ IDEA.
  User: Igor Zhazhky
  Date: 09.09.2017
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Part3</title>
    <jsp:include page="index.jsp"></jsp:include>
</head>
<body>
<form action="part3" method="post">
    <div>
        <input name="name" type="text" placeholder="Name">
    </div>
    <div class="form-group">
        <button name="button1" type="submit">Submit</button>
    </div>
    <div>
        <table border="2">
            <c:forEach items="${sessionScope.list}" var="name">
                <tr>
                    <td>${name}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
<a href="part3_clear"><button name="button2" type="submit">Remove</button></a>
</body>
</html>
