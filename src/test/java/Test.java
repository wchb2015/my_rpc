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


    @org.junit.Test
    public void test02() {
        List<String> stringList = new ArrayList<>();

        stringList.add("deepak");
        stringList.add("bei");

        System.out.println(stringList);

        Collections.swap(stringList, 0, 1);
        System.out.println(stringList);



/*
        String s1 = stringList.get(0);
        String s2 = stringList.get(1);

        stringList.clear();
        stringList.add(s2);
        stringList.add(s1);

        System.out.println(stringList);*/

    }


    @org.junit.Test
    public void test03() {
        System.out.println(getPriority(0.05f, 0.03f, 1f, 0.04f, 0.5f));
        System.out.println(getPriority(0.08f, 0.05f, 1f, 0.04f, 0.5f));
        System.out.println(getPriority(0.16f, 0.14f, 1f, 0.15f, 0.5f));


        System.out.println(getPriority(0.1f, 0.08f, 1f, 0.07f, 0.5f));
        System.out.println(getPriority(0.17f, 0.08f, 1f, 0.3f, 0.5f));
        System.out.println(getPriority(0.12f, 0.08f, 1f, 0.15f, 0.5f));
        System.out.println(getPriority(0.07f, 0.08f, 1f, 0.7f, 0.5f));
        System.out.println(getPriority(0.08f, 0.11f, 1f, 0.15f, 0.5f));
        System.out.println(getPriority(0.07f, 0.11f, 1f, 0.07f, 0.5f));
        System.out.println(getPriority(0.11f, 0.24f, 1f, 0.26f, 0.5f));



/*        System.out.println(getPriority(value, cost, costWeight, risk, riskWeight));
        System.out.println(getPriority(value, cost, costWeight, risk, riskWeight));
        System.out.println(getPriority(value, cost, costWeight, risk, riskWeight));
        System.out.println(getPriority(value, cost, costWeight, risk, riskWeight));*/
    }

    private float getPriority(float value, float cost,
                              float costWeight, float risk,
                              float riskWeight) {

        float result = 0f;

        result = value / ((cost * costWeight) + (risk * riskWeight));

        return result;

    }
}
