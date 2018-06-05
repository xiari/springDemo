package com.demo.mvc.service;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/2/6
 * Time: 16:26
 * To change this template use File | Settings | File Templates.
 */

public class RedisCachingSessionDao extends CachingSessionDAO {


    @Override
    protected void doUpdate(Session session) {

    }

    @Override
    protected void doDelete(Session session) {

    }

    @Override
    protected Serializable doCreate(Session session) {
        return null;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        return null;
    }
}
