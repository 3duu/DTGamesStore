<li class="list-group-item" ng-controller="ShoppingController">

	<h4 class="list-group-item-heading">{{product.name}}</h4>
	<p class="list-group-item-text">
		
		<div  align="left">
	  	 <input name="productId" value="{{product.productId}}" hidden="hidden" ng-model="product.productId">
	   	  <a href="{{productUrl}}{{product.productId}}" ng-controller="ProductController">
	      	<img src="data:image/jpg;base64,{{product.productImage}}" alt="..." width=75 height=100 ng-model="product.productImage">
	      </a>
	    </div>
	    <div class="caption" align="left">
	        <p ng-controller="ProductController">
	        <a href=""  class="btn btn-default" ng-click="removeFromCart($event)" role="button">Remover </a>
	        </p>
	    </div>
		
	</p>
</li>