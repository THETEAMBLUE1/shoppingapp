package com.blue.login1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class controller {


	@Autowired
	private UserRepo repo;

	@PostMapping("/signup")
	public User signup(@RequestBody User user) {
		return repo.save(user);
	}
	
	/*@PostMapping("/login")
	public User login(@RequestBody User user) {
		User u = repo.findByEmailId(user.getEmailId());
		if(u!= null && u.getPassword().equals(user.getPassword())) {
			return u;
		}
		else {
			return user;
		}
	}
*/
	@GetMapping("/userid/{uid}")
	public Optional<User> getuser(@PathVariable String uid) {
		return repo.findById(uid);
	}


}
