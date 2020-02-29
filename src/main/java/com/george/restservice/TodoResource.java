package com.george.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:4200")
public class TodoResource {
	
	@Autowired
	private TodoHardcodedService hardcodedService;
	
	@GetMapping("{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return hardcodedService.getAllTodo();	
	}
	
	@GetMapping("{username}/todos/{id}")
	public Todo getAllTodos(@PathVariable String username, @PathVariable long id){
		return hardcodedService.findById(id);
	}
	
	@GetMapping("/hello")
	public String getHello() {
		return "Hello";
	}
	
	@RequestMapping(value = "{username}/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
		Todo todo = hardcodedService.deleteById(id);
		
		if(todo!=null) {
			System.out.println("succes");
			return ResponseEntity.noContent().build();
			
		}
		System.out.println("fail");
		return ResponseEntity.notFound().build();
	}
	
	//update - PUT
	
	  @RequestMapping(value = "{username}/todos/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<Todo>
	  updateTodo(@PathVariable String username, 
			  	@PathVariable long id, @RequestBody Todo todo){ 
		  
		  Todo todoUpdated = hardcodedService.save(todo); 
		  return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK); }
	 
	
	@RequestMapping(value= "{username}/todos/add", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addTodo(@RequestBody Todo todo){
		hardcodedService.addTodo(todo);
	}
	
	@RequestMapping(value="{username}/todos/update", method = RequestMethod.PUT)
	public void updateTodo(@RequestBody Todo todo) {
		hardcodedService.save(todo);
	}
}
