package com.synergisticit.service;

import com.synergisticit.domain.YourQuote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface YourQuoteService {
    public YourQuote saveYourQuote(YourQuote yourQuote);

    public List<YourQuote> findAllYourQuotes();

    public YourQuote findByUserName(String username);


    public void deleteByIdYourQuote(Long yourQuoteId);


}
