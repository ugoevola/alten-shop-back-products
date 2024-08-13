package com.alten.shop.common.exception;

import org.springframework.data.crossstore.ChangeSetPersister;

public class ProductNotFoundException extends ChangeSetPersister.NotFoundException {

    public ProductNotFoundException() {
        super();
    }

}
