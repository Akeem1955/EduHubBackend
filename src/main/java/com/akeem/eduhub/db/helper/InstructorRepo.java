package com.akeem.eduhub.db.helper;

import com.akeem.eduhub.db.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepo extends JpaRepository<Instructor,String> {
}
