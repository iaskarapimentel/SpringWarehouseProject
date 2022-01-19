package com.dci.project.springwarehouseproject.service;

import com.dci.project.springwarehouseproject.model.Item;
import com.dci.project.springwarehouseproject.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/*
You'll be delegating the functionalities from your WarehouseRepository class to this class
as to have a separate service layer, and later we follow the practice of writing business
logics in the service layer only.
 */

/*
Create five new methods to
get warehouse, -ok
get all the items, -ok
get items by warehouse, -ok
get categories and - ok
get items by category - ok
in this service class and simply call the appropriate static methods from the WarehouseRepository class.
 */
@Service
public class WarehouseService {

  public Set<Integer> getWarehouse(){
    return WarehouseRepository.getWarehouses();
  }

  public List<Item> getAllItems(){
    return WarehouseRepository.getAllItems();
  }

  public List<Item> getItemsByWarehouse(int warehouse){
    return WarehouseRepository.getItemsByWarehouse(warehouse);
  }

  public Set<String> getCategories(){
    return WarehouseRepository.getCategories();
  }

  public List<Item> getItemsByCategory(String category){
    return WarehouseRepository.getItemsByCategory(category);
  }
}
