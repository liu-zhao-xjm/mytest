package com.lz;

import java.io.*;

public class FileRW {
    public static void main(String[] args) {
        try {
            File file1=new File("D:\\new year Pojo\\TEST\\120.txt");
            FileReader in=new FileReader(file1);
            int i=-1;
           char []cr=new char[10];
            File file2=new File("D:\\new year Pojo\\TEST\\120.txt");
            FileWriter fileWriter=new FileWriter(file2);
            while ((i=in.read(cr)) !=-1){
               fileWriter.write(cr,0,i);
            }
            fileWriter.write("ok");
            fileWriter.close();
            in.close();
            System.out.println("读写完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
