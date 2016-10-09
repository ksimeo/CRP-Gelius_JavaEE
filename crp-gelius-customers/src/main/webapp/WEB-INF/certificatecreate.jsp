<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<head>
  <meta charset="utf-8" />
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
<form method="post" action="certificatecreate.do" enctype="multipart/form-data">
    <br/>
    <br/>
    <div id="userspalnk">
    <table>
    <tr>
        <h4>Для создания нового тех.паспорта, пожалуйста, <br/>
            введите полное его наименование, прикрепите файл документа</h4>
    </tr>
    <tr>
        <td>
            Полное наименование: &nbsp; <br/>
            <textarea name="cert.title" id="area" rows="10" cols="45" placeholder="Введите текcт"></textarea>
        </td>
    </tr>
    <tr>
        <td>
            <br/>
            <h4>Файл документа: &nbsp; <input type="file" name="file" id="file" accept="application/pdf,
             application/vnd.sealed-tiff, image/jpeg, image/png, image/gif"/>
            </h4>
        </td>
    </tr>
    <tr>
        <td>
            <h4><input type="submit" value="Создать"/>
            <input type="button" value="Отмена" onclick="CancelCreate()"></h4>
            <p style="color: #e32947">${error}</p>
        </td>
    </tr>
</table>
    </div>
</form>
</body>
</html>
