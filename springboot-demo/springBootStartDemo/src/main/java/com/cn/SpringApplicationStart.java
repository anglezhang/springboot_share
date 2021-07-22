package com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;

import java.util.Arrays;

/**
 * ClassName: SpringApplicationStart <br/>
 * Description: <br/>
 * date: 2021/7/13 20:33<br/>
 *
 * @author zhangzhenxing<br />
 */
@SpringBootApplication
public class SpringApplicationStart {
    public static void main(String[] args) {
        //调整 application 设置
//        SpringApplication application = new SpringApplication(MySpringBootStrart.class);
//        application.setBanner(new Banner() {
//            @Override
//            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
//                out.println("my banner");
//            }
//        });
//        application.run(args);

        //运行说明 srpingboot 默认扫包路径
        ConfigurableApplicationContext context =
            SpringApplication.run(SpringApplicationStart.class,args);
        //ResourceLoader resourceLoader = (ResourceLoader)context.getBean(ResourceLoader.class);
        //ResourceLoader resourceLoader = (ResourceLoader)context.getBean("annotationConfigServletWebServerApplicationContext");
//        Arrays.stream(context.getBeanDefinitionNames()).forEach(name->{
//            System.out.println(name);
//        });

        //context.getBean(ServletWebServerApplicationContext)
//        ResourceLoader resourceLoader = (ResourceLoader)context.getBean("resourceLoader");
        //System.out.println(resourceLoader.getClass().getName());
        //System.out.println(ClassUtils.isPresent("org.springframework.web.reactive.DispatcherHandler",null));
    }

    @Bean
    public String myTest (ApplicationContext applicationContext){
        System.out.println(applicationContext.getClass().getName());
        return "myTest";
    }
}
