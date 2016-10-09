<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Страница планировщика - CRP-Gelius</title>
    <link rel="stylesheet" type="text/css" href="../content/css/style.css" />
    <link rel="shortcut icon" href="../img/favicon.ico" />
    <script type="text/javascript" src="../script/gelius.js"></script>
    <script src="http://code.jquery.com/jquery-1.9.0.js"></script>
</head>
<script type="text/javascript">
    $(document).ready(
            function () {
                $("#planrow").click(clickAction())
            });

    function clickAction() {
        $("#planrow").click(
                function() {
                    var planId = $("#planrow").val();
                    if (planId != null) {
                        console.log(planId);
                        $.post("/plandetails.do", ("planid=" + planId),
                                function (responsetext) {
                                    responsetext = "" + responsetext;
                                    $("#answer").text(responsetext);
                                });
                    }
                });
        $("")
    }

</script>
<body>
<div id="stripe">
    <div align="right">Планировщик: &nbsp;<b style="color: #f3efbd"><img src="../img/usr2.png"/>${usrlogin} &nbsp;</b>
        <button onclick="SettingUpAccount()"><img src="../img/wheel.png"/>Настройки аккаунта</button>
        <button onclick="LogOut()"><img src="../img/exit.png"/>Выйти</button> &nbsp;
    </div>
</div>
<div>
    <br/>
    <br/>
    <h3>Вы находитесь на главной странице планирования производства</h3>
    <hr/>
    <h4>Текущие планы: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
        &nbsp; &nbsp; &nbsp;<br/>
        <form name="details">
        <select id="planrow" name="planrow" onclick="clickAction()" size="11">
            <c:forEach items="${plans}" var="item">
                <option name="type" value="${item.id}">#${item.order.id}(${item.order.certificate.title}
                    (согл. тех.паспорту №${item.order.certificate.id}) - ${item.order.quantity}шт.)</option>
            </c:forEach>
        </select>
        <textarea name="details" class="area" id="answer" rows="11" cols="25"
                  placeholder="Для просмотра состояния выберите план"></textarea>
        </form>
    </h4>
    <br/>
    <br/>
    <input type="button" value="Новые заявки(${newordercount})" onclick="location.href='/neworders.do'"
    ${newordercount == 0 ? "disabled = 'disabled'" : ""}/>
    <input type="button" value="Смотреть историю" onclick="location.href='/oldplans.do'"/>
    <p style="color: #e32947">${error}</p>
</div>
</body>
</html>
