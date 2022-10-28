package com.whx.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author WhitehatXiao
 * @date 2022/10/4
 * @descriptions
 */
public class WebUtils {

    public static <T> T copyParamToBean(Map map , T bean){

        try {
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseStringToInteger(String reqString , int defalutValue){
        try {
            return Integer.parseInt(reqString);
        } catch (NumberFormatException e) {
            // e.printStackTrace();
        }
        return defalutValue;

    }

}
