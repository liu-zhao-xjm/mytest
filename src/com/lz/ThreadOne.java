package com.lz;

/**
 * Runnable 线程
 */
public class ThreadOne implements Runnable {

    @Override
    public void run() {
        System.out.println("线程执行");
        for (int i=0;i<10;i++){
            try {
                Thread.sleep(500);
            }catch (InterruptedException e) {
                e.printStackTrace();

            }
            System.out.println(Thread.currentThread().getName()+"循环下标"+i);
        }
    }
    public static void main(String[] args) {
        ThreadOne threadOne=new ThreadOne();
        Thread thread1=new Thread(threadOne+"线程A");
        Thread thread2=new Thread(threadOne+"线程B");
        Thread thread3=new Thread(threadOne+"线程C");
        Thread thread4=new Thread(threadOne+"线程D");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
