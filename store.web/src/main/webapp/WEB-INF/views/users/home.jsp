<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html ng-app="dtstore">
  <head>
    <%@include file="/WEB-INF/header.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/home.js" ></script>
    <title>DT Games Store</title>
  </head>
  <body ng-controller="HomeController" >
	<%@include file="/WEB-INF/headerMenu.jsp"%>
	<div>
    <section class="body_section">
    
		

    </section>

    </div>
    <%@include file="/WEB-INF/footer.jsp"%>
  </body>
</html>