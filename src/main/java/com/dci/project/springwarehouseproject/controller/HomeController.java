package com.dci.project.springwarehouseproject.controller;

import com.dci.project.springwarehouseproject.model.Item;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

  RestTemplate restTemplate;

  @GetMapping(value = "index")
  public String goToIndex() {
    return "index";
  }

  @GetMapping("/listAllItems")
  public String getListAllItemsPage(HttpServletRequest request, Model model) {
    restTemplate = new RestTemplate();
    String itemResourceUrl = "http://localhost:" + request.getLocalPort() + "/warehouse/getAllItems";
    String warehouseResourceUrl = "http://localhost:" + request.getLocalPort() + "/warehouse/getWarehouses";

    List<Item> response = restTemplate.getForObject(
        itemResourceUrl,
        List.class
    );

    Set<Integer> warehouseResponse = restTemplate.getForObject(
        warehouseResourceUrl,
        Set.class
    );

    model.addAttribute("warehouses", warehouseResponse);
    model.addAttribute("items", response);
    model.addAttribute("itemCount", response.size());
    return "items_list.html";
  }

  @GetMapping("/listItemsByWarehouse/{warehouseId}")
  public String getListItemByWarehousePage(HttpServletRequest request, Model model, @PathVariable("warehouseId") int warehouseId) {
    restTemplate = new RestTemplate();
    String itemResourceUrl = "http://localhost:" + request.getLocalPort() + "/warehouse/getAllItems/" + warehouseId;

    List<Item> response = restTemplate.getForObject(
        itemResourceUrl,
        List.class
    );

    model.addAttribute("warehouse", warehouseId);
    model.addAttribute("items", response);
    model.addAttribute("itemCount", response.size());
    return "items_list_by_warehouse.html";
  }


  @GetMapping("/browseByCategory")
  public String getListAllCategories(HttpServletRequest request, Model model) {

    restTemplate = new RestTemplate();
    //a rest call to our rest-endpoint "/warehouse/getCategories"
    String categoriesResourceUrl = "http://localhost:" + request.getLocalPort() + "/warehouse/getCategories";

    Set<String> categoriesResponse = restTemplate.getForObject(
        categoriesResourceUrl,
        Set.class
    );

    //add the response to the spring ui model.
    model.addAttribute("categories", categoriesResponse);
    model.addAttribute("categoryCount", categoriesResponse.size());
    return "browse_by_category.html";
  }

  @GetMapping("/itemsListByCategory/{category}")
  public String getItemsByCategory(HttpServletRequest request, Model model, @PathVariable("category") String category) {

    restTemplate = new RestTemplate();
    //a rest call to our rest-endpoint "/warehouse/getCategories"
    String categoriesResourceUrl = "http://localhost:" + request.getLocalPort() + "/warehouse/getItemsByCategory/" + category;

    Set<String> categoriesResponse = restTemplate.getForObject(
        categoriesResourceUrl,
        Set.class
    );

    //add the response to the spring ui model.
    model.addAttribute("categories", categoriesResponse);
    model.addAttribute("categoryCount", categoriesResponse.size());
    return "items_list_by_category.html";
  }

  @GetMapping("/searchItemPage")
  public String getSearchItemPage(HttpServletRequest request, Model model, String keyword){

    restTemplate = new RestTemplate();
    if(keyword != null) {
      String searchItemsResourceUrl = "http://localhost:" + request.getLocalPort() + "/warehouse/searchItem/" + keyword;;
      Set<String> searchItemResponse = restTemplate.getForObject(
          searchItemsResourceUrl,
          Set.class
      );
      model.addAttribute("searchItems", searchItemResponse);
      model.addAttribute("searchItemsCount", searchItemResponse.size());
    }

    return "search_items_page";
  }
}