package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLayer {

    @Autowired
    Repository repo;

    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }

    public Employee getById(int id){
        return repo.findById(id).orElse(null);
    }

    public Employee create(Employee emp){
        return repo.save(emp);
    }

    public Employee edit(int id,Employee emp){
       return repo.findById(id).map(e ->{
           e.setName(emp.getName());
           e.setSalary(emp.getSalary());
           return repo.save(e);
       }).orElse(null);
    }

    public String deleteById(int id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Employee with id " + id + " deleted";
        }
        return "Employee with id " + id + " not found";
    }

}
