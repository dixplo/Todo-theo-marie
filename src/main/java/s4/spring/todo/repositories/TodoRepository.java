package s4.spring.todo.repositories;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import Spring.todo.ds.models.Todo;




public interface TodoRepository extends JpaRepository<Todo,Integer > {
	
	public List<Todo> findAllOrderBypoidsAsc();
	
}
