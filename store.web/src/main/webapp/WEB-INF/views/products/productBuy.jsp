<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="dtstore">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title ng-controller="ProductController">DT Games Store - {{name}}</title>
    <%@include file="/WEB-INF/header.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/product.js" ></script>
</head>
<body ng-controller="ProductController">
	<%@include file="/WEB-INF/headerMenu.jsp"%>
	<div class="panel panel-primary">
      <div class="panel-heading">
        <h3 class="panel-title">{{name}}</h3>
      </div>
      <div class="panel-body">
        
        <div class="row">
        <input type="hidden" value="${productId}" id="productId" />
	        <div>
			  <%@include file="/WEB-INF/views/products/productBigThumb.jsp" %>
	   		</div>
	   		
	   		<div class="col-sm-6 col-md-4">
			    
			    <ul class="list-group">
				  <li class="list-group-item"><h3>{{name}}</h3></li>
				  <li class="list-group-item"><h2>{{priceValue}}</h2></li>
				  <li class="list-group-item">Plataforma:  {{console}}</li>
				  <li class="list-group-item">Descrição: {{description}}</li>
				  <li class="list-group-item">
					   <a href="{{productUrl}}{{product.productId}}" ng-controller="ProductController" class="btn btn-primary" role="button"  id="btnComprar">Comprar </a> 
			           <a href="#"  class="btn btn-default" role="button">Carrinho+ </a>
				  </li>
				</ul>
			
			     
			   
		    </div>
		    
   		</div>
   		
      </div>
	      
	    </div>
	
</body>
</html>