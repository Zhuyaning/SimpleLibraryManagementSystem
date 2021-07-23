package com.zhu.bms.utils;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/6/25
 *   Time: 15:36
 */

public class MyThreadDemo implements Runnable {



    @Override
    public void run() {
        long before = System.currentTimeMillis();

        synchronized (this) {

        }

        long after = System.currentTimeMillis();
        System.out.println("耗费时间:" + (after - before) + "毫秒");
    }
}
