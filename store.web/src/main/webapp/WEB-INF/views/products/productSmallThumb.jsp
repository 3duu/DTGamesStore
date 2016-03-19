 <div class="col-sm-6 col-md-4" ng-model="productId">
	 <input name="productId" value="{{product.productId}}" hidden="hidden" ng-model="product">
	   <div class="thumbnail" style="width: 425px;height: 415px;">
	  	  <a href="${urlBase}/products/show?code={{product.productId}}" ng-controller="ProductController">
	     	<img src="data:image/jpg;base64,{{product.productImage}}" alt="{{product.productName}}" width="180" height=130 ng-model="product.productImage">
	     </a>
	     <div class="caption" align="center">
	       <h3 style="width: 262px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">{{product.name}}</h3>
	       <p>{{product.description}}</p>
	       <p>{{product.type}} - {{product.console}}</p>
	       <p>{{product.formatedValue}}</p>
	       <p ng-controller="ProductController">
	       <a href="${urlBase}/products/show?code={{product.productId}}" class="btn btn-primary" role="button"  id="btnComprar">Comprar </a> 
	       <a href=""  class="btn btn-default" ng-click="addToCart($event)" role="button">Carrinho+ </a>
	       </p>
	     </div>
	   </div>
 </div>
