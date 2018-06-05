package com.demo.mvc.service;

import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/2/4
 * Time: 22:25
 * To change this template use File | Settings | File Templates.
 */
@Service
class MySessionListener implements org.apache.shiro.session.SessionListener{
    @Override
    public void onStart(Session session) {
        System.out.print("on start: " + session.getId());
    }

    @Override
    public void onStop(Session session) {
        System.out.print("on stop: " + session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        System.out.print("on Expiration: " + session.getId());
    }
}