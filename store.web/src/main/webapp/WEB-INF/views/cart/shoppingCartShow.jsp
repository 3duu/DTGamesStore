<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="dtstore">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <%@include file="/WEB-INF/header.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/shopping.js" ></script>
    <title ng-controller="ProductController">DT Games Store - Carrinho de Compras</title>
</head>
<body ng-controller="ShoppingController">
	<%@include file="/WEB-INF/headerMenu.jsp"%>
	
	<div class="panel panel-primary">
      <div class="panel-heading">
        <h3 class="panel-title">Carrinho de Compras</h3>
      </div>
      
      <div class="panel-body">
        
		<ul class="list-group" ng-repeat="product in cartProducts">
		  	<%@include file="/WEB-INF/views/cart/productCartThumb.jsp" %>
		</ul>
   		
      </div>
	      
	    </div>
	
</body>
</html>