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
    <div id="MostSold" class=interface_class>
    
    	<div class="page-header">
		  <h1>Mais Vendidos <small>Top 10</small></h1>
		</div>
	    <div class="row">
		  <article ng-repeat="product in mostsoldlist">
		  	<%@include file="/WEB-INF/views/products/productSmallThumb.jsp" %>
		  </article>
		</div>
   
   	</div>
    </section>
    <aside class="side_section">
    <div id="MoreCheap" class=interface_class>
    
    	<div class="page-header">
		  <h1>Mais Baratos <small>Top 10</small></h1>
		</div>
	    <div class="row">
		 Informações aqui
		</div>
   
   	</div>
    </aside>
    <%@include file="/WEB-INF/footer.jsp"%>
    </div>
  </body>
</html>