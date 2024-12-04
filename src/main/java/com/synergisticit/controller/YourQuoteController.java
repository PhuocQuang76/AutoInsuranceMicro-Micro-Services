package com.synergisticit.controller;

import com.synergisticit.domain.Vehicle;
import com.synergisticit.domain.YourQuote;
import com.synergisticit.service.YourQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class YourQuoteController {
    @Autowired
    YourQuoteService yourQuoteService;

    @PostMapping("/saveYourQuote")
    public YourQuote saveYourQuote(@RequestBody YourQuote yourQuote){
        return yourQuoteService.saveYourQuote(yourQuote);
    }


    @GetMapping("/yourQuotes")
    public List<YourQuote> findAllYourQuote(){
        return yourQuoteService.findAllYourQuotes();
    }

    @GetMapping("/yourQuoteByUsername/{username}")
    public YourQuote findByUsername(@PathVariable String username){
        return yourQuoteService.findByUserName(username);
    }

}
