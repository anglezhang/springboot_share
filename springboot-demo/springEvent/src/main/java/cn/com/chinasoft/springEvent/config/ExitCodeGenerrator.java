package cn.com.chinasoft.springEvent.config;

import org.springframework.boot.ExitCodeExceptionMapper;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: ExitCodeGenerrator <br/>
 * Description: <br/>
 * date: 2021/8/1 17:26<br/>
 *
 * @author zhangzhenxing<br />
 */
@Configuration
public class ExitCodeGenerrator {

    /**
     * 自定义 退出码
     * */
    @Bean
    public ExitCodeGenerator exitCodeGenerator(){
        System.out.println("ExitCodeGenerator bean 创建");
        return ()->{
            System.out.println("do something 生成退出码88");
            return 88;
        };
    }

    /**
     * 异常推出
     * */
    @Bean
    public ExitCodeExceptionMapper exitCodeExceptionMapper(){
        return (throwable)-> 128;
    }
}
