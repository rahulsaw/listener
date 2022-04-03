package com.natwest.listener.helper;

import com.natwest.listener.exception.ListenerApiException;
import com.natwest.listener.exception.ListenerBaseException;
import com.natwest.listener.model.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.text.MessageFormat;

/*
created by Rahul sawaria on 03/04/22
*/
@Component
public class ListenerHelper {

    public void validateRequest(Transaction transaction) {

        if (String.valueOf(transaction.getAccountNumber()).length() < 11 || String.valueOf(transaction.getAccountFrom()).length() < 11 ||
                String.valueOf(transaction.getAccountNumber()).length() > 11 || String.valueOf(transaction.getAccountFrom()).length() > 11) {
            throw new ListenerBaseException(MessageFormat.format(ListenerApiException.INVALID_REQUEST.getMessage(),
                    "account Number"));
        }

        if (transaction.getAmount() <= 0)
            throw new ListenerBaseException(ListenerApiException.INVALID_AMOUNT.getMessage());

    }
}
