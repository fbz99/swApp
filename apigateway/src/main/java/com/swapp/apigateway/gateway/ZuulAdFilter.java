package com.swapp.apigateway.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.swapp.apigateway.feign.AnnuncInterface;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulAdFilter extends ZuulFilter {
    private static final Logger log =  LoggerFactory.getLogger(ZuulAdFilter.class);
    @Autowired AnnuncInterface annuncInterface;
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().get("proxy").equals("annuncio");
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("PreFilter: " + String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        //annuncInterface.getAnnuncio(request.getRequestURL().substring(request.getRequestURL().indexOf("annuncio/")));
        return null;
    }
}