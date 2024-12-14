package com.example.vra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.vra.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

//	@Query("Select u.profilePicture.imageId from User where u u.userId=userId")
//	Integer getprofilePictureByUserId(int userId);
}
