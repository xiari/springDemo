package com.zkFrame;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.ZKPaths;

/**
 * Created by XYY78 on 2017/7/25.
 */
public class PathCacheApp {

    private static final String     PATH = "/test";

    public static void main(String[] args) throws Exception {
        CuratorFramework    client = null;
        PathChildrenCache cache = null;
        client  = CuratorFrameworkFactory.newClient("10.199.67.62:4000", new ExponentialBackoffRetry(1000,3));
        client.start();

        cache = new PathChildrenCache(client, PATH,true);
        cache.getListenable().addListener(new PathChildrenCacheListener() {
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                switch ( event.getType() )
                {
                    case CHILD_ADDED:
                    {
                        System.out.println("Node added: " + ZKPaths.getNodeFromPath(event.getData().getPath()));
                        break;
                    }

                    case CHILD_UPDATED:
                    {
                        System.out.println("Node changed: " + ZKPaths.getNodeFromPath(event.getData().getPath()));
                        break;
                    }

                    case CHILD_REMOVED:
                    {
                        System.out.println("Node removed: " + ZKPaths.getNodeFromPath(event.getData().getPath()));
                        break;
                    }
                }
            }
        });
        // 创建路径
        String path = ZKPaths.makePath(PATH, "service");
        client.create().forPath(path);
        // 删除路径
//        client.delete().forPath(PATH);
    }
}
