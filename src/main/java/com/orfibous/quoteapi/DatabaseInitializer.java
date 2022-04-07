package com.orfibous.quoteapi;


import com.orfibous.quoteapi.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


/**
 * Used only for the purpose of this exercise application in order to initiate the database
 * */
@Component
public class DatabaseInitializer {

    @Autowired
    private QuoteService quoteService;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeDatabase() {
        quoteService.fetchQuotes();
    }
}
