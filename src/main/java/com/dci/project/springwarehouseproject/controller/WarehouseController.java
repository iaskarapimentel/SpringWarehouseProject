package com.dci.project.springwarehouseproject.controller;

import com.dci.project.springwarehouseproject.model.Item;
import com.dci.project.springwarehouseproject.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class WarehouseController {

	private final WarehouseService warehouseService;

	@Autowired
	public WarehouseController (WarehouseService warehouseService){
		this.warehouseService = warehouseService;
	}

//    - GET -> /warehouse/getWarehouses  -> returns Set<Integer>
	@GetMapping("warehouse/getWarehouses")
	public Set<Integer> getWarehouses(){
		return warehouseService.getWarehouse();
	}

//		- GET -> /warehouse/getAllItems    -> returns List<Item>
	@GetMapping("warehouse/getAllItems")
	public List<Item> getAllItems(){
		return warehouseService.getAllItems();
	}

//		- GET -> /warehouse/getAllItems/{warehouseId} -> returns List<Item>
	@GetMapping("warehouse/getAllItems/{warehouseId}")
	public List<Item> getAllItems(@PathVariable String warehouseId){
		return warehouseService.getItemsByWarehouse(Integer.parseInt(warehouseId));
	}

//		- GET -> /warehouse/getCategories  -> returns Set<String>
	@GetMapping("warehouse/getCategories")
	public Set<String> getCategories(){
		return warehouseService.getCategories();
	}

//		- GET -> /warehouse/getItemsByCategory/{category}  -> returns List<Item>
	@GetMapping("warehouse/getItemsByCategory/{category}")
	public List<Item> getItemsByCategory(@PathVariable String category){
		return warehouseService.getItemsByCategory(category);
	}
}
