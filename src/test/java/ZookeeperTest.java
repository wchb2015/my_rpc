import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZookeeperTest implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    private static final Logger logger = LoggerFactory.getLogger(ZookeeperTest.class);

    private String conntectedString = "120.77.46.197:2181";

    private int sessionTimeOut = 5000;

    @Test
    public void test01() throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper(conntectedString, sessionTimeOut, new ZookeeperTest());

        logger.info("zk state: {}", zooKeeper.getState());

        try {
            connectedSemaphore.await();
        } catch (InterruptedException e) {
            logger.error(" await error: {}", zooKeeper.getState());
            e.printStackTrace();
        }

        logger.info("zk session established, state: {}", zooKeeper.getState());

    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        logger.info("receive watch event:{}", watchedEvent);

        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            connectedSemaphore.countDown();
        }

    }
}

