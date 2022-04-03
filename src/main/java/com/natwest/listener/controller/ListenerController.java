package com.natwest.listener.controller;

import com.natwest.listener.model.RestApiResponse;
import com.natwest.listener.model.Transaction;
import com.natwest.listener.service.ListenerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

/*
created by Rahul sawaria on 03/04/22
*/
@RestController
@RequestMapping(value = "listen/")
@RequiredArgsConstructor
public class ListenerController {

    private static final Logger logger = LoggerFactory.getLogger(ListenerController.class);

    private final ListenerService listenerService;

    @PostMapping("insert-account-transaction")
    public RestApiResponse listenTransactionData(@RequestBody String transaction) {
        logger.info("Inside listener account transaction at : {}", new Date());
        return RestApiResponse.buildSuccess(listenerService.listenMessage(transaction));
    }

}
