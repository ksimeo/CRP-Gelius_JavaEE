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
    var orderId;

    $(document).ready(
        function () {
            $("#orderrow").click(clickAction())
            });

    function clickAction() {
        $("#orderrow").click(
                function() {
                    orderId = $("#orderrow").val();
                });
        $("")
    }

    function OnSelectOrder() {
        document.getElementById('createbutton').disabled = 0;
      orderId = $("#area").val();
    }


  function NewPlan() {
      var orderId = $("#area").val();
      document.location = "/newplan.do?order=" + orderId;
  }


  function OnChangeItem() {
      document.getElementById('createbutton').disabled = 0;
      id = document.getElementById('area').options[document.getElementById('area').selectedIndex].id;
  }

  function CreatePlan() {
      document.location = "/createplan.do?id=" + orderId;
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
  <br/>
  <h4>Новые заявки: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    &nbsp; &nbsp; &nbsp;<br/>
      <form id="orders">
    <select id="orderrow" name="orderrow" size="11" onchange="OnChangeItem()">
      <c:forEach items="${orders}" var="item">
        <option name="type"  id="${item.id}" value="${item.id}">#${item.id}(Согл.тех.паспорту №${item.certificate.id})
            - ${item.quantity}шт.)</option>
      </c:forEach>
    </select>
      </form>
  </h4>
  <br/>
  <br/>
    <input type="button" id="createbutton" value="Добавить в план" onclick="CreatePlan()" disabled = "disabled"/> &nbsp;
    <input type="button" value="Отмена" onclick="location.href='/planner.do'"/>
    <p style="color: #e32947">${error}</p>
</div>
</body>
</html>
