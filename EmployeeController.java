package com.example;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employeepayrollservice")
public class EmployeeController {
    @Autowired
    ServiceLayer service;

    @GetMapping
    public List<Employee> getAll(){
        return service.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public Object getWithId(@PathVariable int id){
        Employee emp = service.getById(id);
        if(emp!=null) return emp;
        return "Employee with id " + id + " not found";
    }

    @PostMapping("/create")
    public Employee add(@Valid @RequestBody Employee emp){
        return service.create(emp);
    }

    @PutMapping("/update/{id}")
    public Object update(@PathVariable int id,@Valid @RequestBody Employee emp){
        Employee employee = service.edit(id,emp);
        if(employee!=null) return employee;
        return "Employee with id " + id + " not found";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return service.deleteById(id);
    }

}
