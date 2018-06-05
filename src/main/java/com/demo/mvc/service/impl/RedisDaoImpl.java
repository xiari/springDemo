package com.demo.mvc.service.impl;

import com.demo.mvc.service.RedisDao;
import com.demo.mvc.utils.RedisClientUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/2/6
 * Time: 13:07
 * To change this template use File | Settings | File Templates.
 */

@Service("redisDaoService")
public class RedisDaoImpl extends CachingSessionDAO implements RedisDao   {

    @Autowired
    private RedisClientUtils redisClientUtils;

    @Override
    public <T> boolean add(String key, T obj) {
        return false;
    }

    @Override
    public boolean add(String key, String value) {
        return false;
    }

    @Override
    public <T> boolean add(String key, List<T> list) {
        return false;
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public void delete(List<String> keys) {

    }

    @Override
    public <T> boolean update(String key, T obj) {
        return false;
    }

    @Override
    public boolean update(String key, String value) {
        return false;
    }

    @Override
    public boolean save(String key, String value) {
        return false;
    }

    @Override
    public <T> boolean save(String key, T obj) {
        return false;
    }

    @Override
    public <T> T get(String key, Class clazz) {
        return null;
    }

    @Override
    public <T> List<T> getList(String key, Class<T> clazz) {
        return null;
    }

    @Override
    public byte[] getByte(String key) {
        return new byte[0];
    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public <T> void add(String key, long timeout, T obj) {

    }

    @Override
    public void add(String key, long timeout, byte[] object) {

    }

    @Override
    public Set<String> keys(String pattern) {
        return null;
    }

    @Override
    public boolean exist(String key) {
        return false;
    }

    @Override
    public boolean set(String key, byte[] value) {
        return false;
    }

    @Override
    public boolean flushDB() {
        return false;
    }

    @Override
    public long dbSize() {
        return 0;
    }

    @Override
    protected void doUpdate(Session session) {

    }

    @Override
    protected void doDelete(Session session) {
        Serializable sessionId = session.getId();
        redisClientUtils.delete(sessionId.toString());
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        assignSessionId(session, sessionId);
        redisClientUtils.add(sessionId.toString(), session);
        System.out.println(redisClientUtils.get(sessionId.toString()));
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        return (Session) redisClientUtils.get(sessionId.toString());
    }
}
