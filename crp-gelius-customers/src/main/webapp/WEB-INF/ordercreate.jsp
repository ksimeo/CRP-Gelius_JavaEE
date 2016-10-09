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

    function OnSelect() {
        var id = document.getElementById('certs').options[document.getElementById('certs').selectedIndex].id;
    }
</script>
<body>
<div id="stripe">
  <div align="right"><b><img src="../img/usr2.png"/> ${usrlogin} &nbsp;</b>
    <button onclick="SettingUpAccount()"><img src="../img/wheel.png"/>Настройки аккаунта</button>
    <button onclick="LogOut()"><img src="../img/exit.png"/>Выйти</button> &nbsp;
  </div>
</div>
<form method="post" action="createorder.do">
  <br/>
  <br/>
  <h3>Для создания новой заявки выберите тех. паспорт и укажите нужное количество заказа</h3>
  <hr/>
  <br/>
  <br/>
  <p>Полное наименование: &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
  &nbsp; &nbsp; &nbsp;<br/>
  <select id="area" size="10" name="certs" onchange="OnChangeItem()">
      <c:forEach items="${certs}" var="item">
          <option name="type" id="${item.id}" value="${item.id}">${item.id}. ${item.title}</option>
      </c:forEach>
  </select>
  </p>
    <br/>
    <hr/>
    <h4>Количество: &nbsp; <input type="number" name="quantity" style="width: 4%"/> &nbsp; шт.</h4>
    <h4><input id="viewbutton" type="submit" value="Создать" disabled = "disabled"/>
    <input type="button" value="Отмена" onclick="CancelOrder()"></h4>
    <p style="color: #e32947">${error}</p>
</form>
</body>
</html>
