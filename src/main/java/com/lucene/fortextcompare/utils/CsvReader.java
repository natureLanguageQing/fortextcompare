package com.lucene.fortextcompare.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public List<String> csvRead(String path) {
        File csv = new File(path);  // CSV文件路径
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        String everyLine;
        List<String> allString = new ArrayList<>();
        try {
            if (br != null) {
                while ((line = br.readLine()) != null)  //读取到的内容给line变量
                {
                    everyLine = line;
                    allString.add(everyLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allString;
    }

    public String txtRead(String path) {
        File csv = new File(path);  // CSV文件路径
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        String everyLine;
        StringBuilder stringBuffer = new StringBuilder();
        try {
            if (br != null) {
                while ((line = br.readLine()) != null)  //读取到的内容给line变量
                {
                    everyLine = line;
                    stringBuffer.append(everyLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
