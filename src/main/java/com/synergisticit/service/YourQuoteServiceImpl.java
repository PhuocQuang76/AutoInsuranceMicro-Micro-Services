package com.synergisticit.service;

import com.synergisticit.domain.YourQuote;
import com.synergisticit.repository.YourQuoteRepository;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YourQuoteServiceImpl implements YourQuoteService{
    @Autowired
    YourQuoteRepository yourQuoteRepository;

    @Override
    public YourQuote saveYourQuote(YourQuote yourQuote) {
        return yourQuoteRepository.save(yourQuote);
    }

    @Override
    public List<YourQuote> findAllYourQuotes() {
        return yourQuoteRepository.findAll();
    }

    @Override
    public YourQuote findByUserName(String username) {
        return yourQuoteRepository.findByUsername(username);
    }

    @Override
    public void deleteByIdYourQuote(Long yourQuoteId) {
        yourQuoteRepository.deleteById(yourQuoteId);
    }
}
