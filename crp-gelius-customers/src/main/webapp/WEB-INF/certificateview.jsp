<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Технические паспорта - CRP-Gelius</title>
    <link rel="stylesheet" type="text/css" href="../content/css/style.css" />
    <link rel="shortcut icon" href="../img/favicon.ico" />
    <script type="text/javascript" src="../script/gelius.js"></script>
</head>
<body id="shadowed">
<div id="stripeshadowed">
  <div align="right">Менеджер: &nbsp;<b style="color: #f3efbd"><img src="../img/usr2.png"/> ${usrlogin} &nbsp;</b>
    <button onclick="SettingUpAccount()"><img src="../img/wheel.png"/>Настройки аккаунта</button>
    <button onclick="LogOut()"><img src="../img/exit.png"/>Выйти</button> &nbsp;
  </div>
</div>
    <br/>
    <br/>
    <div id="userspalnk">
    <form action="certificateview.do" method="post">
        <input type="text" name="id" value="${id}" hidden />
    <table>
        <tr>
            <td>
                <h3>Информация о тех.паспорте</h3>
            </td>
        </tr>
        <tr>
            <td>
                <h4>Наименование: &nbsp; ${certtitle}</h4>
            </td>
        </tr>
        <tr>
            <td>
                <h4>Дата создания: &nbsp; <fmt:formatDate pattern="HH:mm:ss dd.MM.yyyy" value="${certdate}"/></h4>
            </td>
        </tr>
        <tr>
            <td>
                <h4>Создатель: &nbsp; ${name} ${surname} (${usrlogin})</h4>
                <h4>e-mail: &nbsp; ${email}</h4>
            </td>
        </tr>
        <tr>
            <td>
                <h4>Файл документа: &nbsp; <a href="docdownload.do?id=${id}">${filename}</a></h4>
            </td>
        </tr>
        <tr>
            <td>
                <hr/>
                <h4>Заказать: &nbsp; <input type="number" style="width: 60px;" name="quantity">&nbsp; шт.</h4>
            </td>
        </tr>
        <tr>
            <td>
                <h4><input type="submit" value="Создать заявку">
                    <input type="button" value="Назад" onclick="CancelCreate()"></h4>
                <p style="color: #e32947">${error}</p>
            </td>
        </tr>
    </table>
    </form>
    </div>
</body>
</html>