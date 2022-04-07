package com.orfibous.quoteapi.domain;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "quote")
public class Quote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String quote;
    private String person;
    private String length;
    private String embeddedCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String date) {
        this.length = date;
    }

    public String getEmbeddedCode() {
        return embeddedCode;
    }

    public void setEmbeddedCode(String embeddedCode) {
        this.embeddedCode = embeddedCode;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                ", person='" + person + '\'' +
                ", date='" + length + '\'' +
                '}';
    }

    /**
     * Converts a json string to quote object
     * */
    public static ArrayList<Quote> jsonToQuotes(JSONArray json) {
        ArrayList<Quote> quotes = new ArrayList<Quote>();

        for (int i = 0; i < json.length(); i++) {
            JSONObject jsonobject = json.getJSONObject(i);
            Quote quote = new Quote();
            quote.setQuote(jsonobject.getString("q"));
            quote.setPerson(jsonobject.getString("a"));
            quote.setLength(jsonobject.getString("c"));
            quote.setEmbeddedCode(jsonobject.getString("h"));
            quotes.add(quote);
        }

        return quotes;
    }

}
