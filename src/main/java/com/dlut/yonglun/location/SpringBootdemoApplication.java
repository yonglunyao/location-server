package com.dlut.yonglun.location;

import com.dlut.yonglun.location.property.FileProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yonglunyao
 */
@SpringBootApplication
@EnableConfigurationProperties({
        FileProperties.class
})
@ComponentScan("com.dlut.yonglun")
public class SpringBootdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.dlut.yonglun.location.SpringBootdemoApplication.class, args);
    }
}