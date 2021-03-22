package applicaitondemo.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * ClassName: EnableHelloWorld <br/>
 * Description: <br/>
 * date: 2021/3/20 22:15<br/>
 *
 * @author zhangzhenxing<br />
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(HelloWorldRegistarOne.class)
@Documented
public @interface EnableHelloWorld {
}
