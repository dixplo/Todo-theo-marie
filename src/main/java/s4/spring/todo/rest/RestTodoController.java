package s4.spring.todo.rest;

import java.util.List;
import java.util.Optional;

import javax.persistence.OrderBy;
import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Spring.todo.ds.models.Todo;
import s4.spring.todo.repositories.TodoRepository;

@RestController
@RequestMapping("/rest/")
public class RestTodoController {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@GetMapping("d")
	public @ResponseBody List<Todo> read(){
		return todoRepository.findAll();
	}
	
	@GetMapping("{id}")
	public @ResponseBody Todo read(@PathVariable int id){
		Optional<Todo> opt=todoRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}
	
	@PostMapping("create")
	public @ResponseBody Todo create(@RequestBody Todo todoObject) {
		todoRepository.save(todoObject);
		return todoObject;
	}
	
	@PutMapping("update")
	public @ResponseBody Todo update(@RequestBody Todo todoObject) {
		todoRepository.save(todoObject);
		return todoObject;
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable int id) {
		todoRepository.deleteById(id);
		return new ResponseEntity<String>("Suppression réussie!", HttpStatus.OK);
	}

}
