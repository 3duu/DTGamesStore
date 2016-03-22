<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <%@include file="/WEB-INF/header.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/product.js" ></script>
    <title>DT Games Store - Fazer Login</title>
</head>
<body>
<%@include file="/WEB-INF/headerMenu.jsp"%>
<section class="body_section">
	<div class="container" align="center">
      <form:form cssClass="form-signin" style="width: 34%;" servletRelativeAction="${urlBase}/user/login" method="post">
        <h2 class="form-signin-heading">Por favor faça o login</h2>
       <security:csrfInput/>
        <label for="inputEmail" class="sr-only">E-mail</label>
        <input type="email" name="username" id="inputEmail" style="margin: 5px;" class="form-control" placeholder="Endereço de E-mail" required autofocus>
        <label for="inputPassword" class="sr-only">Senha</label>
        <input type="password" name="password" id="inputPassword" style="margin:5px;" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Lembrar-me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 40%;">Entrar</button>
      </form:form>
    </div> <!-- /container -->
    </section>
    <%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>