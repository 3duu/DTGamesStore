<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html ng-app="dtstore">
<head>
<meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <%@include file="/WEB-INF/header.jsp" %>
    <title>DT Games Store - Meus Pedidos</title>
</head>
<body ng-controller="ShoppingController">
	<%@include file="/WEB-INF/headerMenu.jsp"%>
      
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
		    	<th width="200" align="center">  Produto(s) no carrinho  </th>
		    	<th width="200" align="center">  </th>
		    	<th width="200" align="center">  Qtde. de produtos  </th>
		    	<th width="200" align="center">  Valor Unitário  </th>
		    	<th width="200" align="center">  Valor Total  </th>
		    </tr>
		    <tr ng-repeat="product in cartProducts">
		    	<td align="center">
			    		<a href="${urlBase}/products/show?code={{product.productId}}" style="line-height:100px" ng-controller="ProductController">
			      			<img src="data:image/jpg;base64,{{product.productImage}}" alt="..." width="75" height="100" ng-model="product.productImage">
			      		</a>
		    	</td>
		    	<td align="center">
		    		<h4 class="list-group-item-heading" style="line-height:100px">{{product.name}}</h4>	    	
		    	</td>
		    	<td align="center">
		    	
		    		<div style="line-height:100px">
			    		<button class="btn btn-primary"  ng-click="newCartItem(product)">
						  <i class="icon-user icon-white"></i>+
						</button>
			    			<label style="width: 30px;height: 34px" ng-bind="product.productCount"></label>
		    			<button class="btn btn-primary" ng-click="removeCartItem(product)">
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
</body>
</html>