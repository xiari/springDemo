package com.demo.mvc.utils;

import org.apache.shiro.session.Session;
import org.bson.internal.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/2/6
 * Time: 9:51
 * To change this template use File | Settings | File Templates.
 */

public class SerializeUtils {
    public static String serialize(Session session){
        try{
            ByteArrayOutputStream aos = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(aos);
            objectOutputStream.writeObject(session);
            return Base64.encode(aos.toByteArray());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static Session unSerialize(String sessionStr){
        try{
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(sessionStr));
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (Session)objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
