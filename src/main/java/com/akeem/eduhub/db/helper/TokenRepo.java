package com.akeem.eduhub.db.helper;

import com.akeem.eduhub.db.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepo extends JpaRepository<Token, String> {
}
