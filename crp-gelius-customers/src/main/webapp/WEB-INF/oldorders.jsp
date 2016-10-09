<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<head>
  <title>Страница менеджера - CRP-Gelius</title>
  <link rel="stylesheet" type="text/css" href="../content/css/style.css" />
  <link rel="shortcut icon" href="../img/favicon.ico" />
  <script type="text/javascript" src="../script/gelius.js"></script>
</head>
<body>
<div id="stripe">
  <div align="right">Менеджер: &nbsp;<b style="color: #f3efbd"><img src="../img/usr2.png"/>${usrlogin} &nbsp;</b>
    <button onclick="SettingUpAccount()"><img src="../img/wheel.png"/>Настройки аккаунта</button>
    <button onclick="LogOut()"><img src="../img/exit.png"/>Выйти</button> &nbsp;
  </div>
</div>
<div>
  <br/>
  <br/>
  <h3>Вы на странице истории выполненных заявок.</h3>
  <%--<hr/>--%>
  <%--<p><h4>Текущие заявки:</h4>--%>
  <%--<select size="10" name="old_orders">--%>
  <%--</select>--%>
  <%--<input type="button" value="Просмотреть состояние" onclick="" />--%>
  <%--<input type="button" value="Отмена" onclick="CancelOrder()">--%>
  <%--</p>--%>
</div>
</body>
</html>