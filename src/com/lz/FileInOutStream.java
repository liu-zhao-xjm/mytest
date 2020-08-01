package com.lz;

import java.io.*;

public class FileInOutStream {
    public static void main(String[] args) {
        try {
            File file1=new File("D:\\new year Pojo\\TEST\\120.txt");
            InputStream in=new FileInputStream(file1);
            int i=-1;
            /*byte[] b=new byte[1024];*/
            File file2=new File("D:\\new year Pojo\\TEST\\120.txt");
            OutputStream outputStream=new FileOutputStream(file2);
                while ((i=in.read()) !=-1){
                    outputStream.write(i);
                    outputStream.flush();
                }
                outputStream.close();
            System.out.println("读写完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
