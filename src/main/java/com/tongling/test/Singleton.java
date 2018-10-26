package com.tongling.test;

/**
 * 单例模式
 *
 * 在整个程序运行期间只有一个实例，任何外界代码都不能随意创建实例
 * getInstance()方法必须保证类的实例创建，且仅创建一次，返回一个唯一的实例
 *
 * Created by 张宝玉 on 2018/10/10.
 */
public class Singleton {
    //首先，必须有一个私有的静态变量来引用自己即将创建出来的单例
    private static Singleton instance = null;

    //其次，必须对自己的构造方法使用private进行私有化
    private Singleton() {

    }

    //最后，需要有一个共有的静态方法，这个方法负责创建唯一的实例，并且返回这个唯一的实例
    //必须考虑到多线程并发访问安全的控制
    public static Singleton getInstance() {
        //两步检查机制
        //首先第一步，多个线程过来的时候，先判断instance是否为null
        //如果为null再往下走
        if (instance == null){
            //这里进行多线程同步
            //同一时间，只有一个线程获取到Singleton Class对象的锁进行后续的代码
            //其他的线程都只能在原地等待
            synchronized(Singleton.class) {
                //只有第一个获取到锁的线程，进入到这里会发现instance是null
                //然后才会去创建这个单例
                //此后，线程哪怕走到这一步，也会发现instance已经不是null了
                //就不会反复创建一个单例
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
