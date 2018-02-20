package todoListAPI.service;

import java.util.List;

import todoListAPI.model.todoList;

public interface todoListInterface {
	todoList checkId(long id);
	
	todoList checkName(String name);
	
	void saveTodoList(todoList todoList);
	
	void updateTodoList(todoList todoList);

	List<todoList> getAllTodoLists(); 
	
	public boolean isTodoListExist(todoList todoList);
}

