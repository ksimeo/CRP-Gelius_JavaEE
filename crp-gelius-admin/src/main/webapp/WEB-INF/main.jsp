<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Страница администрирования системы - CRP-Gelius</title>
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
    <h2>Вы находитесь на странице администрирования системы.</h2>
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
        <h3><i>Информация о пользователях временно недоступна.</i></h3>
    </div>
    <div>
        <input type="button" value="Добавить пользователя системы" onclick="document.location='/createusr.do'"/>
        <input type="button" value="К списку сертификатов" onclick="document.location='/certs.do'"/>
        <input type="button" value="К списку заявок" onclick="document.location='/orders.do'"/>
        <input type="button" value="К списку планов" onclick="document.location='/plans.do'"/>
    </div>
</body>
</html>