package com.cn;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * ClassName: Spring 事件监听 <br/>
 * Description: <br/>
 * date: 2021/7/20 20:59<br/>
 *
 * @author zhangzhenxing<br />
 */
public class ApplicationListenerOnSpringEventsBootstrap {

    public static void main(String[] args) {
        //监听spring内建事件
        ConfigurableApplicationContext context = new GenericApplicationContext();
        System.out.println("创建Spring 应用上下文：" + context.getDisplayName());
        //添加 ApplicationListener 非泛型实现
        context.addApplicationListener(event -> {
            System.out.println("触发事件 ： " + event.getClass().getSimpleName());
        });
        //refresh() 初始化应用上下文
        System.out.println("准备初始化应用上下文.. " );
        context.refresh();
        System.out.println("完成初始化应用上下文.. " );
        System.out.println("准备停止应用上下文.. " );
        context.stop();
        System.out.println("完成停止应用上下文.. " );
        //context.publishEvent(new );

    }
}
