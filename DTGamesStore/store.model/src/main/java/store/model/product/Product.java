package store.model.product;

import java.text.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Transient
	private String url;
	
	public Product(){
		
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getStockQuant() {
		return stockQuant;
	}
	
	public void setStockQuant(int stockQuant) {
		this.stockQuant = stockQuant;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPriceValue() {
		return priceValue;
	}
	
	public void setPriceValue(Double priceValue) {
		this.priceValue = priceValue;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
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
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	//rules
	
	public String getProductDescription(){
		return this.getType().name() + " " 
			+ this.getName() + " - " 
			+ this.getConsole().name() 
			+ " \n " + NumberFormat.getCurrencyInstance().format(this.getPriceValue());
	}

	

}
