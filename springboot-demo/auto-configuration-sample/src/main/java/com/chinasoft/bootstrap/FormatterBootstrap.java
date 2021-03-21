package com.chinasoft.bootstrap;

import com.chinasoft.Formatter;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: FormatterBootstrap <br/>
 *
 * @author zhangzhenxing<br />
 * @see com.chinasoft.FormatterAutoConfiguration
 * date: 2021/3/21 22:49<br/>
 * {@link Formatter} 引导类
 */
@EnableAutoConfiguration
public class FormatterBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(FormatterBootstrap.class)
                .web(WebApplicationType.NONE)  // 非 Web 应用
//                 .properties("formatter.enabled=true") // 配置默认属性, "=" 前后不能有空格
                .run(args);                    // 运行
        // 待格式化对象
        Map<String, Object> data = new HashMap<>();
        data.put("name", "张振兴");
        // 获取 Formatter 来自于 FormatterAutoConfiguration
        Map<String, Formatter> beans = context.getBeansOfType(Formatter.class);
        if (beans.isEmpty()) { // 如果 Bean 不存在，抛出异常
            throw new NoSuchBeanDefinitionException(Formatter.class);
        }
        beans.forEach((beanName, formatter) -> {
            System.out.printf("[Bean name : %s] %s.format(data) : %s\n", beanName, formatter.getClass().getSimpleName(),
                    formatter.format(data));
        });

        //  关闭当前上下文
        context.close();
    }
}
