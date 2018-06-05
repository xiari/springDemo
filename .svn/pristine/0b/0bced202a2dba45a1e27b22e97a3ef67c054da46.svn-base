package com.zkFrame.serviceReg;


import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;

/**
 * Created by XYY78 on 2017/7/27.
 */
public class ServiceRegistry {

    private ServiceDiscovery<InstanceDetails> serviceDiscovery;

    private CuratorFramework client;

    public ServiceRegistry(CuratorFramework client, String base) {

        this.client = client;
        serviceDiscovery = ServiceDiscoveryBuilder.builder(InstanceDetails.class).client(client)
                .basePath(base)
                .serializer(new JsonInstanceSerializer<InstanceDetails>(InstanceDetails.class))
                .build();
    }
}
