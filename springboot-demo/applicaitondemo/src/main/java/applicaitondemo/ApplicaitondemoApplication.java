package applicaitondemo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;


public class ApplicaitondemoApplication {

	public static void main(String[] args) {
		//监听Spring 事件
		new SpringApplicationBuilder(Object.class).listeners(event -> {
			System.out.println("SpringApplicaiton 事件监听器 : + "
					+ event.getClass().getSimpleName()
					+ ",事件源 : " + event.getSource());
		})
		.web(WebApplicationType.NONE)
		.run(args)
		.close();

	}

}
