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
    <script src="http://code.jquery.com/jquery-1.9.0.js"></script>
</head>
<script type="text/javascript">
    $(document).ready(
            function () {
                $("#orderrow").click(clickAction())
            });

    function clickAction() {
        $("#orderrow").click(
                function() {
                    var orderId = $("#orderrow").val();
                    if (orderId != null) {
                        console.log(orderId);
                        $.post("/orderdetails.do", ("orderid=" + orderId),
                                function (responsetext) {
                                    responsetext = "" + responsetext;
                                    $("#answer").text(responsetext)
                                });
                    }
                });
        $("")
    }
</script>
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
        <h3>Вы находитесь на главной странице менеджмента производства</h3>
        <hr/>
        <p>
        <h4>Текущие заявки: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            &nbsp; &nbsp; &nbsp;<br/>
        <form name="details">
        <select id="orderrow" name="orderrow" size="11">
            <c:forEach items="${orders}" var="item">
                <option name="type" value="${item.id}"
                ${item.plan == null ? 'style="color: gainsboro"' : ''}>
                #${item.id}(согласно тех.паспорту №${item.certificate.id} - ${item.quantity} шт.)</option>
            </c:forEach>
        </select>
            <textarea name="details" class="area" id="answer" rows="12" cols="25"
                      placeholder="Для просмотра состояния выберите заявку"></textarea>
        </form>
        </h4>
        <br/>
        <br/>
        <input type="button" value="К списку технических паспортов" onclick="Certificates()"/>
        <input type="button" value="Создать заявку или тех.паспорт" onclick="NewOrder()"/> &nbsp;
        <input type="button" value="Журнал" onclick="location.href='/historymanager.do'">
        <p style="color: #e32947">${error}</p>
    </div>
</body>
</html>