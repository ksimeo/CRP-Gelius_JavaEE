<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Администрирование списка сертификатов - CRP-Gelius</title>
    <link rel="stylesheet" type="text/css" href="../content/css/style.css" />
    <link rel="shortcut icon" href="../img/favicon.ico" />
    <script type="text/javascript" src="../script/gelius.js"></script>
</head>
<body>
    <div id="stripe">
        <div align="right"><b><img src="../img/usr2.png"/>Администратор системы: &nbsp; ${usrlogin}&nbsp;</b>
        <button onclick="SettingUpAccount()"><img src="../img/wheel.png"/>Настройки аккаунта</button>
        <button onclick="LogOut()"><img src="../img/exit.png"/>Выйти</button> &nbsp;
    </div>
    </div>
    <br/>
    <br/>
    <br/>
    <h2>Список сертификатов</h2>
    <br/>
    <div ${tablevision}>
    <table id="t">
        <thead>
            <tr>
                <th>N</th>
                <th>Логин</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Статус</th>
                <th>&nbsp;</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.login}</td>
                <td>${item.name}</td>
                <td>${item.surname}</td>
                <td>${item.role}</td>
        <td><input type="button" value="Удалить" onclick=""></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<div ${substitute}>
  <br/>
  <br/>
  <h3><i>Информация о сертификатах временно недоступна.</i></h3>
</div>
<div>
  <input type="button" value="На предыдущую страницу" onclick="document.location='/admin.do'"/>
</div>
</body>
</html>