package com.example.demo.filter;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * @author： lxh
 * @description：
 * @created: 2018/2/24 15:54
 * @modified by:
 */
public class TestErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> result = super.getErrorAttributes(requestAttributes, includeStackTrace);
        result.remove("exception");
        return result;
    }
}
