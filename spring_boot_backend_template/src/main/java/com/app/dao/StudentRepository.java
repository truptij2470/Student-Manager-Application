package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.pojos.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // You can add custom query methods here if needed
}
