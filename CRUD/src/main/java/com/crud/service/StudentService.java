package com.crud.service;

import com.crud.entity.Student;
import com.crud.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepository repository;
public Student insertStudent(Student student){
   return this.repository.save(student);
}
public List<Student> retrieveStudent(){
    return this.repository.findAll();
}
@Transactional
public Student deleteStudent(long id) {
    Optional<Student> student = this.repository.findById(id);
    if (student.isPresent()) {
        Student student1=student.get();
        this.repository.delete(student1);
        return student1;
    }
    return null;
}
public Student updateStudent(long id,Student student){
    Student existingStudent = this.repository.findById(id).orElse(null);
    if(existingStudent!=null){
        existingStudent.setEmail(student.getEmail());
        existingStudent.setFullName(student.getFullName());
        existingStudent.setDateOfBirth(student.getDateOfBirth());
        existingStudent.setPhoneNumber(student.getPhoneNumber());
        this.repository.save(existingStudent);
        return existingStudent;
    }
return null;

}
}
