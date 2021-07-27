package com.cn;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.GenericApplicationContext;

/**
 * ClassName: ApplicationListenerBeanOnCustomerEventBootstrap <br/>
 * Description: <br/>
 * date: 2021/7/20 21:12<br/>
 *
 * @author zhangzhenxing<br />
 */
public class ApplicationListenerBeanOnCustomerEventBootstrap {

    public static void main(String[] args) {
        //监听自定义事件
        GenericApplicationContext context = new GenericApplicationContext();
        //注册监听器
        context.registerBean(MyAppliactionListener.class);
        //初始化上下文
        context.refresh();
        //发布自定义事件
        context.publishEvent(new MyAppliacitonEvent("hello springBootEvent"));
        //关闭上下文
        context.close();
        //再次发布事件
        //context.publishEvent(new MyAppliacitonEvent("hello springBootEvent"));
    }

    /**
     * 自定义事件
     * */
    public static class MyAppliacitonEvent extends ApplicationEvent{

        public MyAppliacitonEvent(Object source) {
            super(source);
        }
    }

    /**
     * 自定义监听器
     * */
    public static class MyAppliactionListener implements ApplicationListener<MyAppliacitonEvent>{
        @Override
        public void onApplicationEvent(MyAppliacitonEvent event) {
            System.out.println("do something and class name is = " + event.getClass().getSimpleName());
            System.out.println(event.getSource());
        }
    }
}
