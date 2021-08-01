package cn.com.chinasoft.springEvent.controller;

import cn.com.chinasoft.springEvent.service.TestService;
import com.sun.org.apache.bcel.internal.classfile.Unknown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: MyTestController <br/>
 * Description: <br/>
 * date: 2021/7/27 20:38<br/>
 *
 * @author zhangzhenxing<br />
 */
@RequestMapping(value = "test")
@RestController
public class MyTestController {

    /**
     * 测试异常
     * */
    //@Autowired
    private TestService testService;
    /**
     * 测试接口
     * */
    @RequestMapping(value = "/getTestStr")
    public String getTestStr(){
        return "hello China";
    }
}
