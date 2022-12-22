package springbootrestexercise.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import springbootrestexercise.model.Category;
import springbootrestexercise.repository.CategoryRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	//add category
	@PostMapping("/add")
	public Category add(@RequestBody Category category) {
		return categoryRepository.save(category);
	}
	
	
	//find All category
	@GetMapping
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	
	//Find by id
	@GetMapping("/find/{id}")
	public ResponseEntity<Category> categorygetById(Long id){
		Category category = categoryRepository.getById(id);
		return ResponseEntity.ok(category);
	}
	
	
	//update Category
	@PutMapping("/update/{id}")
	public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable long id){
		category.setId(id);
		categoryRepository.save(category);
		return ResponseEntity.ok().body(category);
	}
	
	
	//delete By id
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id){
		Category category = categoryRepository.getById(id);
		categoryRepository.delete(category);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	//find by name
	@GetMapping("/find/{name}")
	public ResponseEntity<Category> getByName(@PathVariable String name) {
		Category category = categoryRepository.getByName(name);
		return ResponseEntity.ok(category);
	}
	
	
	//find by name like substring
	@GetMapping("/find/like/{name}")
	public ResponseEntity<List<Category>> getByNames(@PathVariable String name){
		List<Category> category = categoryRepository.getByNames(name);
		return new ResponseEntity<>(category, HttpStatus.OK);
	}
	
	
	//sort by name
	@GetMapping("/sortbyname")
    public List<Category> SortedByName(@RequestBody Category category) {
        return categoryRepository.sortedByName();
	}
}
