
package com.adilet.studentapi.controller;

import com.adilet.studentapi.model.Student;
import com.adilet.studentapi.repository.StudentRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Student> create(
            @RequestBody Student student) {

        student.setId(null);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(repository.save(student));
    }

    @GetMapping
    public List<Student> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found"
                ));
    }

    @PutMapping("/{id}")
    public Student update(
            @PathVariable Long id,
            @RequestBody Student updated) {

        Student student = getById(id);

        student.setName(updated.getName());
        student.setEmail(updated.getEmail());

        return repository.save(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Student student = getById(id);
        repository.delete(student);
        return ResponseEntity.noContent().build();
    }
}
