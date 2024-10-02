package com.aktanyusuf.controller;

import java.util.List;
import java.util.UUID;

import com.aktanyusuf.dto.DtoTodo;
import com.aktanyusuf.dto.DtoTodoIU;

public interface ITodoController {

	public List<DtoTodo> getAllTodos();

	public DtoTodo getTodoById(UUID id);

	public List<DtoTodo> createTodo(DtoTodoIU dtoTodoIU);

	public List<DtoTodo> deleteTodo(UUID id);

	public List<DtoTodo> updateTodo(DtoTodoIU dtoTodoIU);

	public List<DtoTodo> completedTodos();

	public List<DtoTodo> uncompletedTodos();

}
