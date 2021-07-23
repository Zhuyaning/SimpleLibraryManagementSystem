package com.zhu.bms.utils;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/6/25
 *   Time: 15:38
 */

public class MyThreadStarter {
    public static void main(String[] args) {

        MyThreadDemo myThreadDemo = new MyThreadDemo();

        Thread T1 = new Thread(myThreadDemo);
        Thread T2 = new Thread(myThreadDemo);
        Thread T3 = new Thread(myThreadDemo);
        Thread T4 = new Thread(myThreadDemo);

        T1.start();
//        T2.start();
//        T3.start();
//        T4.start();
        //耗费时间:8691毫秒   2
        //耗费时间:16814毫秒  4     耗费时间:17056毫秒
        //耗费时间:3341毫秒   1
    }
}
