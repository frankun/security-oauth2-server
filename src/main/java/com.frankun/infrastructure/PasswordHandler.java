package com.frankun.infrastructure;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * 2016/10/25
 *
 * 处理账号密码, 使用MD5加密
 *
 * @author frankun
 */
public abstract class PasswordHandler {

    private PasswordHandler(){
    }

    public static String md5(String password){
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        return encoder.encodePassword(password,null);
    }
}
