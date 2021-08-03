package cn.com.chinasoft.springEvent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class SpringEventApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringEventApplication.class, args);
		/*new SpringApplicationBuilder(SpringEventApplication.class)
				.web(WebApplicationType.SERVLET).listeners(event -> {
			System.out.println(event.getClass().getSimpleName());
		}).run(args);*/
		//new SpringApplicationBuilder(SpringEventApplication.class).web(WebApplicationType.SERVLET).listeners()

		//获取退出码
//		int excode = SpringApplication.exit(new SpringApplicationBuilder(SpringEventApplication.class)
//				.web(WebApplicationType.SERVLET).run(args));
//		System.out.println(excode);
//		System.exit(excode);
//		new SpringApplicationBuilder(SpringEventApplication.class)
//				.listeners((ApplicationListener<ApplicationReadyEvent>)event->{
//					throw new UnknownError("未知异常");
//				}).web(WebApplicationType.SERVLET)
//				.run(args);
				//.close();
	}

}
