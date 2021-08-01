package com.cn.utils;

import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName: BeanUtils <br/>
 * Description: <br/>
 * date: 2021/7/26 20:49<br/>
 *
 * @author zhangzhenxing<br />
 */
public class BeanUtils {

    /**
     * 设置对象的各个属性
     * @param obj 对象
     * @param fieldName 属性名称
     * @param value 对象值
     * */
    public static void setObjFieldValues(Object obj,String fieldName,Object value)throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        String methodName = "set" + firstCharToUpperCase(fieldName);
        Method method = ClassUtils.getMethodIfAvailable(obj.getClass(),methodName,value.getClass());
        ReflectionUtils.makeAccessible(method);
        method.invoke(obj,value);

    }

    /**
     * 第一个字母转大写
     * */
    public static String firstCharToUpperCase(String key){
        //方法 有个 bug 缺少是否是字母的判断
        //很简单 当前字符是否在字母的范围内 ，A-Z）：65 （A）~ 90（Z） 97（a） ~ 122（z）
        char[] chars = key.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }
}
