package com.demo.mvc.redis;

import redis.clients.jedis.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by XYY78 on 2017/7/6.
 */
public class RedisTest {

    public static void main(String[] args){
        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();
//        hostAndPortSet.add(new HostAndPort("192.168.119.133", 7000));
//        hostAndPortSet.add(new HostAndPort("192.168.119.133", 7001));
//        hostAndPortSet.add(new HostAndPort("192.168.119.133", 7002));
//        hostAndPortSet.add(new HostAndPort("192.168.119.133", 7003));
//        hostAndPortSet.add(new HostAndPort("192.168.119.133", 7004));
//        hostAndPortSet.add(new HostAndPort("192.168.119.133", 7005));


//        JedisCluster redisClient = new JedisCluster(hostAndPortSet);
//        redisClient.set("1" ,"raining bow ...");

        //        单机版： 192.168.119.133:6739
        JedisShardInfo shardInfo = new JedisShardInfo("10.201.128.132", 6379);
        shardInfo.setPassword("redis");
        List<JedisShardInfo> shardInfos = new ArrayList<JedisShardInfo>();
        shardInfos.add(shardInfo);
        ShardedJedis jedis = new ShardedJedis(shardInfos);

        // 1. String value类型值
        // 1.1 值设置与读取
        jedis.set("dbType","mysql");
        jedis.set("dbtype","oracle");
        System.out.print(jedis.get("dbType")+ System.getProperty("line.separator"));

        jedis.set("dbtype".getBytes(),"mysql".getBytes());
        System.out.print(new String(jedis.get("dbtype".getBytes()))+ System.getProperty("line.separator"));
        // 1.2 key删除
        jedis.del("dbType");
        System.out.print(jedis.get("dbType")+ System.getProperty("line.separator"));

        // 2. list类型value
        // 2.1 向list中放值
        List<String> list = new ArrayList<>();
        jedis.lpush("list0","el0" );
        jedis.lpush("list0","el1" );
        jedis.lpush("list0","el2" );
        jedis.lpush("list0","el3" );
        jedis.lpush("list0","el4" );
        // 2.2 取list长度
        System.out.print(jedis.llen("list0")  + System.getProperty("line.separator"));
        // 2.3 从list中取值
        System.out.print(jedis.rpop("list0")  + System.getProperty("line.separator"));

        // 3. set类型
        // 3.1 向set放入值
        jedis.sadd("set0","set0");
        jedis.sadd("set0","set1");
        jedis.sadd("set0","set2");
        jedis.sadd("set0","set0");
        // 3.2 从set取出值
        jedis.spop("set0");
        System.out.print(jedis.spop("set0")  + System.getProperty("line.separator"));

        jedis.append("key","test1");
        jedis.append("key","test2");
        System.out.print(jedis.get("key") + System.getProperty("line.separator"));

        // 4. hash类型值
        jedis.hset("hashKey","name","zhangGang");
        jedis.hset("hashKey","address", "zhangjiang");
        System.out.print(jedis.hgetAll("hashKey") + System.getProperty("line.separator"));
        System.out.print(jedis.hget("hashKey", "name") + System.getProperty("line.separator"));
        jedis.close();
    }
}
