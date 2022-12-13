package com.example.SpringbootApi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringbootApi.Repo.RestRepo;
import com.example.SpringbootApi.Repo.UserRepository;

@RestController
public class MyController {

	@Autowired
	UserRepository repo;

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		System.out.print("insinde");
		return mv;
	}

	@GetMapping("/adduser")
	public ModelAndView adduser(User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		if (user == null) {
			mv.addObject("Failed");
		} else {
			mv.addObject("Successfull");
			repo.save(user);
		}
		return mv;
	}
	@GetMapping("/finduser")
	public ModelAndView finduser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("finduser");
		return mv;
	}

	@GetMapping("/displayuser")
	public ModelAndView displayuser(@RequestParam String uid) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("finduserbyid");
		User user = repo.findById(uid).orElse(new User());
		mv.addObject(user);
		return mv;
	}

	@GetMapping("/users")
	public List<User> listall() {
		return repo.findAll();
	}

	@GetMapping("/user/{uid}")
	public Optional<User> listall(@PathVariable("uid") String uid) {
		return repo.findById(uid);
	}
	@PostMapping("/assignuser")
	public User assignuser(@RequestBody User user) {
		repo.save(user);
		return user;
	}
	@DeleteMapping("user/{uid}")
	public String deleteuser(@PathVariable("uid") String uid) {
		User user = repo.findByUid(uid);
		if (user == null) {
			return "User Not found";
		} else {
			repo.delete(user);
			return "Deleted Successfully";
		}
	}

	@PostMapping("/display")
	public List display(@RequestBody String query) {
		return RestRepo.Query(query);
	}

}
