package com.nttdata.movementinquiry.repository;

import com.nttdata.balanceinquiry.model.Inquiry;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface InquiryRepository extends ReactiveMongoRepository<Inquiry, String> {

    Flux<Inquiry> findByAccount(String account);
}
