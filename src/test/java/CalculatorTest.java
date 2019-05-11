import com.wchb.rpc.client.RpcProxy;
import com.wchb.rpc.server.ICalculator;
import com.wchb.rpc.server.IHelloService;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @date 5/11/19 3:07 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-client.xml")
public class CalculatorTest {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceTest.class);

    @Autowired
    private RpcProxy rpcProxy;

    @Test
    public void calculatorTest() {
        ICalculator calculatorService = rpcProxy.create(ICalculator.class);

        logger.info("result:{}", calculatorService.sum(1, 2));
    }
}
