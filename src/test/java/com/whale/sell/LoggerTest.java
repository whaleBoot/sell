package com.whale.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName LoggerTest
 * @Description TODO
 * @Author like
 * @Data 2019/3/7 16:34
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1(){
        String name = "whale";
        String password = "12345";
        log.debug("debug");
        log.info("name:{}, password:{}",name,password);
        log.error("error");
        log.warn("warn");

    }
}
