package com.HibernateMapping.service;


import com.HibernateMapping.exceptions.LaptopNotFoundException;
import com.HibernateMapping.model.Laptop;
import com.HibernateMapping.repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LaptopService {
private final LaptopRepository laptopRepository;

    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }
    public Laptop saveLaptop(Laptop laptop){
        return laptopRepository.save(laptop);
    }

    public Laptop getLaptop(int id) throws LaptopNotFoundException {
        Optional<Laptop> laptopOptional =laptopRepository.findById(id);
        if(laptopOptional.isPresent()){
            return laptopOptional.get();
        }else{
            throw new LaptopNotFoundException("The Student with given id does not exist");
        }
    }

    public ResponseEntity deleteLaptop(int id) throws  LaptopNotFoundException {
        Optional<Laptop> laptopOptional =laptopRepository.findById(id);
        if(laptopOptional.isPresent()){
            laptopRepository.deleteById(id);
            return ResponseEntity.ok(laptopOptional.get());
        }else{
            throw new LaptopNotFoundException("The Student with given id does not exist");
        }
    }
}
