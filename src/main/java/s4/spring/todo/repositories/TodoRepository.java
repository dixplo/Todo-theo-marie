package s4.spring.todo.repositories;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import Spring.todo.ds.models.Todos;




public interface TodoRepository extends JpaRepository<Todos,Integer > {
	
	public List<Todos> findAllOrderBypoidsAsc();
	
}
