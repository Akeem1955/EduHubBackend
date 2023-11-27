package com.akeem.eduhub.db.helper;

import com.akeem.eduhub.db.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,String> {
}
