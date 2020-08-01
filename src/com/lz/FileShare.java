package com.lz;

import org.junit.Test;

import java.io.*;

public class FileShare {
    /**
     * 文件分割
     * 将文件分割成若干个
     */
    //                    传递参数      源文件路径    文件大小   目标文件路径
    public static void segmentation(String src, int fileSize, String dest) {
        if ("".equals(src) || src == null || fileSize == -0 || "".equals(dest) || dest == null) {
            System.out.println("分割失败");
        }
        File srcFile = new File(src);//源文件
        long srcSize = srcFile.length();//文件的大小
        int destSize = 1024 * 1024 * fileSize;//目标文件大小
        int number = (int) (srcSize / destSize);
        number = srcSize % destSize == 0 ? number : number + 1;//分割后文件的数目

        String fileName = src.substring(src.lastIndexOf("\\"));//源文件名

        InputStream in = null;//输入字节流
        BufferedInputStream bis = null;//输入缓冲流
        byte[] bytes = new byte[1024 * 1024];//读取文件的大小为1Mb
        int len = -1;//每次读取的长度值
        try {
            in = new FileInputStream(srcFile);
            bis = new BufferedInputStream(in);
            for (int i = 0; i < number; i++) {

                String destName = dest + File.separator + fileName + "-" + i + ".dat";
                OutputStream out = new FileOutputStream(destName);
                BufferedOutputStream bos = new BufferedOutputStream(out);
                int count = 0;
                while ((len = bis.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);//把字节数据写入目标文件中
                    count += len;
                    if (count >= destSize) {
                        break;
                    }
                }
                bos.flush();//刷新
                bos.close();
                out.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) bis.close();
                if (in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件合并
     * 将文件分割成若干个
     */
    public static void merge(String destPath, String... srcPaths) {
        if (destPath == null || "".equals(destPath) || srcPaths == null) {
            System.out.println("合并失败");
        }
        for (String string : srcPaths) {
            if ("".equals(string) || string == null)
                System.out.println("合并失败");
        }
        //合并后的文件名
        String name = srcPaths[0].substring(srcPaths[0].lastIndexOf("\\"));
        String destName = name.substring(0, name.lastIndexOf("-"));
        destPath = destPath + destName;//合并后的文件路径

        File destFile = new File(destPath);//合并后的文件
        OutputStream out = null;
        BufferedOutputStream bos = null;
        try {
            out = new FileOutputStream(destFile);
            bos = new BufferedOutputStream(out);
            for (String src : srcPaths) {
                File srcFile = new File(src);
                InputStream in = new FileInputStream(srcFile);
                BufferedInputStream bis = new BufferedInputStream(in);
                byte[] bytes = new byte[1024 * 1024];
                int len = -1;
                while ((len = bis.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);
                }
                bis.close();
                in.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (bos != null) bos.close();
                if (out != null) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试 分割
     */
    @Test
    public void segmentationTest() {

        String src = "E:\\新建文件夹\\Dying.Light.The.Following.Enhanced.Edition.v1.15.0.CHS.5.2\\Data0.pak";//要分割的大文件
        int fileSize = 10;
        String dest = "E:\\新建文件夹\\Dying.Light.The.Following.Enhanced.Edition.v1.15.0.CHS.5.2";//文件分割后保存的路径
        System.out.println("分割开始。。。");
        segmentation(src, fileSize, dest);
        System.out.println("分割完成");
    }

    @Test
    public void mergeTest() {
        //合并后文件的保存路径
        String destPath = "E:\\新建文件夹\\Dying.Light.The.Following.Enhanced.Edition.v1.15.0.CHS.5.2";
        //要合并的文件路径
        String[] srcPaths = {
                "E:\\新建文件夹\\Dying.Light.The.Following.Enhanced.Edition.v1.15.0.CHS.5.2\\Data0.pak-0.dat",
                "E:\\新建文件夹\\Dying.Light.The.Following.Enhanced.Edition.v1.15.0.CHS.5.2\\Data0.pak-1.dat",};
        System.out.println("开始合并。。。");
        merge(destPath, srcPaths);
        System.out.println("合并结束");
    }


}
