<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<security:authentication property="principal" var="user"/>
<header ng-app="dtstore">
<div align="center" >
<nav class="navbar navbar-inverse navbar-fixed-top navbar-static-top" ng-controller="UserController">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" id="urlBase" ng-model="urlBase" href="${urlBase}">DT GAME STORE</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#" ng-click="whoWeAre($index)">Quem somos <span class="sr-only">(current)</span></a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Consoles <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">PlayStation 4</a></li>
	            <li><a href="#">X-BOX One</a></li>
	            <li><a href="#">Wii U</a></li>
	            <li role="OutrosConsoles" class="divider"></li>
	            <li><a href="#">PlayStation 3</a></li>
	            <li><a href="#">X-BOX 360</a></li>
	            <li><a href="#">Wii</a></li>
	            <li role="Portateis" class="divider"></li>
	             <li><a href="#">PSP</a></li>
	             <li><a href="#">Nintendo DS</a></li>
	             <li><a href="#">PS Vita</a></li>
	             <li><a href="#">Nintendo 3DS</a></li>
	          </ul>
	        </li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Jogos <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">PlayStation 4</a></li>
	            <li><a href="#">X-BOX One</a></li>
	            <li><a href="#">Wii U</a></li>
	            <li role="PC" class="divider"></li>
	            <li><a href="#">PC</a></li>
	            <li role="OutrosConsoles" class="divider"></li>
	            <li><a href="#">PlayStation 3</a></li>
	            <li><a href="#">X-BOX 360</a></li>
	            <li><a href="#">Wii</a></li>
	             <li role="Portateis" class="divider"></li>
	             <li><a href="#">PSP</a></li>
	             <li><a href="#">Nintendo DS</a></li>
	             <li><a href="#">PS Vita</a></li>
	             <li><a href="#">Nintendo 3DS</a></li>
	          </ul>
	        </li>
	      </ul>
	      <form class="navbar-form navbar-left" role="search" method="get" action="${urlBase}/products/search">
	        <div class="form-group">
	          <input type="text" class="form-control" placeholder="Buscar" name="code">
	        </div>
	        <button type="submit" class="btn btn-default">Buscar</button>
	      </form>
	      <ul class="nav navbar-nav navbar-right">
		      <li>
			      <a href="${urlBase}/shopping/cart">Carrinho <span class="badge" id="cartCount" ng-bind="shoppingCart.count">{{cartCount}}</span> </a>
		      </li>
	        <li><a href="${urlBase}/user/account">Meus Pedidos</a></li>
	        <li class="dropdown" id="userDropdown">
	          <a href="${urlBase}/user/account" id="userAccount" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" ng-bind="account"> <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">Dados cadastrais</a></li>
	            <li><a href="#">Meus pedidos</a></li>
	            <li><a href="#">Alterar senha</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="#">Sair</a></li>
	          </ul>
	        </li>
	        <li id="loginLink">
	        
	        <security:authorize access="isAuthenticated()">
			<security:authentication property="principal" var="user"/>
				<div>
					<a href="${urlBase}/user/login">{{account}} Ol� ${user.name} </a>
				</div>
				<div>
					<a href="${urlBase}/user/login">{{account}} Ol� ${user.name} </a>
				</div>
			</security:authorize>
			<a href="${urlBase}/user/login">{{account}} </a>
	         
	        </li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
</nav>
</div>
</header>