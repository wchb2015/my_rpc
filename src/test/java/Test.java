import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    @org.junit.Test
    public void test01() {
        logger.info("client:{}", 111);
    }

}
