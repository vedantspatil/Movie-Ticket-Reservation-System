package com.example.SpringbootApi.Repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.SpringbootApi.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	List<User> findByName(String name);
	//less than greater than functions
	User findByUid(String uid);
//	@Query("from User where uid ='1'")
//	List<User> findRelation(String uid);

}
