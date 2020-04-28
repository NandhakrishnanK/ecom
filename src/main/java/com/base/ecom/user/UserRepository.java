package com.base.ecom.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  List<User> findByUserName(String lastName);

  User findById(long id);
}