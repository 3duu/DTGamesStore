<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html ng-app="Home">
  <head>
    <title>DT Games Store</title>
    <%@include file="/WEB-INF/header.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/home.js" ></script>
  </head>
  <body ng-controller="HomeController">
	<%@include file="/WEB-INF/headerMenu.jsp"%>
    {{message}}
    
    <div id="MostSold">
    	<div class="page-header">
		  <h1>Mais Vendidos <small></small></h1>
		</div>
	    <div class="row">
		  {{MostSoldProducts}}  
		  <%@include file="/WEB-INF/views/products/productSmallThumb.jsp" %>
	</div>
   
   	</div>
    <div id="Newest">
    	
    </div>
    
  </body>
</html>