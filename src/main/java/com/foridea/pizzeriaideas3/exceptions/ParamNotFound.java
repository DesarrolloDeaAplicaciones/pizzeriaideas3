package com.foridea.pizzeriaideas3.exceptions;

public class ParamNotFound extends RuntimeException {
    public ParamNotFound(String  error){
        super(error);
    }
}
