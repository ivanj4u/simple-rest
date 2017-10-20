/*
 * Copyright (c) 2017.
 */

package com.aribanilia.rest.simple.dto;

import org.hibernate.validator.constraints.NotBlank;

public class SimpleRequest {

    @NotBlank
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
