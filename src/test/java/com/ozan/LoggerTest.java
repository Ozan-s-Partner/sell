package com.ozan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Ozan
 * @Description:
 * @Date: Created in 16:05 2018/2/27.
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {

    final private Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1(){
        logger.debug("debug...");
        logger.info("info...");
        logger.error("error...");
    }


}
