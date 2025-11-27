package com.willbe.common.autoconfigure;

import com.willbe.common.config.SecurityConfig;
import com.willbe.common.config.SecurityProperties;
import com.willbe.common.config.SwaggerConfig;
import com.willbe.common.config.SwaggerProperties;
import com.willbe.common.jwt.JwtProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@ComponentScan(basePackages = {
        "com.willbe.common.jwt",
        "com.willbe.common.exception"
})
@Import({SecurityConfig.class, SwaggerConfig.class})
@EnableConfigurationProperties({
        JwtProperties.class,
        SecurityProperties.class,
        SwaggerProperties.class
})
public class WillbeCommonAutoConfiguration {
}

