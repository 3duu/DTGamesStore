package store.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private int productId;
	private int stockQuant;
	
	@Column(length=50, columnDefinition="varchar(50)")
	private String name;
	private Double priceValue;
	
	@Column(length=255, columnDefinition="varchar(255)")
	private String description;
	
	@Column(columnDefinition="tinyint")
	private ProductType type;
	
	@Column(columnDefinition="tinyint")
	private TargetConsole console;
	
	@Lob
	@Column(columnDefinition="varbinary(MAX)")
	private byte[] productImage;
	
	public int getProductId() {
		return productId;
	}
	public int getStockQuant() {
		return stockQuant;
	}
	public String getName() {
		return name;
	}
	public Double getPriceValue() {
		return priceValue;
	}
	public String getDescription() {
		return description;
	}
	public ProductType getType() {
		return type;
	}
	public void setType(ProductType type) {
		this.type = type;
	}
	public TargetConsole getConsole() {
		return console;
	}
	public void setConsole(TargetConsole console) {
		this.console = console;
	}
	public byte[] getProductImage() {
		return productImage;
	}
	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}
}
