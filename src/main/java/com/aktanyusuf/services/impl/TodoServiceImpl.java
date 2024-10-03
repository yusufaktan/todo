package com.aktanyusuf.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aktanyusuf.dto.DtoTodo;
import com.aktanyusuf.dto.DtoTodoIU;
import com.aktanyusuf.model.Todo;
import com.aktanyusuf.repository.TodoRepository;
import com.aktanyusuf.services.ITodoService;

@Service
public class TodoServiceImpl implements ITodoService{

	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public List<DtoTodo> getAllTodos() {
		if (todoRepository.count() == 0) {
			return null;
		}else {
			List<DtoTodo> dtoTodos = new ArrayList<>();
			List<Todo> allTodos = todoRepository.findAll();
			for (Todo todo : allTodos) {
				DtoTodo dtoTodo = new DtoTodo();
				BeanUtils.copyProperties(todo, dtoTodo);
				dtoTodos.add(dtoTodo);
			}
			return dtoTodos;
		}
	}

	@Override
	public DtoTodo getTodoById(UUID id) {
		List<Todo> allTodos = todoRepository.findAll();
		for (Todo todo : allTodos) {
			if (todo.getId().equals(id)) {
				DtoTodo dtoTodo = new DtoTodo();
				BeanUtils.copyProperties(todo, dtoTodo);
				return dtoTodo;
			}
		}
		return null;
	}

	@Override
	public List<DtoTodo> createTodo(DtoTodoIU dtoTodoIU) {
		Todo todo = new Todo();
		BeanUtils.copyProperties(dtoTodoIU, todo);
		todoRepository.save(todo);
		return getAllTodos();
	}

	@Override
	public List<DtoTodo> deleteTodo(UUID id) {
		Todo findTodo = new Todo();
		List<Todo> allTodos = todoRepository.findAll();
		for (Todo todo : allTodos) {
			if (todo.getId().equals(id)) {
				BeanUtils.copyProperties(todo, findTodo);
				todoRepository.delete(findTodo);
				break;
			}
		}
		return getAllTodos();
	}

	@Override
	public List<DtoTodo> updateTodo(DtoTodoIU dtoTodoIU) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DtoTodo> completedTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DtoTodo> uncompletedTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
