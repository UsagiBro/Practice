<%--
  Created by IntelliJ IDEA.
  User: Igor Zhazhky
  Date: 09.09.2017
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
  <div class="right" style="float: right">

    <ul><p>you are logged as ${sessionScope.get("role")} ${sessionScope.get("login")}</p>
      <li><a href="part1.jsp">Part1</a></li>
      <li><a href="part2.jsp">Part2</a></li>
      <li><a href="part3.jsp">Part3</a></li>
     </ul>
    </div>
  </body>
</html>
