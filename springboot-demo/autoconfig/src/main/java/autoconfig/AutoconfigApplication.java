package autoconfig;


import autoconfig.config.AutoConfig;
import org.springframework.boot.SpringApplication;

//@SpringBootApplication //将 SpringBootApplication重构为 SpringBootConfiguration EnableAutoConfiguration ComponentScan
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan
public class AutoconfigApplication {

	public static void main(String[] args) {
		//SpringApplication.run(AutoconfigApplication.class, args);
		SpringApplication.run(AutoConfig.class,args);
	}

}
