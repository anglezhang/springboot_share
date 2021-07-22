package com.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName: MyController <br/>
 * Description: <br/>
 * date: 2021/7/13 20:36<br/>
 *
 * @author zhangzhenxing<br />
 */
@RequestMapping(value = "/aiatest")
@Controller
public class MyController {

    @Autowired
    private ResourceLoader resourceLoader;

    /**
     * run
     * */
    @RequestMapping(value = "/myIndex")
    @ResponseBody
    public String myIndex(){
        return "It's test";
    }

}
