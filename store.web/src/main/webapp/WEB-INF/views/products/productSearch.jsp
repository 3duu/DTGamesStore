<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html ng-app="dtstore">
<head>
<meta http-equiv="Content-Type" content="text/html;" charset="UTF-8"/>
    <%@include file="/WEB-INF/header.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/product.js" ></script>
    <title ng-controller="ProductController">DT Games Store - {{searchParam}}</title>
</head>
<body ng-controller="ProductController">
<div>
<%@include file="/WEB-INF/headerMenu.jsp"%>
<section>
	<input type="hidden" value="${word}" id="word" />
	<div class="interface_class">
		
		<div class="page-header">
		  <h1>Resultados da Busca <small>${word}</small></h1>
		</div>
	    <div class="row">
		  <article ng-repeat="product in productsFinded">
		  	<%@include file="/WEB-INF/views/products/productSmallThumb.jsp" %>
		  </article>
		</div>
		
	</div>
</section>
<%@include file="/WEB-INF/footer.jsp"%>
	</div>
</body>