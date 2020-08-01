package com.lz;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadThree implements Callable<String> {


    @Override
    public String call() throws Exception {
        int sum=0;
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"----"+i);
            sum+=i;
        }
        int i=5/0;
        return "Callable"+String.valueOf(sum);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
    Callable callable=new ThreadThree();//创建一个线程对象
        FutureTask<Object> task=new FutureTask<Object>(callable);//包Callable 包装成一个未来任务对象
        Thread thread=new Thread(task);//把未来任务对象包装成一个线程对象
        thread.start();
        //获取线程返回值
        try{
            String str=(String)task.get();
            System.out.println(str);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
