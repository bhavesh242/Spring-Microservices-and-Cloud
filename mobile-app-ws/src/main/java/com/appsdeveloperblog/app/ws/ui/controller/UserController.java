package com.appsdeveloperblog.app.ws.ui.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appsdeveloperblog.app.ws.userservice.UserService;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

	Map<String, UserRest> users;
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUsers(@RequestParam(value = "page") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", required = false) String sort) {
		return "get users was called for page=" + page + " limit=" + limit + " sort=" + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		/*
		 * if(true) { throw new
		 * UserServiceException("A user service exception is thrown"); }
		 */
		if (users == null || !users.containsKey(userId)) {
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		UserRest userRest = userService.createuser(userDetails); 
		return new ResponseEntity<UserRest>(userRest, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserRest updateUser(@PathVariable String userId, @RequestBody UpdateUserDetailsRequestModel userDetails) {
		if (users == null || !users.containsKey(userId)) {
			return null;
		}
		UserRest storedUserDetails = users.get(userId);
		storedUserDetails.setFirstName(userDetails.getFirstName());
		storedUserDetails.setLastName(userDetails.getLastName());
		users.put(userId, storedUserDetails);
		return storedUserDetails;
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		if (users != null && users.containsKey(userId)) {

			users.remove(userId);
		}
		return ResponseEntity.noContent().build();
	}
}
