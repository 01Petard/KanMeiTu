package com.ixuea.courses.kaimeitu.util;

public class RegexUtil {
    /**
     * 手机号正则表达式
     */
    private static final String PHONE_REGEX = "^(13[0-9]|14[0-9]|15[0-9]|166|17[0-9]|18[0-9]|19[8|9])\\d{8}$";
    /**
     * 电子邮箱正则表达式
     */
    private static final String EMAIL_REGEX = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    /**
     * 判断手机号是否符合规范
     */
    public static boolean isPhone(String value) {return value.matches(PHONE_REGEX); }
    /**
     * 判断手机号是否符合规范
     */
    public static boolean isEmail(String value) {return value.matches(EMAIL_REGEX); }

}
