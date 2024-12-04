package com.synergisticit.repository;

import com.synergisticit.domain.YourQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YourQuoteRepository extends JpaRepository<YourQuote, Long> {
    YourQuote findByUsername(String username);
}
