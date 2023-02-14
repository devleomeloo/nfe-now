package com.melo.nfenow.exception;

import javax.persistence.EntityExistsException;

public class InvoiceAlreadyExistsException extends EntityExistsException {

    public InvoiceAlreadyExistsException(String serialNumber) {

        super(String.format("Invoice with serial number %s already exists!", serialNumber));
    }
}
