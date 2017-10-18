<%--
  Created by IntelliJ IDEA.
  User: Igor Zhazhky
  Date: 02.09.2017
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>calc</title>
</head>
<body>
    <form action="calc" method="get">
        <input type="text" name="x">
        <input type="text" name="y">
        <select id="op" name="op" class="form-control">
            <option value="plus">+</option>
            <option value="minus">-</option>
        </select>
        <a href="answer.jsp"><button type="submit" >Submit</button></a>
    </form>
</body>
</html>
