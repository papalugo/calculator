package com.comin.claudinei.core;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {
    public static ObjectMapper getInstance() {
        return new ObjectMapper();
    }
}
