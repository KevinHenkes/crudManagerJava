package fr.imie.supcommerce.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="Product")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6599339846450553277L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;

	private String name;

	private String description;

	private Float price;
	
	@ManyToOne
	private Category category;

	@XmlTransient
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product() {
	}
	
	public Product(String name, String description, Float price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return  name + "<br>Descirption : " + description + "<br>Price : " + price + " euros<br><br>";
	}
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
}
