package com.natwest.listener.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.natwest.listener.enums.Currency;
import com.natwest.listener.enums.Type;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

import static com.natwest.listener.Constant.CANNOT_BE_EMPTY;

/*
created by Rahul sawaria on 03/04/22
*/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction implements Serializable {

    @Serial
    private static final long serialVersionUID = -5686268268617670712L;

    @NotNull(message = CANNOT_BE_EMPTY)
    private Long accountNumber;

    @NotNull(message = CANNOT_BE_EMPTY)
    private Type type;

    @NotNull(message = CANNOT_BE_EMPTY)
    private Double amount;

    @NotNull(message = CANNOT_BE_EMPTY)
    private Currency currency;

    @NotNull(message = CANNOT_BE_EMPTY)
    private Long accountFrom;

}
