<%@page contentType="text/html; utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="shrio" uri="http://shiro.apache.org/tags" %>
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
<h1>系统主页1.0</h1>
<label><a href="${pageContext.request.contextPath}/user/logout">退出</a> </label>
<ul>

    <li><a href="">用户管理</a></li>

    <ul>
        <shiro:hasPermission name="user:add:01"><li><a href="">添加</a> </li></shiro:hasPermission>
        <shiro:hasPermission name="user:update:*"><li><a href="">修改</a></li></shiro:hasPermission>
        <shiro:hasPermission name="user:find:*"><li><a href="">查询</a></li></shiro:hasPermission>
        <shiro:hasPermission name="order:delete"><li><a href="">删除</a></li></shiro:hasPermission>
    </ul>

    <shiro:hasRole name="admin">
    <li><a href="">商品管理</a></li>
    <li><a href="">订单管理</a></li>
    <li><a href="">物流管理</a></li>
    </shiro:hasRole>
</ul>


</body>
</html>
