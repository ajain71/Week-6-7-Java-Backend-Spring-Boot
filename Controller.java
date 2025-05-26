package com.example;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/addressBook")
public class Controller {

    @Autowired
    ServiceLayer service;

    @GetMapping("/getAll")
    public List<Address> getAll(){
        return service.findAll();
    }

    @GetMapping("/get/{id}")
    public Object getById(@PathVariable int id){
        return service.findById(id);
    }

    @PostMapping("/add")

    public Address post(@Valid @RequestBody AddressRequestDTO address){
        return service.create(address);
    }

    @PutMapping("/edit/{id}")
    public Object put(@PathVariable int id, @Valid @RequestBody AddressRequestDTO address){
        return service.edittById(id,address);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return service.deleteById(id);
    }
}
