package com.jumbe.employers1;

import com.jumbe.employers1.Repo.ERepo;
import models.employers;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static models.employers.deleteemployers;

@Econtrollers
public class Econtroller {
    private ERepo eRepo;

    public Econtroller(ERepo eRepo) {
        this.eRepo = eRepo;
    }

    @GetMapping(value="/employers")
    public List<employers> getEmployers(){
        return eRepo.findAll();
    }
    @PostMapping(value = "/save")
    public String saveemployers( employers employers){
        eRepo.save(employers);
        return "Saved";
    }
    @PutMapping(value = "update/{id}")
    public String updateemployers(@PathVariable String id, @RequestBody employers employers) {
        employers updatedemployers = eRepo.findById(id).get();
        updatedemployers.setFirstName(employers.getFirstName());
        updatedemployers.setSecondName(employers.getSecondName());
        updatedemployers.setAge(employers.getAge());
        updatedemployers.setOccupation(employers.getOccupation());
        updatedemployers.save(updatedemployers);
        return ("employers updated");


    }
    @DeleteMapping(value =("/delete/{id}"))

    public String deleteemployers(@PathVariable String id){
        deleteemployers = java.util.Optional.of(eRepo.findById(id).get());
        eRepo.delete(deleteemployers);
        return "deleteemployer with id"+id;

    }

    }



