package springbootrestexercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootrestexercise.model.Product;
import springbootrestexercise.repository.ProductRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	//save product
	@PostMapping
	public Product add(Product product) {
		return productRepository.save(product);	
	}
	
	
	//find All product
	@GetMapping
	public List<Product> getAll(){
		return productRepository.findAll();
	}

	
	//find product by id
	@GetMapping("/getbyid/{id}")
    public ResponseEntity<Product> getById(@PathVariable  Long id){
        Product product = productRepository.getById(id);
        return ResponseEntity.ok(product);
	}
	
	
	//Update Product
    @PutMapping("/update/{id}")
  	public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable long id) {
  		product.setId(id);	
  		productRepository.save(product);
  		return ResponseEntity.ok().body(product);
  	}
    
    
    //Delete By Id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable long id){
        Product product =  productRepository.getById(id);
        productRepository.delete(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }	
    
    //find By name
    @GetMapping("/find/{productName}")
    public ResponseEntity<Product> findByName(@PathVariable String name){
    	Product product = productRepository.findByName(name);
    	return ResponseEntity.ok(product);
    }
    
    //Find the Product By name
    @GetMapping("/getbynames/like/{productName}")
    public ResponseEntity<List<Product>> findByNames(@PathVariable  String name){
    	  List<Product> products = productRepository.findByNames(name);
    	  return new ResponseEntity<>( products, HttpStatus.OK);
    }
    
  //Get Products records by page
    @GetMapping("/getbypage")
    public ResponseEntity<List<Product>> getProducts(){
		org.springframework.data.domain.Pageable pageable = PageRequest.of(0, 7);
		List<Product> list = productRepository.findProducts(pageable);
		return new ResponseEntity<List<Product>>(productRepository.findProducts(pageable), HttpStatus.OK);
	}
}