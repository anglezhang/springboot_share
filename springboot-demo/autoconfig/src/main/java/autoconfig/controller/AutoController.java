package autoconfig.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: AutoCOntroller <br/>
 * Description: <br/>
 * date: 2021/3/21 18:14<br/>
 *
 * @author zhangzhenxing<br />
 */
@RequestMapping(value = "/auto")
@RestController
public class AutoController {

    @GetMapping(value = "/sayHello")
    public String sayHello(){
        return "sayHello";
    }
}
