package com.nttdata.movementinquiry.service.impl;

import com.nttdata.balanceinquiry.model.Inquiry;
import com.nttdata.balanceinquiry.repository.InquiryRepository;
import com.nttdata.balanceinquiry.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InquiryServiceImpl implements InquiryService {

    @Autowired
    InquiryRepository inquiryRepository;

    @Override
    public Flux<Inquiry> findAll() {
        return inquiryRepository.findAll();
    }

    @Override
    public Mono<Inquiry> save(Inquiry entity) {
        entity.setStatus(true);
        return inquiryRepository.save(entity);
    }

    @Override
    public Mono<Inquiry> update(Inquiry entity) {

        return  inquiryRepository.findById(entity.getId())
                .switchIfEmpty(Mono.empty())
                .flatMap(origin -> {
                    origin.setDescription(entity.getDescription());
                    origin.setStatus(entity.getStatus());
                    origin.setAccount(entity.getAccount());
                    origin.setDate(entity.getDate());
                    origin.setAmount(entity.getAmount());
                    return inquiryRepository.save(origin);
                });
    }

    @Override
    public Mono<Inquiry> delete(String id) {
        return inquiryRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .flatMap(origin -> {
                    origin.setStatus(false);
                    return inquiryRepository.save(origin);
                });
    }

    @Override
    public Flux<Inquiry> findByAccount(String account) {
        return inquiryRepository.findByAccount(account);
    }
}
