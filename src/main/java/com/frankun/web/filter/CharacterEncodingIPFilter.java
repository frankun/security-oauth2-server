package com.frankun.web.filter;

import com.frankun.web.WebUtils;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.slf4j.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 2016/10/11
 * 设置字符编码并记录IP地址
 * @author frankun
 */
public class CharacterEncodingIPFilter extends CharacterEncodingFilter{

    private static final Logger LOG = LoggerFactory.getLogger(CharacterEncodingIPFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException{
        recordIP(request);
        super.doFilterInternal(request, response, filterChain);
    }

    public void recordIP(HttpServletRequest request){
        final String ip = WebUtils.retrieveClientIp(request);
        WebUtils.setIp(ip);
        LOG.debug("Send request uri: {}, from IP: {}", request.getRequestURI(), ip);
    }
}
