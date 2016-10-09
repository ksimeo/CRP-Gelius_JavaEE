<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>История работы менеджера - CRP-Gelius</title>
</head>
<body>
<div id="stripe">
  <div align="right">Менеджер: &nbsp;<b style="color: #f3efbd"><img src="../../img/usr2.png"/>${usrlogin} &nbsp;</b>
    <button onclick="SettingUpAccount()"><img src="../../img/wheel.png"/>Настройки аккаунта</button>
    <button onclick="LogOut()"><img src="../../img/exit.png"/>Выйти</button> &nbsp;
  </div>
</div>
<h2>Вы на странице истории выполнения работ менеджера.</h2>
</body>
</html>