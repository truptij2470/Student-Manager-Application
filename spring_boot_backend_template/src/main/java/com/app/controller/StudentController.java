package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.StudentRepository;
import com.app.pojos.Student;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/{id}/profilePhoto")
    public ResponseEntity<?> addProfilePhoto(@PathVariable Long id, @RequestBody byte[] profilePhoto) {
        com.app.pojos.Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        student.setProfilePhoto(profilePhoto);
        studentRepository.save(student);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/profilePhoto")
    public ResponseEntity<?> removeProfilePhoto(@PathVariable Long id) {
        com.app.pojos.Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        student.setProfilePhoto(null);
        studentRepository.save(student);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/resume")
    public ResponseEntity<?> addResume(@PathVariable Long id, @RequestBody byte[] resume) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        student.setResume(resume);
        studentRepository.save(student);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/resume")
    public ResponseEntity<?> removeResume(@PathVariable Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        student.setResume(null);
        studentRepository.save(student);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/firstName")
    public ResponseEntity<String> getFirstName(@PathVariable Long id) {
        com.app.pojos.Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student.getFirstName());
    }

    @GetMapping("/{id}/lastName")
    public ResponseEntity<String> getLastName(@PathVariable Long id) {
        com.app.pojos.Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student.getLastName());
    }

    @GetMapping("/{id}/email")
    public ResponseEntity<String> getEmail(@PathVariable Long id) {
        com.app.pojos.Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student.getEmail());
    }


}
