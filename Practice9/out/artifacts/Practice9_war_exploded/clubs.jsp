<%--
  Created by IntelliJ IDEA.
  User: Igor Zhazhky
  Date: 02.09.2017
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clubs</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div>
    <form method="get" action="clubs">
        <table>
            <tr>
                <td data-title="club">${club}</td>
                <td data-title="votes">1</td>
                <td data-title="user">${user}</td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
