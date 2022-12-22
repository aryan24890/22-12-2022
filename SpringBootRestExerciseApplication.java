package springbootrestexercise;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springbootrestexercise.controller.CategoryController;
import springbootrestexercise.controller.ProductController;
import springbootrestexercise.model.Category;
import springbootrestexercise.model.Product;

@SpringBootApplication
public class SpringBootRestExerciseApplication implements CommandLineRunner{

	@Autowired
	private CategoryController categoryController;
	
	@Autowired
	private ProductController productController;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestExerciseApplication.class, args);
		
	}

	@Override
	public void run(String... args) {
		
		System.out.println("===========================================");
		System.out.println("        Products Records        ");
		System.out.println("===========================================");
		addProducts(createProducts());
		
		System.out.println("===========================================");
		System.out.println("        Products Records         ");
		System.out.println("===========================================");
		addCategories(createCategories());	
	}
	
	
	
	//for category...
	
	private void addCategories(List<Category> categories) {
		for(Category category : categories) {
			categoryController.add(category);
		}
	}
	private List<Category> createCategories(){
		Category category1 = new Category("Beverages","Soft drinks, coffees, teas, beers, and ales",null);
		Category category2 = new Category("Condiments","Sweet and savory sauces, relishes, spreads, and seasonings",null);
		Category category3 = new Category("Confections","Desserts, candies, and sweet breads",null);
		
		List<Category> categories = new ArrayList<>();
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
		return categories;
	}
	
	
	
	//for product...
	private void addProducts(List<Product> products ) {
		for(Product product : products) {
			productController.add(product);
		}
	}
	private List<Product> createProducts(){
		Product product1 = new Product(1L,"Chai",15,29,false,null);
		Product product2 = new Product(2L,"Chang",19,17,true,null);
		Product product3 = new Product(3L,"Aniseed Syrup",50,15,false,null);
	
		
		List<Product> products= new ArrayList<>();
		products.add(product1);
		products.add(product2);
		products.add(product3);
		
		return products;
	}
	
	
}
