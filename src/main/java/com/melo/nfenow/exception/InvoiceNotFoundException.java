package com.melo.nfenow.exception;

import javax.persistence.EntityNotFoundException;

public class InvoiceNotFoundException extends EntityNotFoundException {

    public InvoiceNotFoundException(Long id) {
        super(String.format("Invoice with id %s not exists", id));
    }

}
