package com.dci.project.springwarehouseproject.controller;

import com.dci.project.springwarehouseproject.model.Admin;
import com.dci.project.springwarehouseproject.model.Employee;
import com.dci.project.springwarehouseproject.model.LoginDTO;
import com.dci.project.springwarehouseproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

//		- GET -> /users/getAllEmployees  -> returns List<Employee>
  @GetMapping("user/getAllEmployees")
  public List<Employee> getAllEmployees() {
    return userService.getAllEmployees();
  }

//		- GET -> /users/getAllAdmins    -> returns List<Admin>
  @GetMapping("user/getAllAdmins")
  public List<Admin> getAllAdmins() {
    return userService.getAllAdmins();
  }

  //    - GET -> /users/employee/login -> takes LoginDTO in RequestBody -> returns boolean
  @GetMapping("user/employee/login")
  public boolean loginEmployee(@RequestBody LoginDTO login) {
    return userService.isEmployeeCredentialCorrect(login.getUsername(), login.getPassword());
  }

  //		- GET -> /users/admin/login  -> takes LoginDTO in RequestBody  -> returns boolean
  @GetMapping("user/admin/login")
  public boolean loginAdmin(@RequestBody LoginDTO login) {
    return userService.isAdminCredentialCorrect(login.getUsername(), login.getPassword());
  }
//		(return true if credentials match, otherwise false)
}
