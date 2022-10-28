package com.whx.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author WhitehatXiao
 * @date 2022/9/25
 * @descriptions 如果不使用BeanUtils来封装，当一次提交的参数过多并且还需要封装到 Bean/pojo对象中是，是
 * 极其麻烦的，何不如使用BeanUtils来直接封装呢；
 *
 *    用  WebUtils 封装 BeanUtils 使用
 */
public class WebUtils {

    /**
     * 把 Map 中的值注入到对应的 JavaBean 属性中。
     * @param value
     * @param bean
     *
     *  当时课上还讲， 为什么不直接把   HttpServletRequest 对象传入到 copyParamToBean( HttpServletRequest req)
         而是把 Map value 呢；
            其实是考虑到了 JAva EE 三层结构，这样可以让这个方法与 web 层解耦，使得 Service 和 Dao 层也能够使用
     */

    public static <T> T copyParamToBean( Map value , T bean ){
        try {
            System.out.println("注入之前：" + bean);
/**
 * 把所有请求的参数都注入到 user 对象中
 */
            BeanUtils.populate(bean, value);
            System.out.println("注入之后：" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     *  将字符串转化为int类型
     * @param strInt
     * @param defaultValue
     * @return 如果抛出异常，则放回默认值
     */
    public static int parseInt(String strInt , int defaultValue){

        try {
            return  Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
            // e.printStackTrace();
        }
        return defaultValue;

    }
}

