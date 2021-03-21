package com.chinasoft.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * ClassName: 激活自动装配引导类 <br/>
 * Description: <br/>
 * date: 2021/3/21 22:48<br/>
 *
 * @author zhangzhenxing<br />
 */
@EnableAutoConfiguration(exclude = SpringApplicationAdminJmxAutoConfiguration.class)
public class EnableAutoConfigurationBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE) // 非 Web 应用
                .run(args)                    // 运行
                .close();                     //  关闭当前上下文
    }
}
