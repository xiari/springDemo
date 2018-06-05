package com.demo.mvc.MapperInterface;

import org.apache.shiro.session.Session;

import java.io.Serializable;

/**
 * Created by XYY78 on 2016/9/1.
 */

public interface MySessionMapper  {

    void createSession(Serializable sessionId ,String session);

    void doUpdate(Serializable sessionId ,String session);

    void doDelete(Serializable sessionId);

    String doRead(Serializable sessionId);
}
