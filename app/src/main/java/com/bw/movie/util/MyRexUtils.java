package com.bw.movie.util;

import java.util.regex.Pattern;

/**
 * @author mengxuan
 * @包名 com.bw.movie.util
 * @MengXuanmengxuan
 * @日期2020/4/24
 * @项目名Movie
 * @类名RexUtils
 **/
public class MyRexUtils {
    private static final class PrivateNetUtil {
        private static final MyRexUtils REX_UTILS = new MyRexUtils();
    }

    public static MyRexUtils getInstance() {
        return PrivateNetUtil.REX_UTILS;
    }
    public static boolean checkEmail(String email) {
        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
        return Pattern.matches(regex, email);
        //
    }

}
