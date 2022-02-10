package com.nttdata.movementinquiry.service;

import com.nttdata.balanceinquiry.model.Inquiry;
import reactor.core.publisher.Flux;

public interface InquiryService extends CrudService<Inquiry, String> {
    Flux<Inquiry>findByAccount(String account);
}
