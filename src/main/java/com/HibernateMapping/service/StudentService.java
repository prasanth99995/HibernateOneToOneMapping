package com.HibernateMapping.service;

import com.HibernateMapping.exceptions.StudentNotFoundException;
import com.HibernateMapping.model.Student;
import com.HibernateMapping.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getStudent(int id) throws StudentNotFoundException {
         Optional<Student> studentOptional =studentRepository.findById(id);
         if(studentOptional.isPresent()){
             return studentOptional.get();
         }else{
             throw new StudentNotFoundException("The Student with given id does not exist");
         }
    }

    public ResponseEntity deleteStudent(int id) throws StudentNotFoundException {
        Optional<Student> studentOptional =studentRepository.findById(id);
        if(studentOptional.isPresent()){
            studentRepository.deleteById(id);
         return ResponseEntity.ok(studentOptional.get());
        }else{
            throw new StudentNotFoundException("The Student with given id does not exist");
        }
    }
}
