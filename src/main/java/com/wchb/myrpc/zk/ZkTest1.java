package com.wchb.myrpc.zk;


import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class ZkTest1 implements Watcher {

    private static final Logger logger = LoggerFactory.getLogger(ZkTest1.class);

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static ZooKeeper zooKeeper = null;


    public static void main(String[] args) throws Exception {
        zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new ZkTest1());

        logger.info("state :{},sessionId:{},passWd:{}", zooKeeper.getState(),
                zooKeeper.getSessionId(), Arrays.asList(zooKeeper.getSessionPasswd()));

        try {
            connectedSemaphore.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        zooKeeper.create("/idea1", "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        logger.info("Zk session established!");
    }

    @Override
    //负责处理来自ZK服务端的Watcher接口
    public void process(WatchedEvent watchedEvent) {
        logger.info(" Receive watched event :{}", watchedEvent);
        if (Objects.equals(Event.KeeperState.SyncConnected, watchedEvent.getState())) {
            connectedSemaphore.countDown();
        }
    }
}
