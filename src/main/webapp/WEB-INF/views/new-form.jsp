<%--
  Created by IntelliJ IDEA.
  User: runnz
  Date: 2021-08-23 0023
  Time: 오후 7:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save] 다른곳에서도 이곳으로 호출해서 쓸 경우 상대경로로 씀-->
<form action="save" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>
