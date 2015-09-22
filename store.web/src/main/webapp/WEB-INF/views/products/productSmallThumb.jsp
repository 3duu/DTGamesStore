<article ng-repeat="product in mostsoldlist">
   	<input name="productId" value="{{product.productId}}" hidden="hidden">
	  <div class="col-sm-6 col-md-4">
	    <div class="thumbnail">
    	  <a href="{{productUrl}}{{product.productId}}" ng-controller="ProductController">
	      	<img src="data:image/jpg;base64,{{product.productImage}}" alt="..." width="180" height=130>
	      </a>
	      <div class="caption" align="center">
	        <h3>{{product.name}}</h3>
	        <p>{{product.description}}</p>
	        <p>
	        <a href="{{productUrl}}{{product.productId}}" ng-controller="ProductController" class="btn btn-primary" role="button"  id="btnComprar">Comprar </a> 
	        <a href="#"  class="btn btn-default" role="button">Carrinho+ </a>
	        </p>
	      </div>
	    </div>
	  </div>
</article>