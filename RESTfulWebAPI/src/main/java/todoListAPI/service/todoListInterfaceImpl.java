package todoListAPI.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import todoListAPI.model.todoList;

@Service("todoListService")
public class todoListInterfaceImpl implements todoListInterface{
		
		private static final AtomicLong counter = new AtomicLong();
		
		private static List<todoList> todoLists;
	
		static{
			todoLists = new ArrayList<todoList>();
		}
		
		
		/*
		 * fake to do list data
		 * 
		private static List<todoList> tempTodoLists(){
			List<todoList> todoLists = new ArrayList<todoList>();
			todoLists.add(new todoList(99, "1","To do 1","19-Feb-2018 08:03:00"));
			todoLists.add(new todoList(98, "2","To do 2","19-Feb-2018 08:03:00"));
			todoLists.add(new todoList(97, "3","To do 3","19-Feb-2018 08:03:00"));
			todoLists.add(new todoList(96, "4","To do 4","19-Feb-2018 08:03:00"));
			return todoLists;
		}
		*/
		


		public List<todoList> getAllTodoLists() {
			return todoLists;
		}
		
		public todoList checkId(long id) {
			for(todoList todoList : todoLists){
				if(todoList.getId() == id){
					return todoList;
				}
			}
			return null;
		}
		
		public todoList checkName(String name) {
			for(todoList todoList : todoLists){
				if(todoList.getTitle().equalsIgnoreCase(name)){
					return todoList;
				}
			}
			return null;
		}
		
		public void saveTodoList(todoList todoList) {
			todoList.setId(counter.incrementAndGet());
			todoLists.add(todoList);
		}

		public void updateTodoList(todoList todoList) {
			int index = todoLists.indexOf(todoList);
			todoLists.set(index, todoList);
		}

		public boolean isTodoListExist(todoList todoList) {
			return checkName(todoList.getTitle())!=null;
		}

}
