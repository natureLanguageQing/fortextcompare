package com.lucene.fortextcompare.utils;

import org.jsoup.Jsoup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileToString {

    public static String getFile(String path) {
        File file = new File(path);
        return txt2String(file);

    }

    public static String[] getFile(String path, String second) {
        File file = new File(path);
        String s = txt2String(file);
        s = Jsoup.parse(s.replace("&nbsp;", "")).body().text();
        return s.split(second);

    }

    private static String txt2String(File file) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator()).append(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
