<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
      <form class="form-signin" style="width: 34%;" action="${urlBase}/user/login" method="post">
        <h2 class="form-signin-heading">Por favor faça o login</h2>
        <label for="inputEmail" class="sr-only">E-mail</label>
        <input type="email" name="userName" id="inputEmail" style="margin: 5px;" class="form-control" placeholder="Endereço de E-mail" required autofocus>
        <label for="inputPassword" class="sr-only">Senha</label>
        <input type="password" name="password" id="inputPassword" style="margin:5px;" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Lembrar-me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 40%;">Entrar</button>
      </form>

    </div> <!-- /container -->
    </section>
    <%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>