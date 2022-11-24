package com.ll.comu.global.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.comu.article.dto.ArticleDto;

public class Ut {
    public static class json {
        public static String toStr(Object obj, String defaultValue) {
            ObjectMapper om = new ObjectMapper();

            try {
                return om.writeValueAsString(obj);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }
    }
}