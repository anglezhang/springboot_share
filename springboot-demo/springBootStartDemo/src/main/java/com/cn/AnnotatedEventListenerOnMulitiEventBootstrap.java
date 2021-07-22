package com.cn;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

/**
 * ClassName: AnnotatedEventListenerOnMulitiEventBootstrap <br/>
 * Description: <br/>
 * date: 2021/7/20 21:32<br/>
 *
 * @author zhangzhenxing<br />
 */
public class AnnotatedEventListenerOnMulitiEventBootstrap {

    public static void main(String[] args) {
        //创建注解驱动应用上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        //注册监听器
        context.register(MyMultiEventsListener.class);
        //初始化上下文
        context.refresh();
        //context.publishEvent(new ContextRefreshedEvent(null));
        //关闭上下文
        context.close();
    }

    /**
     * 监听器
     * */
    public static class MyMultiEventsListener{
        /**
         * 无参数监听
         * */
        @EventListener({ContextRefreshedEvent.class, ContextClosedEvent.class})
        public void onEvent(){
            System.out.println("onEvent ============ " );

        }

        @EventListener({ContextRefreshedEvent.class, ContextClosedEvent.class})
        public void onApplicationContextEvent(ApplicationContextEvent event){
            System.out.println("onEvents ============ " + event.getClass().getSimpleName() );

        }
    }
}
