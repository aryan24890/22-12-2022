package springbootrestexercise.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="categories")
public class Category {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="name", nullable=false, length = 50) 
	private String name;
	
	@Column(name="description", length=100)
	private String description;
	
	@OneToMany(fetch=FetchType.EAGER ,mappedBy ="category",cascade= CascadeType.ALL)
	private List<Product> product;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Category(long id, String name, String description, List<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.product = product;
	}
	

	public Category(String name, String description, List<Product> product) {
		super();
		this.name = name;
		this.description = description;
		this.product = product;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
