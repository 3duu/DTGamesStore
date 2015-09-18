<article ng-repeat="product in mostsoldlist">
   	<input name="productId" value="{{product.productId}}" hidden="hidden">
	  <div class="col-sm-6 col-md-4">
	    <div class="thumbnail">
	      <img src="data:image/jpg;base64,{{product.productImage}}" alt="..." width="180" height="230">
	      <div class="caption" align="center">
	        <h3>{{product.name}}</h3>
	        <p>{{product.description}}</p>
	        <p><a href="#" class="btn btn-primary" role="button">Comprar </a> <a href="#" class="btn btn-default" role="button">Carrinho+ </a></p>
	      </div>
	    </div>
	  </div>
</article>