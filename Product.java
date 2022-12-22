package springbootrestexercise.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private long id;
	
	@Column (name="name", nullable = false, length = 50)
	private String name;
	
	@Column (name="price", nullable = false)
	private double price;
	
	@Column (name="unit_in_stock")
	private int unitInStock;
	
	@Column (name="discontinued")
	private boolean discontinued;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="category_id")
	private Category category;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(long id, String name, double price, int unitInStock, boolean discontinued, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.unitInStock = unitInStock;
		this.discontinued = discontinued;
		this.category = category;
	}

	public Product(String name, double price, int unitInStock, boolean discontinued, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.unitInStock = unitInStock;
		this.discontinued = discontinued;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnitInStock() {
		return unitInStock;
	}

	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
