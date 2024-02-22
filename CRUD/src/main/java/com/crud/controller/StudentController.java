package com.crud.controller;
import com.crud.entity.Student;
import com.crud.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StudentController {
    private  final StudentService service;

    @PostMapping
    private ResponseEntity<Student> createStudent( @RequestBody Student student) {
       Student student1=this.service.insertStudent(student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);

    }
 @GetMapping
    private ResponseEntity<List<Student>> retriveStudent(){
       return new ResponseEntity<>( this.service.retrieveStudent(),HttpStatus.OK);
 }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
       Student student= this.service.deleteStudent(id);
      return (student!=null)?  new ResponseEntity<>("Student deleted of id: " + id,HttpStatus.FOUND):new ResponseEntity<>("Student not found with id: " + id,HttpStatus.NOT_FOUND) ;

    }

    @PostMapping ("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetail) {
            Student student= this.service.updateStudent(id,studentDetail);
          return (student!=null)? new ResponseEntity<>(student,HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
