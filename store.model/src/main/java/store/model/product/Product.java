package store.model.product;

import java.text.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private Integer stockQuant;
	
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
	
	@Column
	private String tags;
	
	@Column
	private int sells;

	
	@Transient
	private String formatedValue;
	
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public Integer getStockQuant() {
		return stockQuant;
	}
	
	public void setStockQuant(Integer stockQuant) {
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
		this.formatedValue = NumberFormat.getCurrencyInstance().format(priceValue);
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
	

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public int getSells() {
		return sells;
	}

	public void setSells(int sells) {
		this.sells = sells;
	}
	

	//rules
	public String getFormatedValue() {
		this.formatedValue = NumberFormat.getCurrencyInstance().format(this.priceValue);
		return formatedValue;
	}

	public String getProductDescription(){
		this.setPriceValue(this.priceValue);
		if(this.type != null && this.console != null && this.name != null){
			
			return this.type.name() + " " 
					+ this.name + " - " 
					+ this.console.name() 
					+ " \n " + NumberFormat.getCurrencyInstance().format(this.getPriceValue());
			
		}
		
		return "";
	}


	

}
