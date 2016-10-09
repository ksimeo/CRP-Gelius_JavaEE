<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Технические паспорта - CRP-Gelius</title>
    <link rel="stylesheet" type="text/css" href="../content/css/style.css" />
    <link rel="shortcut icon" href="../img/favicon.ico" />
    <script type="text/javascript" src="../script/gelius.js"></script>
</head>
<script type="text/javascript">
    var id;

    function OnChangeItem() {
        document.getElementById('viewbutton').disabled = 0;
        id = document.getElementById('area').options[document.getElementById('area').selectedIndex].id;
    }

    function CertificateView() {
        document.location = "/certificateview.do?id=" + id;
    }
</script>
<body>
    <div id="stripe">
        <div align="right">Менеджер: &nbsp;<b style="color: #f3efbd"><img src="../img/usr2.png"/> ${usrlogin} &nbsp;</b>
        <button onclick="SettingUpAccount()"><img src="../img/wheel.png"/>Настройки аккаунта</button>
        <button onclick="LogOut()"><img src="../img/exit.png"/>Выйти</button> &nbsp;
        </div>
    </div>
    <div>
        <br/>
        <br/>
        <h3>Имеющиеся технические паспорта:</h3>
        <select id="area" size="10" onchange="OnChangeItem()">
            <c:forEach items="${certs}" var="item">
                <option name="type" id="${item.id}">${item.id}. ${item.title}</option>
            </c:forEach>
        </select>
        <br/>
        <br/>
        <input id="viewbutton" type="button" value="Просмотреть" onclick="CertificateView()"
        disabled = "disabled"/>
        <input type="button" value="Создать технический паспорт" onclick="CreateCertificate()"/>
        <input type="button" value="Отмена" onclick="CancelOrder()" />
        <br/>
    </div>
</body>
</html>