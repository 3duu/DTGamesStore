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
        
<!-- 		<ul class="list-group" ng-repeat="product in cartProducts"> -->
<%-- 		  	<%@include file="/WEB-INF/views/cart/productCartThumb.jsp" %> --%>
<!-- 		</ul> -->
		
		<div class="panel panel-default">
		  <!-- Default panel contents -->
		  <div class="panel-heading">Produtos no Carrinho</div>
		  <div class="panel-body">
		    <p>...</p>
		  </div>
		
		  <!-- Table -->
		  <table class="table" ng-controller="ShoppingController">
		    <tr ng-repeat="product in cartProducts">
		    	<td> 
		    		<h4 class="list-group-item-heading">{{product.name}}</h4> 	    		
		    		<a href="{{productUrl}}{{product.productId}}" ng-controller="ProductController">
		      			<img src="data:image/jpg;base64,{{product.productImage}}" alt="..." width=75 height=100 ng-model="product.productImage">
		      		</a>
		    	</td>
		    	
		    </tr>
		  </table>
		</div>
   		
      </div>
	      
	    </div>
	
</body>
</html>