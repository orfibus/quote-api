package com.orfibous.quoteapi.controllers;

import com.orfibous.quoteapi.domain.Quote;
import com.orfibous.quoteapi.services.QuoteService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quote")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    Logger logger = LogManager.getLogger(LoggingController.class);

    /**
    * Exposes a GET endpoint for /quote mapping
    * */
    @GetMapping
    public ResponseEntity<?> getQuote() {

        try {
            Quote quote = quoteService.getRandomQuote();
            if (quote != null) {
                return ResponseEntity
                        .status(HttpStatus.CREATED).body(quote);
            }
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No quotes found");

        } catch (Exception e) {
            logger.log(Level.ERROR, e.toString());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing your request");
        }
    }
}
