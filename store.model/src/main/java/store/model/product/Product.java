package store.model.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private int productId;
	private int stockQuant;
	private String name;
	private Double priceValue;
	private String description;
	private ProductType type;
	private TargetConsole console;
	
	
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
}
