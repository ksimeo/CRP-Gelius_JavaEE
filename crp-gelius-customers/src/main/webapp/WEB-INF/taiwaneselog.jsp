<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Журнал работ - CRP-Gelius</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../content/css/style.css" />
    <link rel="shortcut icon" href="../img/favicon.ico" />
    <script type="text/javascript" src="../script/gelius.js"></script>
</head>
<script type="text/javascript">
    var page = ${page}

            function changePage(shift) {
                p = page + shift;
                if (page > 0) {
                    document.location = "/taiwaneselog.do?p=" + page;
                }
            }
</script>
<body>
<div id="stripe">
    <div align="right">Рабочий центр Упаковщик: &nbsp;<b style="color: #f3efbd"><img src="../img/usr2.png"/>${usrlogin} &nbsp;</b>
        <button onclick="SettingUpAccount()"><img src="../img/wheel.png"/>Настройки аккаунта</button>
        <button onclick="LogOut()"><img src="../img/exit.png"/>Выйти</button> &nbsp;
    </div>
</div>
<h2>Журнал выполненных и ожидаемых работ рабочего места "Тайванец"</h2>
<br/>
<table>
    <th>
    <td>Порядковый номер</td>
    <td>Заявка</td>
    <td>Согл.тех.паспорту</td>
    <td>Формат</td>
    <td>Плотность</td>
    <td>Колич. слоев(шт.)</td>
    <td>Количество (шт.)</td>
    <td>Планируемая дата</td>
    <td>Планируемая смена</td>
    <td>Фактическая дата</td>
    <td>Фактическая смена</td>
    </th>
    <c:forEach var="item" items="${plans}">
    <tr>
        <td>${item.id}</td>
        <td>${item.order.id}</td>
        <td>№${item.order.certificate.title}.&nbsp;${item.order.certificate.title}</td>
        <td>${item.format}</td>
        <td>${item.density}</td>
        <td>${item.layers}</td>
        <td>${item.quantity}</td>
        <td>${item.taiwaneseDatePlan}</td>
        <td>${item.taiwaneseShiftPlan == "DAY" ? "Дневная" : "Ночная"}</td>
        <td>${item.taiwaneseDateFact}</td>
        <td>${item.taiwaneseShiftFact == "DAY" ? "Дневная" : "Ночная"}</td>
    </tr>
    </c:forEach>
</table>
<p>
    <input type="button" value="<-" onclick="changePage(-1)"/>
    <textarea type="text" value="Стр. ${page}" rows="1" cols="2"></textarea>
    <%--Страница &nbsp; ${page}--%>
    <input type="button" value="->" onclick="changePage(1)"/>
</p>
</body>
</html>