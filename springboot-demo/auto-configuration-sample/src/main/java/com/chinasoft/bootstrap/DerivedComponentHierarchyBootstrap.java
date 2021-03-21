package com.chinasoft.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * {@link Component} 派生层次性引导类
 * Description: <br/>
 * date: 2021/3/21 22:47<br/>
 *
 * @author zhangzhenxing<br />
 */
@SpringBootApplication
public class DerivedComponentHierarchyBootstrap {
    public static void main(String[] args) {
        // 当前引导类
        Class<?> bootstrapClass = DerivedComponentHierarchyBootstrap.class;
        // 运行 Spring Boot，并返回 Spring 应用上下文
        ConfigurableApplicationContext context = new SpringApplicationBuilder(bootstrapClass)
                .web(WebApplicationType.NONE) // 非 Web 类型
                .run();
        System.out.println("当前引导类 Bean ：" + context.getBean(bootstrapClass));
        // 关闭 Spring 应用上下文
        context.close();
    }
}
