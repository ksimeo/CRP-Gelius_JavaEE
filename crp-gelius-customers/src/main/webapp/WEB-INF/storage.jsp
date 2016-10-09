<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Рабочий центр "Тайванец" - CRP-Gelius</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../content/css/style.css" />
    <link rel="shortcut icon" href="../img/favicon.ico" />
    <script type="text/javascript" src="../script/gelius.js"></script>
</head>
<body>
<script type="text/javascript">
    function ajaxAllGot(id) {

    }

    function ajaxAllDeparture(id) {

    }
</script>
<div id="stripe">
    <div align="right">Рабочий центр Бобст: &nbsp;<b style="color: #f3efbd"><img src="../img/usr2.png"/>${usrlogin} &nbsp;</b>
        <button onclick="SettingUpAccount()"><img src="../img/wheel.png"/>Настройки аккаунта</button>
        <button onclick="LogOut()"><img src="../img/exit.png"/>Выйти</button> &nbsp;
    </div>
</div>
<br/>
<br/>
<h3>Вы находитесь на странице склада</h3>
<div ${hiddentable}>
<table id = "t">
    <thead>
    <tr>
        <th>№ заявки</th>
        <th>Согл. тех.паспорту</th>
        <th>Количество всего (шт.)</th>
        <th>Количество получено (шт.)</th>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${plans}">
        <tr>
            <td>${item.id}</td>
            <td>
                <a href="docdownload.do?id=${item.order.certificate.id}">
                        ${item.order.certificate.id}.${item.order.certificate.title}</a>
            </td>
            <td>
                ${item.order.quantity} шт.
            </td>
            <td>
                ${item.storageGot} шт.
            </td>
            <td>
                <div hidden="${item.storageDate == null ? '' : 'hidden'}">
                    <input type="button" value="Получено" onclick="location.href='allstoragegot.do?id=${item.id}'"/>
                </div>
                <div hidden="${item.storageDate == null ? 'hidden' : ''}">
                    <h4>${item.storageDate}</h4>
                </div>
            </td>
            <td>
                <div hidden="${item.departureDate == null ? '' : 'hidden'}">
                    <input type="button" value="Получено" onclick="location.href='alldepartures.do?id=${item.id}'" />
                </div>
                <div hidden="${item.departureDate == null ? 'hidden' : ''}" >
                    <h4>${item.departureDate}</h4>
                <%--</div>--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<div ${hiddentext}>
    <br/>
    <br/>
    <h4 style="color: darkgrey;">Нет элементов удовлетворяющих условиям просмотра.</h4>
</div>
</body>
</html>