package springbootrestexercise.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springbootrestexercise.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	//native Query
	@Query(value = "SELECT * FROM Categories  WHERE name = ?",nativeQuery=true)
	public Category getByName(String name);
	
	//native Query
	@Query(value = "SELECT * FROM Categories  WHERE name like 'Condi%'",nativeQuery=true)
	public List<Category> getByNames(String name);
	
	@Query(value = "SELECT c FROM Category c ORDER BY name")
	public List<Category> sortedByName();
	
	@Query("from Category" )
	List<Category> findCategories(Pageable pageable);
}
