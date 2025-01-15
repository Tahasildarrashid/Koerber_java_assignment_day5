package src_assignment_day6.q1;

import java.io.*;
import java.util.*;

class FileUtil{
    public static List<String> readFiles(String fileName){
        List<String> files=new ArrayList<>();

        try(BufferedReader br=new BufferedReader(new FileReader(fileName))){
            String line=null;
            while ((line=br.readLine())!=null){
                files.add(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return files;
    }
}

class DownloadManager{
    public static void download(String url){
        System.out.println(Thread.currentThread().getName()+" has started to download "+ url);
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" has done downloading "+ url);
    }
}

class FileDownloadTask implements Runnable{
    private String url;
    public FileDownloadTask(String url) {
        this.url = url;
    }
    @Override
    public void run() {
        DownloadManager.download(url);
    }
}

public class Q1 {
    public static void main(String[] args) throws InterruptedException {
        List<String> urls=FileUtil.readFiles("C:\\Users\\rashid.tahasildar\\Desktop\\day5\\src_assignment_day6\\q1\\link.txt");

        for(String url: urls){
            DownloadManager.download(url);
        }

        for(String url: urls){
            FileDownloadTask downloadTask=new FileDownloadTask(url);
            Thread thread=new Thread(downloadTask);
            thread.start();
            thread.join();
        }
    }
}