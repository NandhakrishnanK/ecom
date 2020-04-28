package com.base.ecom.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String userName;
  private String password;

  protected User() {}

  public User(long id, String userName, String password) {
	this.id = id;
	this.userName = userName;
    this.password = password;
  }

  @Override
  public String toString() {
    return String.format(
        "Customer[id=%d, userName='%s', password='%s']",
        id, userName, password);
  }

  public Long getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }
}