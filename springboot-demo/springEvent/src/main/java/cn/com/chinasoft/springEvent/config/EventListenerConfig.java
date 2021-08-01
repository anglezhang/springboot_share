package cn.com.chinasoft.springEvent.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.*;

import javax.annotation.PostConstruct;

/**
 * ClassName: EventListenerConfig <br/>
 * Description: <br/>
 * date: 2021/7/27 20:24<br/>
 *
 * @author zhangzhenxing<br />
 */
@Configuration//注解监听，第一点必须是spring 管理的bean
public class EventListenerConfig {

    /**
     * log util
     * */
    private static final Logger log = LoggerFactory.getLogger(EventListenerConfig.class);

    /**
     * 注解监听，第二点，方法public  无参 或 一个参数,参数类型为 ObjectEvent实现类,无返回值
     * */
    @EventListener({ContextRefreshedEvent.class, ContextStartedEvent.class
        , ContextStoppedEvent.class, ContextClosedEvent.class
        , ApplicationStartedEvent.class, ApplicationEnvironmentPreparedEvent.class
        , ApplicationPreparedEvent.class, ApplicationReadyEvent.class
        , ApplicationFailedEvent.class})
    public void onEvent(ApplicationEvent event){ //ApplicationEvent 是spring 和 spring boot 事件共同的基类
        log.info("Annotation Listener event class = {}",event.getClass().getSimpleName());
    }

    /**
     * PostConstruct
     * */
    @PostConstruct
    public void beanPostProcesso(){
        log.info("beanPostProcesso ...");
    }

}
