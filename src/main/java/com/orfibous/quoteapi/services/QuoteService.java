package com.orfibous.quoteapi.services;

import com.orfibous.quoteapi.controllers.LoggingController;
import com.orfibous.quoteapi.domain.Quote;
import com.orfibous.quoteapi.repositories.QuoteRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;


/**
 * Main service responsible for populating the database when the application starts and processing the data returned by the controllers
 * */
@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    Logger logger = LogManager.getLogger(LoggingController.class);

    /**
    * Fetches quotes from zenquotes.io
    * */
    public void fetchQuotes() {

        // Execute the request to fetch quotes
        try {
            URL url = new URL("https://zenquotes.io/api/quotes");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            logger.log(Level.INFO,"GET Quotes Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String input;
                StringBuilder response = new StringBuilder();

                while ((input = in.readLine()) != null) {
                    response.append(input);
                }
                in.close();

                //Save quotes to database
                JSONArray jsonObject = new JSONArray(response.toString());
                ArrayList<Quote> list =  Quote.jsonToQuotes(jsonObject);
                quoteRepository.saveAll(list);


            } else {
                logger.log(Level.ERROR, "GET Quotes failed");
            }

        } catch (MalformedURLException e) {
            logger.log(Level.ERROR, "Failed to fetch quotes from remote API");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a random Quote from the database
    * */
    public Quote getRandomQuote() {
        Random rand = new Random();
        return quoteRepository.findById((long) rand.nextInt(50)).orElse(null);
    }
}
