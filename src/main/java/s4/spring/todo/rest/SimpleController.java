package s4.spring.todo.rest;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Spring.todo.ds.models.Todo;
import s4.spring.todo.repositories.TodoRepository;

@Controller
@RequestMapping("o/")
public class SimpleController {

	@GetMapping("hello/")
	public String hello(@PathVariable String from) {
		return "hello";
	}

	
	@GetMapping("index")
	public String displayorganization(ModelMap model) {
		List<Todo> todoObject=todoRepository.findAll();
		model.put("index",todoObject);
		return "hello";
	}
	
	@Autowired
	private TodoRepository todoRepository;
	
}
