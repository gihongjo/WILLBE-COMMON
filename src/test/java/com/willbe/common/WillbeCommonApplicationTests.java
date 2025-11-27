package com.willbe.common;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "willbe.jwt.secret=test-secret")
class WillbeCommonApplicationTests {

    @Test
    void contextLoads() {
    }

}
