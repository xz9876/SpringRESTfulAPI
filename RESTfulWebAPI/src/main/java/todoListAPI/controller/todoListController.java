package todoListAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import todoListAPI.model.todoList;
import todoListAPI.service.todoListInterface;

@RestController
public class todoListController {

	@Autowired
	todoListInterface todoListService; 

	// -------------------Get All todoLists---------------------------------------------

	@RequestMapping(value = "/todoList/", method = RequestMethod.GET)
	public ResponseEntity<List<todoList>> listAlltodoLists() {
		List<todoList> todoLists = todoListService.getAllTodoLists();
		
		// returns http status 404 when no lists
		if (todoLists.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<todoList>>(todoLists, HttpStatus.OK);
	}

	// Get Single todoList

	@RequestMapping(value = "/todoList/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> gettodoList(@PathVariable("id") long id) {
		todoList todoList = todoListService.checkId(id);
		
		// returns http status 404 when no list
		if (todoList == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<todoList>(todoList, HttpStatus.OK);
	}

	// Post a todoList

	@RequestMapping(value = "/todoList/", method = RequestMethod.POST)
	public ResponseEntity<?> createtodoList(@RequestBody todoList todoList, UriComponentsBuilder ucBuilder) {

		// returns http status 400 when failed
		if (todoListService.isTodoListExist(todoList)) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		todoListService.saveTodoList(todoList);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/todoList/{id}").buildAndExpand(todoList.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// Patch a todoList

	@RequestMapping(value = "/todoList/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<?> updatetodoList(@PathVariable("id") long id, @RequestBody todoList todoList) {

		todoList currenttodoList = todoListService.checkId(id);

		//returns http status 404 when non-exist list
		if (currenttodoList == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

		currenttodoList.setTitle(todoList.getTitle());
		currenttodoList.setDescription(todoList.getDescription());
		currenttodoList.setDueDate(todoList.getDueDate());

		todoListService.updateTodoList(currenttodoList);
		return new ResponseEntity<todoList>(currenttodoList, HttpStatus.OK);
	}


}