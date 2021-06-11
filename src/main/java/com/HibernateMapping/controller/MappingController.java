package com.HibernateMapping.controller;


import com.HibernateMapping.exceptions.LaptopNotFoundException;
import com.HibernateMapping.exceptions.StudentNotFoundException;
import com.HibernateMapping.model.Laptop;
import com.HibernateMapping.model.Student;
import com.HibernateMapping.repository.LaptopRepository;
import com.HibernateMapping.repository.StudentRepository;
import com.HibernateMapping.service.LaptopService;
import com.HibernateMapping.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class MappingController {
    private final StudentService studentService;
    private final LaptopService laptopService;
    private final StudentRepository studentRepository;
    private final LaptopRepository laptopRepository;

    public MappingController(StudentService studentService, LaptopService laptopService, StudentRepository studentRepository, LaptopRepository laptopRepository) {
        this.studentService = studentService;
        this.laptopService = laptopService;
        this.studentRepository = studentRepository;
        this.laptopRepository = laptopRepository;
    }

    @PostMapping("/students")
    public ResponseEntity<Object> newStudent(@RequestBody Student student) {
        Student result = studentService.saveStudent(student);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(studentRepository.findById(student.getSid())).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/students/{id}")
    public Student getLaptop(@PathVariable("id") int id) throws StudentNotFoundException {
        return studentService.getStudent(id);

    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity deleteLaptop(@PathVariable("id") int id) throws StudentNotFoundException {
        return studentService.deleteStudent(id);
    }

    @PostMapping("/laptops")
    public ResponseEntity<Object> newLaptop(@RequestBody Laptop laptop) {
        Laptop result = laptopService.saveLaptop(laptop);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(studentRepository.findById(laptop.getLid())).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/laptops/{id}")
    public Laptop getStudent(@PathVariable("id") int id) throws LaptopNotFoundException {
        return laptopService.getLaptop(id);

    }

    @DeleteMapping("/laptops/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int id) throws LaptopNotFoundException {
        return laptopService.deleteLaptop(id);
    }

}
