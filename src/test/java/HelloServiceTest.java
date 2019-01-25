import com.wchb.rpc.client.RpcProxy;
import com.wchb.rpc.server.IHelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-client.xml")
public class HelloServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceTest.class);

    @Autowired
    private RpcProxy rpcProxy;

    @Test
    public void helloTest() {
        IHelloService helloService = rpcProxy.create(IHelloService.class);
        String result = helloService.hello("World");

        logger.info("result:{}", result);
    }

}
