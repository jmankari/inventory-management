package com.gfg.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
// Annotation
@RestController
@RequestMapping(value = "/Inventory", produces = "application/json")
public class InventoryController {
 
	@Autowired
	private InventoryRepository repository;
	
    @GetMapping("/getData") 
    public List<Inventory> get()
    {
    	List<Inventory> list = repository.findAll();
 
        return list;
    }
 
    @PostMapping("/add")
    public ResponseEntity<Inventory> post(@RequestBody Inventory userData)
    {
    	Inventory data       = repository.save(userData);
        HttpHeaders headers  = new HttpHeaders();
        return new ResponseEntity<>(data, headers, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id) {
    
    	repository.deleteById(id);
    }
}
