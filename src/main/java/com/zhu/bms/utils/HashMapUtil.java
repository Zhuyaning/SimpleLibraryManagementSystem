package com.zhu.bms.utils;

import java.util.HashMap;
import java.util.Map;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/6/17
 *   Time: 20:27
 */

public class HashMapUtil {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("001", "张曼玉");
        map.put("002", "小明");
        map.put("003", "小红");

        map.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

//        for (String key : map.keySet()) {
//            System.out.println(key + ":" + map.get(key));
//        }
    }
}
