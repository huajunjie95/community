package com.nowcoder.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

public class CommunityUtil {
    //生成随机字符串
    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    //MD5加密,在密码末尾加上随机字符串
    public static String md5(String key){
        if (StringUtils.isBlank(key)){

        }
        //将密码转换为16位字符串
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
