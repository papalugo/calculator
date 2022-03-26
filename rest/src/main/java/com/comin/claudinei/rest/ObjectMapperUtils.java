package com.comin.claudinei.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {
    public static ObjectMapper getInstance() {
        return new ObjectMapper();
    }
}
