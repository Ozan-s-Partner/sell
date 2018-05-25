package com.ozan;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.handler.LogicalHandler;

/**
 * @Author: Ozan
 * @Description:
 * @Date: Created in 16:45 2018/2/27.
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest2 {

    @Test
    public void test1() {
        String name = "ozan";
        String password = "password";
        log.debug("debug...");
        log.info("info...");
        log.error("error...");
        log.info("name:{},password:{}",name,password);
    }
}
