package com.dci.project.springwarehouseproject.model;

import com.dci.project.springwarehouseproject.service.UserService;

public class Admin extends Employee {

  public Admin(){}

  public Admin(String userName, String password){
    super(userName, password, null);

  }

  public boolean authenticate(){
    return UserService.isAdminCredentialCorrect(getName(), getPassword());
  }

  public void greet(){
    System.out.println("Hello, "+ this.name + "!\n" +
        "Welcome to the Admin Panel.\n" +
        "With higher authority comes higher responsibility.");
  }

}
