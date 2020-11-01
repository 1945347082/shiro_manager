<%@page contentType="text/html; utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
   <h1>用户注册</h1>
   <form action="${pageContext.request.contextPath}/user/register" method="post">
       <label>用户名:<input type="text" name="username"></label><br/>
       <label>密码:<input type="text" name="password"><br/></label>
       <label><input type="submit" value="注册"></label>
   </form>
</body>
</html>
