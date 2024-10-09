package com.rookie.bigdata.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.UUID;

/**
 * @Class IDFilter
 * @Description
 * @Author rookie
 * @Date 2024/10/9 9:29
 * @Version 1.0
 */
@Component
public class IDFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String requestId = ((HttpServletRequest) request).getHeader("X-Request-ID");

        if (request instanceof HttpServletRequest) {

            if (StringUtils.isEmpty(requestId)) {
                requestId = UUID.randomUUID().toString();
            }

            MDC.put("request-id", requestId);
        }

        if (response instanceof HttpServletResponse) {
            ((HttpServletResponse) response).setHeader("X-Request-ID", requestId);
        }


        try {
            chain.doFilter(request, response);
        } finally {
            MDC.remove("request-id");
        }

    }
}
