<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"--%>
<%--         pageEncoding="ISO-8859-1" %>--%>

<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>
<%--    <title>Login Page</title>--%>
<%--    <link href="resources/css/style.css" rel="stylesheet">--%>
<%--    <link href="resources/css/bootstrap.min.css" rel="stylesheet">--%>
<%--    <link href="resources/css/toastr.css" rel="stylesheet">--%>
<%--</head>--%>
<%--<body>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="WEB-INF/common/header.jsp"></jsp:include>
<div id="login-area">
    <form action="login" method="post" class="form-login">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="inputUsername" class="sr-only">User Name:</label>
        <input type="text" id="inputUsername" value="${cookie.username.value}" class="form-control" placeholder="Username" required autofocus
                          name="username"/><br/>
        <label for="inputPassword" class="sr-only">Password: </label>
        <input type="password" id="inputPassword" value="${cookie.password.value}" class="form-control" placeholder="Password" required
                         name="password"/><br/>
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="yes" name="remember" ${cookie.remember.value}> Remember me
            </label>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button><br/>

        <c:if test="${err_msg != null}">
            <div class="alert alert-danger" role="alert">
                <c:out value="${err_msg}"/>
            </div>
        </c:if>
    </form>



</div>
<jsp:include page="WEB-INF/common/footer.jsp"></jsp:include>
<%--</body>--%>
<%--</html>--%>