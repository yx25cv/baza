package com.ds.baza.dsbaza.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

@Configuration
public class PaginationConfig implements PageableHandlerMethodArgumentResolverCustomizer {

    @Override
    public void customize(PageableHandlerMethodArgumentResolver pageableResolver) {
        pageableResolver.setOneIndexedParameters(true);
    }
}
