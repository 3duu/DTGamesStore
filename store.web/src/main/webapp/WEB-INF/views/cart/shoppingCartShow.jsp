<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html ng-app="dtstore">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <%@include file="/WEB-INF/header.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/shopping.js" ></script>
    <title ng-controller="ProductController">DT Games Store - Carrinho de Compras</title>
</head>
<body ng-controller="ShoppingController">
	<%@include file="/WEB-INF/headerMenu.jsp"%>
	<!-- 	<div ng-include="'WEB-INF/headerMenu.jsp'"></div> -->
	
	<div class="panel panel-primary">
      <div class="panel-heading">
        <h3 class="panel-title">Carrinho de Compras</h3>
      </div>
      
      <div class="panel-body">
		
		<div class="panel panel-default">
		  <!-- Default panel contents -->
		  <div class="panel-heading">Produtos no Carrinho</div>
		  <div class="panel-body">
		    <p>...</p>
		  </div>
		
		  <!-- Table -->
		  <table class="table" ng-controller="ShoppingController">
		  	<tr> 
		    	<th width="200"> <center> Produto(s) no carrinho </center> </th>
		    	<th width="200">  </th>
		    	<th width="200"> <center> Qtde. de produtos </center> </th>
		    	<th width="200"> <center> Valor Unitário </center> </th>
		    	<th width="200"> <center> Valor Total </center> </th>
		    </tr>
		    <tr ng-repeat="product in cartProducts">
		    	<td>
		    		<center>
			    		<a href="{{productUrl}}{{product.productId}}" style="line-height:100px" ng-controller="ProductController">
			      			<img src="data:image/jpg;base64,{{product.productImage}}" alt="..." width="75" height="100" ng-model="product.productImage">
			      		</a>
		      		</center>
		    	</td>
		    	<td>
		    		<h4 class="list-group-item-heading" style="line-height:100px"> {{product.name}}</h4>	    	
		    	</td>
		    	<td ng-controller="ShoppingController">
		    	<center>
		    		<div style="line-height:100px">
			    		<button class="btn btn-primary"  ng-click="newCartItem($event)">
						  <i class="icon-user icon-white"></i>+
						</button>
			    			<input type="text" value="{{product.productCount}}" style="width: 30px;height: 34px" maxlength="3"/>
		    			<button class="btn btn-primary" ng-click="removeCartItem($event)">
						  <i class="icon-user icon-white"></i>-
						</button>
					</div>
				</center>
		    	</td>	
		    	<td>
		    		<center><h4 class="list-group-item-heading" style="line-height:100px">{{product.priceValue}}</h4></center>
		    	</td>
		    	<td>
		    		<center><h4 class="list-group-item-heading" style="line-height:100px">{{product.productTotal}}</h4></center>
		    	</td>	    	
		    </tr>
		  </table>	
		</div>
   		
      </div>
	      
	    </div>
	
</body>
</html>