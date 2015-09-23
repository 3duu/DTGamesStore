<input name="productId" value="{{product.productId}}" hidden="hidden" ng-model="product.productId">
	  <div class="col-sm-6 col-md-4">
	    <div class="thumbnail">
    	  <a href="{{productUrl}}{{product.productId}}" ng-controller="ProductController">
	      	<img src="data:image/jpg;base64,{{product.productImage}}" alt="..." width="180" height=130 ng-model="product.productImage">
	      </a>
	      <div class="caption" align="center">
	        <h3>{{product.name}}</h3>
	        <p>{{product.description}}</p>
	        <p ng-controller="ProductController">
	        <a href="{{productUrl}}{{product.productId}}" class="btn btn-primary" role="button"  id="btnComprar">Comprar </a> 
	        <a href="#"  class="btn btn-default" ng-click="addToCart($event)" role="button">Carrinho+ </a>
	        </p>
	      </div>
	    </div>
 </div>
