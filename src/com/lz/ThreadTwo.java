package com.lz;

public class ThreadTwo extends Thread{
    @Override
    public void run() {
        System.out.println("线程抢资源");
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().getState());
        for (int i=0;i<10;i++){
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"循环下标"+i);

        }
    }

    public static void main(String[] args) throws  InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setPriority(10);
        ThreadTwo threadTwo=new ThreadTwo();
        threadTwo.setName("线程1");
        System.out.println("线程未启动");
        threadTwo.start();//线程启动
        for (int i=0;i<10;i++){
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+i);
        }
        System.out.println(threadTwo.getState());
        Thread.currentThread().sleep(500);
        threadTwo.stop();
        System.out.println(threadTwo.getState());
        System.out.println(Thread.currentThread().getName()+"优先级"+Thread.currentThread().getPriority());
    }
}
