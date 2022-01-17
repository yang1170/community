package com.newcoder.community.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CommunityUtil {
//    生成随机字符串
//    提供上传的随机的名字
    public static String generateUUid(){
        return UUID.randomUUID().toString().replace("-","");

    }
//    加密算法
//    加密只是加密 没法解密 加上随机的字符串
    public static String md5(String key){
        if (StringUtils.isBlank(key)){
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());

    }
    //封装json工具
    public static String getJSONString(int code, String msg, Map<String,Object> map){
        JSONObject jsonObject=new JSONObject();
//        传入的参数传入到json
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
//        把map里的值打散 然后才加入到json里
        if(map != null){
            for(String key : map.keySet()){
                jsonObject.put(key,map.get(key));
            }
        }
//        、转成字符串
        return jsonObject.toJSONString();
    }

    //重载json工具
    public static String getJSONString(int code, String msg){
        return getJSONString(code,msg,null);
    }

    //重载json工具
    public static String getJSONString(int code){
        return getJSONString(code,null,null);
    }

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age",25);
        System.out.println(getJSONString(0,"ok",map));

    }

}
