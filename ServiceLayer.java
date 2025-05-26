package com.example;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Slf4j
@Component
@Service
public class ServiceLayer {

    @Autowired
    Repository repo;

    List<Address> book = new ArrayList<>();

    public List<Address> findAll(){
        return repo.findAll();
    }

    public Object findById(int id){
        if(repo.existsById(id)) {
            return repo.findById(id).orElse(null);
        }
        return "Address with id " + id + " not found";

    }

    public Address create(AddressRequestDTO address){
        log.info("new address saved");
        Address ad = new Address(address.getFullName(), address.getPhoneNo(), address.getAddress());
        return repo.save(ad);
    }

    public Object edittById(int id, AddressRequestDTO address){
        if(repo.existsById(id)) {
            return repo.findById(id).map(ad -> {
                ad.setFullName(address.getFullName());
                ad.setAddress(address.getAddress());
                ad.setPhoneNo(address.getPhoneNo());
                log.info("address updated.");
                return repo.save(ad);
            });
            }
        return "Address with id " + id + " not found";
    }

    public String deleteById(int id){
        if(repo.existsById(id)) {
            repo.deleteById(id);
            log.info("address deleted");
            return "Address with id " + id + " deleted";
        }
        return "Address with id " + id + " not found";
    }
}
