package applicaitondemo;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

/**
 * ClassName: ExitCodeGenerator <br/>
 * Description: <br/>
 * date: 2021/3/16 19:15<br/>
 *
 * @author zhangzhenxing<br />
 */
//@EnableAutoConfiguration
public class ExitCodeGeneratorCodeDemo {

    /**
     * 注入退出码逻辑
     * */
    @Bean
    public ExitCodeGenerator exitCodeGenerator(){
        System.out.println("ExitCodeGenerator bean init");
        return ()->{
            System.out.println("ExitCodeGenerator code gen(88)");
            return 88;
        };
    }

    public static void main(String[] args) {
        //测试退出码
//        new SpringApplicationBuilder(ExitCodeGenerator.class)
//                .web(WebApplicationType.NONE)
//                .run(args)
//                .close();
        //退出码退出
        int excode = SpringApplication.exit(new SpringApplicationBuilder(ExitCodeGeneratorCodeDemo.class)
        .web(WebApplicationType.NONE)
        .run(args));
        System.out.println("exit code = " + excode);
        System.exit(excode);
    }
}
