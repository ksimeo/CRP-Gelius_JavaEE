<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta charset="utf-8" />
    <title>Страница начального входа в систему - CRP-Gelius</title>
    <link rel="stylesheet" type="text/css" href="content/css/style.css" />
    <link rel="shortcut icon" href="img/favicon.ico" />
</head>
<body >
    <form action="login" method="post">
        <table id="enterform">
            <tr>
                <td align="center">
                    <br/>
                    <br/>
                    <h2>Страница начального входа в систему менеджмента производства CRP-Gelius.</h2>
                    <hr/>
                </td>
            </tr>
            <tr>
                <td>
                    <h3>Для начала работы, пожалуйста, авторизируйтесь.</h3>
                </td>
            </tr>
            <tr>
                <td>
                    <h4>Ваш логин: &nbsp; <input class="arealine" type="text" name="login"></h4>
                </td>
            </tr>
            <tr>
                <td>
                    <h4>Ваш пароль: &nbsp; <input class="arealine" type="password" name="password" size="18"></h4>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; Войти &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</button>
                    <%--<input type="submit" value=""/>--%>
                </td>
            </tr>
            <tr>
                <td>
                    <p style="color: #e32947">${error}</p>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
