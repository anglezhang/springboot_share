import com.cn.model.Child;
import com.cn.model.Man;
import com.cn.utils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * ClassName: TesBeanUtils <br/>
 * Description: <br/>
 * date: 2021/7/26 21:04<br/>
 *
 * @author zhangzhenxing<br />
 */
public class TesBeanUtils {

    @Test
    public void testToUpper(){
        String name = "name";
        name = BeanUtils.firstCharToUpperCase(name);
        System.out.println(name);
    }

    /**
     * test bean uitl
     * */
    @Test
    public void testSetBeanValues(){
        try {
            //现实的应用场景，可能比这个复杂，比如，要考虑字段类型的匹配，命名是否一致等 但最核心的步骤已经实现
            //其余的就是沟通或者细节实现技巧，
            //比如命名不匹配，接口发布后，一般返回的数据就比较稳定了，我们可以将它做成配置文件
            //字段类型，看筛选出大部分有规律的
            //避免产生意料之外的问题 最好方法就是提前沟通
            Child child = new Child();
            BeanUtils.setObjFieldValues(child,"age","5");
            BeanUtils.setObjFieldValues(child,"tel","1802222111");
            System.out.println(child.toString());
            Man man = new Man();
            Date dob = new Date();
            BeanUtils.setObjFieldValues(man,"dob",dob);
            System.out.println(man.getDob());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
