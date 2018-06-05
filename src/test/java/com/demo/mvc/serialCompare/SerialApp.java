package com.demo.mvc.serialCompare;

import com.alibaba.fastjson.JSON;
import com.demo.mvc.model.Person;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.ByteBufferOutput;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.DefaultSerializers;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerialApp {

    public static void main(String[] args){

        serialKryo();

        // 序列化person对象
       /* List< Person> personList = new ArrayList<>(100000);
        for (int i = 0; i < 100000 ; i++) {
            Person person = new Person("zhang"+i);
            personList.add(person);
        }
        for (int i = 0; i < 10 ; i++) {
            System.out.println("Xml : ");
            String xmlStr = serialPerson2Xml(personList);
            // 反序列化person对象
            unSerialXml2Person(xmlStr);
            System.out.println("Probuff : ");
            // 序列化by probuff
            List<byte[]> bytes = serialPerson2Probuff(personList);
            // 反序列化 by proBuff
            unSerialProBuff2Peron(bytes);

            // 序列化by json 之一： fastJson
            System.out.println("fastJson : ");
            String jsonStr = serialPerson2Json(personList);
            // 反序列化by json 之一： fastJson
            unSerialJson2Person(jsonStr);

            System.out.println("Jackson : ");
            String jackSonStr = serialPerson2Jckson(personList);
            unSerialJackson2Person(jackSonStr);

            System.out.println("Gson : ");
            String gsonStr = serialPerson2Gson(personList);
            unSerialGson2Person(gsonStr);
        }*/
    }

    private static void unSerialGson2Person(String gsonStr) {
        long start = System.currentTimeMillis() ;
        List<Person>  personList = new Gson().fromJson(gsonStr,List.class);
        long end = System.currentTimeMillis() ;
        System.out.println( end - start + "ms" + " Gson" );
    }

    private static String serialPerson2Gson(List<Person> personList) {
        long start = System.currentTimeMillis() ;
        String jsonstr = new Gson().toJson(personList,List.class);
        long end = System.currentTimeMillis() ;
        System.out.println( end - start + "ms" + " Gson" );
        return jsonstr;
    }

    private static void unSerialJackson2Person(String jackSonStr) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            long start = System.currentTimeMillis() ;
            List<Person>  personList = (List<Person>) mapper.readValue(jackSonStr, List.class);
            long end = System.currentTimeMillis() ;
            System.out.println( end - start + "ms" + " Jckson" );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String serialPerson2Jckson(List<Person> personList) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            long start = System.currentTimeMillis() ;
            String string = mapper.writeValueAsString(personList);
            long end = System.currentTimeMillis() ;
            System.out.println( end - start + "ms" + " Jckson" );
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void unSerialJson2Person(String jsonStr) {
        long start = System.currentTimeMillis() ;
        List<Person> personList = JSON.parseArray(jsonStr, Person.class );
        long end = System.currentTimeMillis() ;
        System.out.println( end - start + "ms" + " fastJson" );
    }

    private static String serialPerson2Json(List<Person> personList) {

        long start = System.currentTimeMillis() ;
        String jsonStr = JSON.toJSONString(personList);
        long end = System.currentTimeMillis() ;
        System.out.println( end - start + "ms" + " fastJson" );
        return jsonStr;
    }

    private static void unSerialProBuff2Peron(List<byte[]> bytes) {
        long start = System.currentTimeMillis() ;
        List<Person> personList = new ArrayList<>();
        Schema<Person> schema = RuntimeSchema.getSchema(Person.class);
        for(byte[] byteArr : bytes) {
            Person person = new Person();
            ProtostuffIOUtil.mergeFrom(byteArr, person,schema);
            personList.add(person);
        }
        long end = System.currentTimeMillis() ;
        System.out.println( end - start + "ms" );
    }

    private static List<byte[]> serialPerson2Probuff(List<Person> personList) {
        long start = System.currentTimeMillis() ;
        List<byte[]> bytes = new ArrayList<byte[]>();
        Schema<Person> schema = RuntimeSchema.getSchema(Person.class);
        LinkedBuffer buffer = LinkedBuffer.allocate(4096);
        for(Person p : personList) {
            try {
                byte[] protostuff = ProtostuffIOUtil.toByteArray(p, schema, buffer);
                bytes.add(protostuff);
            } finally {
                buffer.clear();
            }
        }
        long end = System.currentTimeMillis() ;
        System.out.println( end - start + "ms" );
        return bytes;
    }

    private static void unSerialXml2Person(String xmlStr) {
        XStream xStream = new XStream();
        long start = System.currentTimeMillis() ;
        List<Person> personList = (List<Person>)xStream.fromXML(xmlStr);
        long end = System.currentTimeMillis() ;
        System.out.println( end - start + "ms" );
    }

    private static String serialPerson2Xml(List<Person> personList) {
        XStream xStream = new XStream();
        long start = System.currentTimeMillis() ;
        String result = xStream.toXML(personList);
        long end = System.currentTimeMillis() ;
        System.out.println( end - start + "ms" );
        return result;
    }

    private static void serialKryo(){
        // ...
        Kryo kryo = new Kryo();
        DefaultSerializers defaultSerializers = DefaultSerializers.
        // ...
        try {
            Output output = new Output(new FileOutputStream("file.bin"));
            Person person = new Person("zhanggang");
            kryo.writeObject(output, person);
            output.close();
            // ...
            Input input = new Input(new FileInputStream("file.bin"));
            person = kryo.readObject(input, Person.class);
            input.close();
            System.out.println("person: " + person);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
