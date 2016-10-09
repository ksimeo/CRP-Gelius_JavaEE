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
<script type="text/javascript">

</script>
<body>
<div id="stripe">
    <div align="right">Рабочий центр Тайванец: &nbsp;<b style="color: #f3efbd"><img src="../img/usr2.png"/>${usrlogin} &nbsp;</b>
        <button onclick="SettingUpAccount()"><img src="../img/wheel.png"/>Настройки аккаунта</button>
        <button onclick="LogOut()"><img src="../img/exit.png"/>Выйти</button> &nbsp;
    </div>
</div>
<br/>
<br/>
<h3>Вы находитесь на странице рабочего центра "Тайванец"</h3>
<div ${hiddentable}>
<table id = "t">
    <thead>
<tr>
    <th>№ заявки</th>
    <th>По тех.паспорту</th>
    <th>Формат</th>
    <th>Плотность(г/см3)</th>
    <th>Количество слоев шт.</th>
    <th>Количество шт.</th>
    <th>Выполнено шт.</th>
    <th>Требуемая дата выполнения</th>
    <th>Смена</th>
    <th></th>
</tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${plans}">
        <tr>
            <td>${item.order.id}</td>
            <td><a href="docdownload.do?id=${item.order.certificate.id}">№${item.order.certificate.id}.${item.order.certificate.title}</a></td>
            <td>${item.format}</td>
            <td>${item.density}</td>
            <td>${item.layers}</td>
            <td>${item.order.quantity} шт.</td>
            <td>${item.taiwanDone}</td>
            <td><fmt:formatDate pattern="dd.MM.yy" value="${item.taiwaneseDatePlan}"/></td>
            <td>${item.taiwaneseShiftPlan == "DAY" ? "Дневная" : "Ночная"}</td>
            <td>
                <form action="parttaiwandone.do" method = "post">
                    <input type="text" name="planid" value="${item.id}" hidden/>
                    <input type="button" value="Выполнено на 100%" onclick="location.href='alltaiwandone.do?id=${item.id}'"/>
                    <input type="submit" value="Выполнено"/>
                    <input type="number" name="quant" style="width: 7%"/> шт.
                </form>
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
