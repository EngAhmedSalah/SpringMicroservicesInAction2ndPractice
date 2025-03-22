package com.springmicroservice.project1.userservice.repository;

import com.springmicroservice.project1.userservice.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{

}
