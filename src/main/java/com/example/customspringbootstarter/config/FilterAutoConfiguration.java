package com.example.customspringbootstarter.config;

import com.example.customspringbootstarter.filter.CustomLogginFilter;
import com.example.customspringbootstarter.service.Service;
import com.example.customspringbootstarter.service.ServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterAutoConfiguration {
//
//    @Bean
//    @ConditionalOnMissingBean
//    public Service service(){
//        return new ServiceImpl();
//    }

    @Bean
    @ConditionalOnMissingBean
    public FilterRegistrationBean<CustomLogginFilter> loggingFilter(){
        FilterRegistrationBean<CustomLogginFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new CustomLogginFilter());

        return registrationBean;
    }

}
