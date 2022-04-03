package com.natwest.listener.service.impl;

import com.natwest.listener.Dao.AccountTransactionDao;
import com.natwest.listener.entity.AccountTransactionEntity;
import com.natwest.listener.exception.ListenerApiException;
import com.natwest.listener.exception.ListenerBaseException;
import com.natwest.listener.helper.ListenerHelper;
import com.natwest.listener.model.Transaction;
import com.natwest.listener.service.ListenerService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import java.util.Base64;

/*
created by Rahul sawaria on 03/04/22
*/
@Service
@RequiredArgsConstructor
public class ListenerServiceImpl implements ListenerService {

    private static final Logger logger = LoggerFactory.getLogger(ListenerServiceImpl.class);

    private final ListenerHelper listenerHelper;
    private final AccountTransactionDao accountTransactionDao;

    @Override
    public Object listenMessage(String request) {

        if (Strings.isEmpty(request))
            throw new ListenerBaseException(ListenerApiException.EMPTY_REQUEST.getMessage());

        Transaction transaction;
        try {
            transaction = (Transaction) SerializationUtils.deserialize(Base64.getDecoder().decode(request));
        } catch (Exception e) {
            logger.error("Some thing went wrong while decrypting request is {}", e.getMessage());
            throw new ListenerBaseException(e.getMessage());
        }

        listenerHelper.validateRequest(transaction);

        AccountTransactionEntity entity = AccountTransactionEntity.builder()
                .accountFrom(transaction.getAccountFrom()).accountNumber(transaction.getAccountNumber())
                .type(transaction.getType().toString()).currency(transaction.getCurrency().toString())
                .amount(transaction.getAmount()).build();

        accountTransactionDao.save(entity);

        return "inserted successfully";
    }

}
