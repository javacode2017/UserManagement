package com.example.user.UserManagementApplication;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/student")
public class UserController {
	@Autowired
	UserRepository UserRepository;
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		UserRepository.save(user);
		return user;
	}
	
	@GetMapping("/loadUser")
	public List<User> getData(){
		List<User> list = UserRepository.findAll();
		return list;
		
	}
	@GetMapping("/load/{uid}")
	public Optional<User>  getUserById(@PathVariable(value = "uid") String  uid) {
		Optional<User> user = UserRepository.findById(uid);
		return user;
		
	}
	@PutMapping("/update/{uid}")
	public ResponseEntity<User> updateStudent(@PathVariable("uid") String uid,@RequestBody User user) throws ResourceNotFoundException{
		User userUpdate = UserRepository.findById(uid).orElseThrow(()->new  ResourceNotFoundException("Resource not availble with "+uid));
		
		userUpdate.setUname(user.getUname());
		userUpdate.setUage(user.getUage());
		
		User user2 = UserRepository.save(userUpdate);
		return ResponseEntity.ok(user2);
	}
	
	@DeleteMapping("/delete/{uid}")
	public void deleteUser(@PathVariable("uid") String uid) {
		UserRepository.deleteById(uid);
		
	}
	
}
