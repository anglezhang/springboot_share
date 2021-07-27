package com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: SpringEventDemoApplication <br/>
 * Description: <br/>
 * date: 2021/7/26 20:16<br/>
 *
 * @author zhangzhenxing<br />
 */
@SpringBootApplication
public class SpringEventDemoApplication {

    //启动类
    public static void main(String[] args) {
//        SpringApplication application = new SpringApplication();
//        application.run(args);
//        application.addPrimarySources();//可添加 其他主配置类，在泰国迁移项目中场景较多，适用于老项目改造，扫描的路径无法统一
        SpringApplication.run(SpringEventDemoApplication.class,args);
    }
}
