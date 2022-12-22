package springbootrestexercise.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import springbootrestexercise.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	//native Query
	@Query(value = "SELECT * FROM products  WHERE Name like 'Anis%'",nativeQuery=true)
	List<Product> findByNames(String name);
	
	//native Query
	@Query(value = "SELECT * FROM products  WHERE name = ?",nativeQuery=true)
	public Product findByName(String name);
	
	@Query(value = "SELECT p FROM Product p ORDER BY price")
	public List<Product> SortedByPrice();		  
	   
	@Query(value = "SELECT p FROM Product p ORDER BY name")
	public List<Product> SortedByName();
	   
	@Query("from Product" )
	List<Product> findProducts(Pageable pageable);
	

}
