package com.orfibous.quoteapi.repositories;

import com.orfibous.quoteapi.domain.Quote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {

}
