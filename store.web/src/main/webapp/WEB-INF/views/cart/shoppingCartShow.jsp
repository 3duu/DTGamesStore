<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html ng-app="dtstore">
<head>
<meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <%@include file="/WEB-INF/header.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/shopping.js" ></script>
    <title ng-controller="ProductController">DT Games Store - Carrinho de Compras</title>
</head>
<body ng-controller="ShoppingController">
<div>
	<%@include file="/WEB-INF/headerMenu.jsp"%>
	<!-- 	<div ng-include="'WEB-INF/headerMenu.jsp'"></div> -->
	
	
<!--       <div class="panel-heading"> -->
<!--         <h3 class="panel-title">Carrinho de Compras</h3> -->
<!--       </div> -->
      
      <section class="body_section">
      <div class="interface_class">
		
		<div class="page-header">
		  <h1>Carrinho de Compras <small>{{cart.total}} produtos</small></h1>
		</div>
		
		<div class="panel panel-default">
		  <!-- Default panel contents -->
<!-- 		  <div class="panel-heading">Produtos no Carrinho</div> -->
<!-- 		  <div class="panel-body"> -->
<!-- 		    <p>...</p> -->
<!-- 		  </div> -->
		
		  <!-- Table -->
		  <table class="table" ng-controller="ShoppingController">
		  	<tr align="center">
		    	<th width="200">  Produto(s) no carrinho  </th>
		    	<th width="200">  </th>
		    	<th width="200">  Qtde. de produtos  </th>
		    	<th width="200">  Valor Unitário  </th>
		    	<th width="200">  Valor Total  </th>
		    </tr>
		    <tr ng-repeat="product in cartProducts">
		    	<td align="center">
			    		<a href="{{productUrl}}{{product.productId}}" style="line-height:100px" ng-controller="ProductController">
			      			<img src="data:image/jpg;base64,{{product.productImage}}" alt="..." width="75" height="100" ng-model="product.productImage">
			      		</a>
		    	</td>
		    	<td align="center">
		    		<h4 class="list-group-item-heading" style="line-height:100px">{{product.name}}</h4>	    	
		    	</td>
		    	<td ng-controller="ShoppingController" align="center">
		    	
		    		<div style="line-height:100px">
			    		<button class="btn btn-primary"  ng-click="newCartItem($event)">
						  <i class="icon-user icon-white"></i>+
						</button>
			    			<input type="text" value="{{product.productCount}}" style="width: 30px;height: 34px" maxlength="3"/>
		    			<button class="btn btn-primary" ng-click="removeCartItem($event)">
						  <i class="icon-user icon-white"></i>-
						</button>
					</div>
				
		    	</td>	
		    	<td align="center">
		    		<h4 class="list-group-item-heading" style="line-height:100px">{{product.formatedValue}}</h4>
		    	</td>
		    	<td align="center">
		    		<h4 class="list-group-item-heading" style="line-height:100px">{{product.productTotal}}</h4>
		    	</td>	    	
		    </tr>
		  </table>	
   		
      </div>
	      <a href="#" ng-controller="ProductController" class="btn btn-primary" role="button"  id="btnComprar">Confirmar</a>
	  </div>
	  </section>
	  <%@include file="/WEB-INF/footer.jsp"%>
	</div>
</body>
</html>