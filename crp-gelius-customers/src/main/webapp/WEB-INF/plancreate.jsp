<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Создание нового плана - CRP-Gelius</title>
    <link rel="stylesheet" type="text/css" href="../content/css/style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="../img/favicon.ico" />
    <script type="text/javascript" src="../script/gelius.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
</head>
<script>
    $( function() {
        $( "#datepicker1" ).datepicker({ dateFormat: "yy/mm/dd" });
        $( "#datepicker2" ).datepicker({ dateFormat: "yy/mm/dd" });
        $( "#datepicker3" ).datepicker({ dateFormat: "yy/mm/dd" });
    } );
</script>
<body id="shadowed">
<div id="stripeshadowed">
  <div align="right">Планировщик: &nbsp;<b style="color: #f3efbd"><img src="../img/usr2.png"/> ${usrlogin} &nbsp;</b>
    <button onclick="SettingUpAccount()"><img src="../img/wheel.png"/>Настройки аккаунта</button>
    <button onclick="LogOut()"><img src="../img/exit.png"/>Выйти</button> &nbsp;
  </div>
</div>
<br/>
<br/>
<div id="plancreatepalnk">
  <form action="createplan.do?id=${id}" method="post">
      <table>
      <tr>
        <td align="center">
          <h3>Создание плана проекта</h3>
        </td>
      </tr>
      <tr>
        <td>
          <h4>Согл. тех.паспорту:<a href="docdownload.do?id=${cert_id}">№${cert_id}.${title}</a></h4>
        </td>
      </tr>
      <tr>
        <td>
          <h4>Дата создания заявки: &nbsp; <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${orderdate}"/></h4>
        </td>
      </tr>
      <tr>
        <td>
          <h4>Создал: &nbsp; ${name} ${surname} (Менеджер)</h4>
        </td>
      </tr>
      <tr>
          <td>
              <hr/>
              <h4>Формат: &nbsp; <input type="text" name="format" style="width: 20%"/></h4>
          </td>
      </tr>
      <tr>
          <td>
              <h4>Кол-во слоев: &nbsp; <input type="number" name="layers" style="width: 7%"/></h4>
          </td>
      </tr>
      <tr>
          <td>
              <h4>Плотность: &nbsp; <input type="number" name="density" style="width: 7%"/></h4>
          </td>
      </tr>
      <tr>
        <td align="center">
            <h3>Рабочие центры:</h3>
        </td>
      </tr>
      <tr>
        <td>
          <h4>Тайванец: &nbsp; <input type="text" name="taiwandate" id="datepicker1" style="width: 15%"/>
              <input type="radio" name="taiwanshift" value="day">День</input>
              <input type="radio" name="taiwanshift" value="night">Ночь</input>
            </h4>
        </td>
      </tr>
        <tr>
            <td>
                <h4>Бобст: &nbsp; <input type="text" name="bobstdate" id="datepicker2" style="width: 15%"/>
                <input type="radio" name="bobstshift" value="day">День</input>
                <input type="radio" name="bobstshift" value="night">Ночь</input>
            </h4>
            </td>
        </tr>
      <tr>
      <td>
      <h4>Упаковывание: &nbsp; <input type="text" name="packagingdate" id="datepicker3" style="width: 15%"/>
          <input type="radio" name="packagingshift" value="day">День</input>
          <input type="radio" name="packagingshift" value="night">Ночь</input>
      </h4>
      </td>
      </tr>
      <tr>
        <td>
          <hr/>
            <input type="submit" value="Запланировать"/>
            <input type="button" value="Отмена" onclick="location.href='/neworders.do'">
        </td>
      </tr>
      <tr>
        <td>
          <p style="color: #e32947">${error}</p>
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>