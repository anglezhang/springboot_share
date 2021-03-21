import com.chinasoft.JsonFormatter;
import org.junit.Assert;
import org.junit.Test;

/**
 * ClassName: JsonFormatterTest <br/>
 * Description: <br/>
 * date: 2021/3/21 22:42<br/>
 *
 * @author zhangzhenxing<br />
 */
public class JsonFormatterTest {

    @Test
    public void testFormat() {
        JsonFormatter formatter = new JsonFormatter();
        Assert.assertEquals("{\"id\":1,\"name\":\"张振兴\"}", formatter.format(new User()));
    }

    private static class User {

        private long id = 1;

        private String name = "张振兴";

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
