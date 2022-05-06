package com.example.customspringbootstarter.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import com.example.customspringbootstarter.MyHttpServletResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.ContentCachingResponseWrapper;

public class CustomLogginFilter implements Filter {

    private final static Logger LOG = LoggerFactory.getLogger(CustomLogginFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        ContentCachingResponseWrapper responseCacheWrapperObject = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);

        LOG.info(
                "Logging Request  {} : {}", req.getMethod(),
                req.getRequestURI());

        filterChain.doFilter(req, responseCacheWrapperObject);

        byte[] responseArray = responseCacheWrapperObject.getContentAsByteArray();
        String responseStr = new String(responseArray, responseCacheWrapperObject.getCharacterEncoding());
        responseCacheWrapperObject.copyBodyToResponse();

        LOG.info(
                "Logging Response :{}",
                responseStr);

    }

}
