package com.dci.project.springwarehouseproject.service;

import com.dci.project.springwarehouseproject.model.Admin;
import com.dci.project.springwarehouseproject.model.Employee;
import com.dci.project.springwarehouseproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


/*
Create four new methods to
get all the employees, - ok
get all the admins, - ok
if employee credential is correct and  -ok
if admin credential is correct in this service class and -ok
simply call the appropriate static methods from the UserRepository class.
 */

@Service
public class UserService {

  public List<Employee> getAllEmployees(){
    return UserRepository.getAllEmployees();
  }

  public List<Admin> getAllAdmins(){
    return UserRepository.getAllAdmins();
  }

  public boolean isEmployeeCredentialCorrect(String name, String password) {
    return UserRepository.isEmployeeValid(name, password);
  }

  public static boolean isAdminCredentialCorrect(String name, String password){
    return UserRepository.isAdminValid(name, password);
  }

}
