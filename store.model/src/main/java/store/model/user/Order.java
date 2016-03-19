package store.model.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import store.model.product.Product;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@JoinColumn(name="productId")
	@ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Product> products;
	
	@Column
	private Double itemValue;

}
