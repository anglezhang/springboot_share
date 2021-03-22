package applicaitondemo.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * ClassName: HelloWorldRegistarOne <br/>
 * Description: <br/>
 * date: 2021/3/20 22:17<br/>
 *
 * @author zhangzhenxing<br />
 */
public class HelloWorldRegistarOne implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //返回的数组是类名称
        //类需要实现 ImportBeanDefinitionRegistrar 才可使用Spring 功能
        return new String[]{HelloWorldTestOne.class.getName()};
    }
}
