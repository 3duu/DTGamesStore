<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html ng-app="dtstore" ng-controller="ProductController">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <%@include file="/WEB-INF/header.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/product.js" ></script>
    <title>DT Games Store - {{product.name}}</title>
</head>
<body>
<div>
	<%@include file="/WEB-INF/headerMenu.jsp"%>
	<section class="body_section">
	
		<div class="page-header">
		  <h1>{{product.name}} <small>{{product.console}} </small></h1>
		</div>
		
		<div class="panel panel-default"></div>
	
      <div class="panel-body">
        
        <div class="row">
        <input type="hidden" value="${productId}" id="productId" />
	        <div>
			  <%@include file="/WEB-INF/views/products/productBigThumb.jsp" %>
	   		</div>
	   		
	   		<div class="col-sm-6 col-md-4" ng-controller="ProductController">
			    
			    <ul class="list-group">
				  <li class="list-group-item"><h3>{{product.name}}</h3></li>
				  <li class="list-group-item"><h2>{{product.formatedValue}}</h2></li>
				  <li class="list-group-item">Plataforma: <a href="#" target="_blank">{{product.console}}</a> </li>
				  <li class="list-group-item">Descrição: {{product.description}}</li>
				  <li class="list-group-item">
					   <a href="" class="btn btn-primary" role="button"  id="btnComprar">Comprar </a> 
			           <a href=""  class="btn btn-default" ng-click="addToCart(product)" role="button">Carrinho+ </a>
				  </li>
				</ul>
			
			     
		    </div>
		    
   		</div>
   		
      </div>
	      
	    </section>
	    <%@include file="/WEB-INF/footer.jsp"%>
	</div>
</body>
</html>