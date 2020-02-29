package com.george.restservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {

	
	private static List<Todo> todos = new ArrayList<>();
	private static int idCount = 0;
	
	static {
		todos.add(new Todo(++idCount, "george", "Learn java", new Date(), false));
		todos.add(new Todo(++idCount, "george", "Learn angular", new Date(), false));
		todos.add(new Todo(++idCount, "george", "Get job", new Date(), false));
		todos.add(new Todo(++idCount, "george", "Make $$", new Date(), true));
		todos.add(new Todo(++idCount, "george", "Go Big", new Date(), true));
	}
	
	public List<Todo> getAllTodo(){
		return todos;
	}
	
	public Todo save(Todo todo) {
		
		if(todo.getId()==-1) {
			todo.setId(++idCount);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		
		todos.remove(todo);
		return todo;
	}
	
	public Todo findById(long id) {
		for(Todo t: todos) {
			if(t.getId() == id) {
				return t;
			}
		}
		return null;
	}
	
	public void addTodo(Todo todo) {
		todos.add(todo);
	}
	
}
