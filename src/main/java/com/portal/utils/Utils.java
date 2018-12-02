package com.portal.utils;

public class Utils {
    public static boolean isEmpty(String s){
        if("".equals(s)||s==null||s.isEmpty()){
            return false;
        }
        return true;
    }

    public static boolean isNotEmpty(String s){
        if(!"".equals(s) && s!=null && s.length()>0){
            return true;
        }
        return false;
    }
}
