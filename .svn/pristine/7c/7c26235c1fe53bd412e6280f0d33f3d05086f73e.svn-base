package com.zkFrame;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;
import org.apache.curator.utils.CloseableUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by XYY78 on 2017/7/25.
 * 1, 临时节点，持久性节点，序列节点的创建： 临时节点只能作为持久性节点的叶子节点
 * 2，节点数据更新
 * 3, 节点删除：非空结点不能删除
 * 3，监听器
 *      watcher / curatorWatcher / CuratorListener --原理呢是什么？
 *
 */


public class ZkNodeManage {

    private static String BASE_PATH = "/test";
    public static void main(String[] args) throws Exception {

        TestingServer testingServer = new TestingServer();
//        server.1=10.199.67.62:2888:3888
//        server.2=10.199.67.62:2889:3889
//        server.3=10.199.67.62:2890:3890

//        CuratorFramework client  = CuratorFrameworkFactory.newClient(testingServer.getConnectString(), new ExponentialBackoffRetry(1000,3));
        CuratorFramework client = CuratorFrameworkFactory.newClient("10.199.67.62:4000", new ExponentialBackoffRetry(1000, 3));
        client.start();
        // 连接状态监听器
       /* client.getConnectionStateListenable().addListener(new ConnectionStateListener() {
            public void stateChanged(CuratorFramework client, ConnectionState newState) {
                System.out.println("client state:" + newState.name());
            }
        });

        // 增加节点监听器
        client.getCuratorListenable().addListener(new CuratorListener() {
            public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
                System.out.println("监听器  : " + event.getType() + "\n" +
                        event.getPath());
            }
        });



        // 创建持久化节点并设置监听器:2次更新节点数据只能监听一次
        Stat stat01 = client.checkExists().usingWatcher(new CuratorWatcher() {
            public void process(WatchedEvent event) throws Exception {
                System.out.println("获取 /test/child01 节点 监听器 : " + event.getType());
            }
        }).forPath("/test/child01");

        Stat stat02 = client.checkExists().usingWatcher(new CuratorWatcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println("获取 /test/child02 节点 监听器 : " + watchedEvent.getType());
            }
        }).forPath("/test/child02");

        System.out.print("stat01: " + stat01 + "\n");
        System.out.print("stat02: " + stat02 + "\n");
        if(stat01 == null) {
            client.create().forPath("/test/child01");
        }
        if(stat02 == null) {
            client.create().forPath("/test/child02");
        }*/

        // 创建临时节点：临时节点只能创建在持久化节点，作为叶子节点
/*        String ephemeralNode01 = client.create().withMode(CreateMode.EPHEMERAL).forPath("/test/child01/ephemeral");
        System.out.print("ephemeralNode01 ： " + ephemeralNode01 +"\n");
        String ephemeralSeqNode01 = client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/test/child01/ephemeralSeq");
        System.out.print("ephemeralSeqNode01 ： " + ephemeralSeqNode01 +"\n");*/

//        setListenerPathChildCache(client,BASE_PATH);
//
//        setListenerPathNodeCache(client,BASE_PATH);

        setListenerTreeCache(client,BASE_PATH);

        // 3次更新/test子节点数据
        Stat stat1 = client.setData().forPath("/test/child01", "testNodeData01".getBytes());
        System.out.println(stat1);

        Stat stat2 = client.setData().forPath("/test/child01", "testNodeData02".getBytes());
        System.out.println(stat2);

        Stat stat3 = client.setData().forPath("/test/child01", "testNodeData03".getBytes());
        System.out.println(stat3);

        // 更新节点数据
        Stat stat4 = client.setData().forPath("/test/child02", "testNodeData02".getBytes());
        System.out.println(stat4);

        // 获取节点数据
/*        List<String> listNode = client.getChildren().forPath("/test");
        System.out.println(listNode);

        for (String str : listNode
                ) {
            // 删除节点
            client.delete().forPath("/test" + "/" + str);
        }*/
        CloseableUtils.closeQuietly(client);
    }

    /* 节点监听器
    * @描述：第一种监听器的添加方式: 对指定的节点进行添加操作
    * 仅仅能监控指定的本节点的数据修改,删除 操作 并且只能监听一次 --->不好
    */
    private static void setNodeListener(CuratorFramework client, String path){
        try {
            byte[] data = client.getData().usingWatcher(new CuratorWatcher() {
                public void process(WatchedEvent event) throws Exception {
                    System.out.println("获取 two 节点 监听器 : " + event);
                }
            }).forPath(path);
            System.out.println("two 节点数据: "+ new String(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  //  1.PathChildrenCache  连接  路径  是否获取数据
     //  能监听所有的子节点 且是无限监听的模式 但是 指定目录下节点的子节点不再监听
     */
    private static void setListenerPathChildCache(CuratorFramework client ,String path) throws Exception {
        PathChildrenCache pathChildrenCache = new PathChildrenCache(client,path,true );
        PathChildrenCacheListener listener = new PathChildrenCacheListener() {
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                System.out.println("开始进行事件分析:-----");
                ChildData childData = event.getData();
                switch (event.getType()){
                    case CHILD_ADDED:
                        System.out.println("CHILD_ADDED : "+ childData.getPath() +"  数据:"+ childData);
                        break;
                    case CHILD_UPDATED:
                        System.out.println("CHILD_UPDATED : "+ childData.getPath() +"  数据:"+ childData);
                        break;
                    case CHILD_REMOVED:
                        System.out.println("CHILD_REMOVED : "+ childData.getPath() +"  数据:"+ childData);
                        break;
                    default:break;
                }
            }
        };
        pathChildrenCache.getListenable().addListener(listener);
        System.out.println("Register zk watcher successfully!");
        pathChildrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
    }

    /**
     *  //  2.NodeCache
     */
    private static void setListenerPathNodeCache(CuratorFramework client ,String path) throws Exception {
        final NodeCache nodeCache = new NodeCache(client,path,true );
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            public void nodeChanged() throws Exception {
                System.out.println("the test node is change and result is :");
                System.out.println("path : "+nodeCache.getCurrentData().getPath());
                System.out.println("data : "+new String(nodeCache.getCurrentData().getData()));
                System.out.println("stat : "+nodeCache.getCurrentData().getStat());
            }
        });
        nodeCache.start();
    }

    /**
     *  //  3.TreeCache
     */
    private static void setListenerTreeCache(CuratorFramework client ,String path) throws Exception {
        final TreeCache treeCache = new TreeCache(client,path);
        treeCache.getListenable().addListener(new TreeCacheListener() {
            public void childEvent(CuratorFramework client, TreeCacheEvent event) throws Exception {
                ChildData childData = event.getData();
                if(childData == null) {
                    System.out.println("childData is null ... " );
                }else{
                    switch (event.getType()){
                        case NODE_ADDED:
                            System.out.println("NODE_ADDED : "+ childData.getPath() +"  数据:"+ childData);
                            break;
                        case NODE_UPDATED:
                            System.out.println("NODE_UPDATED : "+ childData.getPath() +"  数据:"+ childData);
                            break;
                        case NODE_REMOVED:
                            System.out.println("NODE_REMOVED : "+ childData.getPath() +"  数据:"+ childData);
                            break;
                        default:break;
                    }
                }
            }
        });
        treeCache.start();
    }
}
