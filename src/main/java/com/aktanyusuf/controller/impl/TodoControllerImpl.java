package com.aktanyusuf.controller.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aktanyusuf.controller.ITodoController;
import com.aktanyusuf.dto.DtoTodo;
import com.aktanyusuf.dto.DtoTodoIU;
import com.aktanyusuf.services.impl.TodoServiceImpl;

@RestController
@RequestMapping("/rest/api/todo")
public class TodoControllerImpl implements ITodoController{

	@Autowired
	private TodoServiceImpl todoServiceImpl;
	
	@Override
	@GetMapping
	public List<DtoTodo> getAllTodos() {
		return todoServiceImpl.getAllTodos();
	}

	@Override
	@GetMapping(path = "/{id}")
	public DtoTodo getTodoById(@PathVariable(name = "id", required = true) UUID id) {
		return todoServiceImpl.getTodoById(id);
	}

	@Override
	@PostMapping
	public List<DtoTodo> createTodo(@RequestBody DtoTodoIU dtoTodoIU) {
		return todoServiceImpl.createTodo(dtoTodoIU);
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public List<DtoTodo> deleteTodo(@PathVariable(name = "id", required = true) UUID id) {
		return todoServiceImpl.deleteTodo(id);
	}

	@Override
	public List<DtoTodo> updateTodo(DtoTodoIU dtoTodoIU) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping(path = "/completed")
	public List<DtoTodo> completedTodos() {
		return todoServiceImpl.completedTodos();
	}

	@Override
	@GetMapping(path = "/uncompleted")
	public List<DtoTodo> uncompletedTodos() {
		return todoServiceImpl.uncompletedTodos();
	}

}
