package com.lucene.fortextcompare.utils;

import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLSentence;
import com.hankcs.hanlp.mining.word.WordInfo;
import com.hankcs.hanlp.seg.common.Term;
import com.miao.healthmanager.singleElection.SingleElection;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class CsvWrite {


    private static void closeOut(FileOutputStream out) {
        if (out != null) {
            try {
                out.close();
                out = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeOsw(OutputStreamWriter osw) {
        if (osw != null) {
            try {
                osw.close();
                osw = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeMethod(BufferedWriter bw) {
        if (bw != null) {
            try {
                bw.close();
                bw = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void allThirdTrain(LinkedHashMap<String, Integer> stringListHashMap, String s) {
        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            File finalCSVFile = new File(s);
            out = new FileOutputStream(finalCSVFile);
            osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            // 手动加上BOM标识
            osw.write(new String(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}));
            bw = new BufferedWriter(osw);
        /*
          往CSV中写新数据
         */
            String title;
            title = "特征,频次";
            bw.append(title).append("\r");
            if (stringListHashMap != null && !stringListHashMap.isEmpty()) {
                for (Map.Entry<String, Integer> entry : stringListHashMap.entrySet()) {
                    String word = entry.getKey();
                    Integer integer = entry.getValue();
                    if (StringUtils.isNotEmpty(word)) {
                        bw.append(word).append(",");
                        bw.append(integer.toString()).append(",");
                        bw.append("\r");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            closeMethod(bw);
            closeOsw(osw);
            closeOut(out);

        }
        System.out.println(s + "数据导出成功");
    }

    public static void wordVecTors(HashMap<String, Vector> vectors, String s) {
        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            File finalCSVFile = new File(s);
            out = new FileOutputStream(finalCSVFile);
            osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            // 手动加上BOM标识
            osw.write(new String(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}));
            bw = new BufferedWriter(osw);
        /*
          往CSV中写新数据
         */
            String title = "原文,向量";
            bw.append(title).append("\r");
            if (vectors != null && !vectors.isEmpty()) {
                for (Map.Entry<String, Vector> entry : vectors.entrySet()) {
                    String word = entry.getKey();
                    Vector integer = entry.getValue();
                    if (StringUtils.isNotEmpty(word)) {
                        bw.append(word).append(",");
                        bw.append(integer.toString()).append(",");
                        bw.append("\r");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            closeMethod(bw);
            closeOsw(osw);
            closeOut(out);

        }
        System.out.println(s + "数据导出成功");
    }

    /**
     * 分句信息保存 句向量转换中间值
     */
    public static void wordsTime(List<List<Term>> lists, String s) {
        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            File finalCSVFile = new File(s);
            out = new FileOutputStream(finalCSVFile);
            osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            // 手动加上BOM标识
            osw.write(new String(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}));
            bw = new BufferedWriter(osw);
        /*
          往CSV中写新数据
         */
            String title = "原文,分词";
            bw.append(title).append("\r");
            if (lists != null && !lists.isEmpty()) {
                for (List<Term> terms : lists) {

                    bw.append(terms.toString()).append(",");
                    for (Term term : terms) {
                        bw.append(term.word).append(" ");
                    }
                    bw.append(",");
                    for (Term term : terms) {
                        bw.append(term.nature.toString()).append(" ");
                    }
                    bw.append(",");
                    bw.append("\r");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            closeMethod(bw);
            closeOsw(osw);
            closeOut(out);

        }
        System.out.println(s + "数据导出成功");
    }

    public static void singleElectionList1(List<SingleElection> singleElectionList1, String s) {
        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            File finalCSVFile = new File(s);
            out = new FileOutputStream(finalCSVFile);
            osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            // 手动加上BOM标识
            osw.write(new String(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}));
            bw = new BufferedWriter(osw);
        /*
          往CSV中写新数据
         */
            String title = "题号,题干,备选答案,答案";

            bw.append(title).append("\r");
            if (singleElectionList1 != null && !singleElectionList1.isEmpty()) {
                for (SingleElection terms : singleElectionList1) {
                    bw.append(terms.getId()).append(",");
                    bw.append(terms.getMessage()).append(",");
                    bw.append(terms.getCandidateAnswers()).append(",");
                    bw.append(terms.getAnswer()).append(",");
                    bw.append("\r");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            closeMethod(bw);
            closeOsw(osw);
            closeOut(out);

        }
        System.out.println(s + "数据导出成功");
    }

    public static void coNLLSentenceTime(HashMap<String, CoNLLSentence> stringCoNLLSentenceHashMap, String s) {
        FileOutputStream out = null;

        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            File finalCSVFile = new File(s);
            out = new FileOutputStream(finalCSVFile);
            osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            // 手动加上BOM标识
            osw.write(new String(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}));
            bw = new BufferedWriter(osw);
        /*
          往CSV中写新数据
         */
            String title = "原文,分词";
            bw.append(title).append("\r");
            if (stringCoNLLSentenceHashMap != null && !stringCoNLLSentenceHashMap.isEmpty()) {
                for (Map.Entry<String, CoNLLSentence> entry : stringCoNLLSentenceHashMap.entrySet()) {
                    String s1 = entry.getKey();
                    CoNLLSentence value = entry.getValue();
                    s1 = s1.replace(",", "，");
                    bw.append(s1);
                    bw.append(",");
                    String s2 = value.toString();
                    String replace = s2.replace(",", "，");
                    bw.append(replace);
                    bw.append(",");
                    bw.append("\r");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            closeMethod(bw);
            closeOsw(osw);
            closeOut(out);

        }
        System.out.println(s + "数据导出成功");
    }

    public static void fileTOCsv(List<String> strings1, String name) {
        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            File finalCSVFile = new File(name);
            out = new FileOutputStream(finalCSVFile);
            osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            // 手动加上BOM标识
            osw.write(new String(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}));
            bw = new BufferedWriter(osw);
        /*
          往CSV中写新数据
         */
            String title = "题号,题干,备选答案,答案";

            bw.append(title).append("\r");
            if (strings1 != null && !strings1.isEmpty()) {
                for (String terms : strings1) {
                    terms=terms.replace(",","，");
                    bw.append(terms).append(",");
                    bw.append("\r");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            closeMethod(bw);
            closeOsw(osw);
            closeOut(out);

        }
        System.out.println(name + "数据导出成功");
    }

    public static void singleWordInfos(List<WordInfo> wordInfos, String name) {

        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            File finalCSVFile = new File(name);
            out = new FileOutputStream(finalCSVFile);
            osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            // 手动加上BOM标识
            osw.write(new String(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}));
            bw = new BufferedWriter(osw);
        /*
          往CSV中写新数据
         */
            String title = "新词,词频,互信息,信息熵";

            bw.append(title).append("\r");
            if (wordInfos != null && !wordInfos.isEmpty()) {
                for (WordInfo terms : wordInfos) {
                    bw.append(terms.text).append(",");
                    bw.append(""+ terms.frequency).append(",");
                    bw.append(""+ terms.aggregation).append(",");
                    bw.append(""+ terms.entropy);
                    bw.append("\r");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            closeMethod(bw);
            closeOsw(osw);
            closeOut(out);

        }
        System.out.println(name + "数据导出成功");

    }  public static void analyzerTime(List<Set<String>> analyzer, String s) {
        FileOutputStream out = null;

        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            File finalCSVFile = new File(s);
            out = new FileOutputStream(finalCSVFile);
            osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            // 手动加上BOM标识
            osw.write(new String(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}));
            bw = new BufferedWriter(osw);
        /*
          往CSV中写新数据
         */
            String title = "类别,原文";
            bw.append(title).append("\r");
            if (analyzer != null && !analyzer.isEmpty()) {
                for (int i = 0; i < analyzer.size(); i++) {
                    bw.append(String.valueOf(i));
                    bw.append(",");
                    Set<String> strings = analyzer.get(i);
                    for (String string : strings) {
                        string = string.replace(",", "，");
                        bw.append(string);
                        bw.append(",");

                    }
                    bw.append("\r");
                }



            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            closeMethod(bw);
            closeOsw(osw);
            closeOut(out);

        }
        System.out.println(s + "数据导出成功");
    }

    public static void hashMapToCsv(Map<String, List<String>> vectors, String s) {

        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            File finalCSVFile = new File(s);
            out = new FileOutputStream(finalCSVFile);
            osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            // 手动加上BOM标识
            osw.write(new String(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}));
            bw = new BufferedWriter(osw);
        /*
          往CSV中写新数据
         */
            String title = "原文,向量";
            bw.append(title).append("\r");
            if (vectors != null && !vectors.isEmpty()) {
                for (Map.Entry<String, List<String>> entry : vectors.entrySet()) {
                    String word = entry.getKey();
                    List<String> integer = entry.getValue();
                    if (StringUtils.isNotEmpty(word)) {
                        for (String s1 : integer) {
                            bw.append(word).append(",");
                            String replace = s1.replace(",", "，");
                            bw.append(replace).append(",");
                            bw.append("\r");
                        }

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            closeMethod(bw);
            closeOsw(osw);
            closeOut(out);

        }
        System.out.println(s + "数据导出成功");

    }



//    public static void writeMapDoubleWeight(HashMap<String, HashMap<String, FinalWeight>> scores, String s) {
//        FileOutputStream out = null;
//        OutputStreamWriter osw = null;
//        BufferedWriter bw = null;
//        try {
//            File finalCSVFile = new File(s);
//            out = new FileOutputStream(finalCSVFile);
//            osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
//            // 手动加上BOM标识
//            osw.write(new String(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}));
//            bw = new BufferedWriter(osw);
//        /*
//          往CSV中写新数据
//         */
//            String title;
//            title = "id,标题,信息,类型,网址";
//            bw.append(title).append("\r");
//            if (scores != null && !scores.isEmpty()) {
//                for (Map.Entry<String, HashMap<String, FinalWeight>> entry : scores.entrySet()) {
//                    String word = entry.getKey();
//                    HashMap<String, FinalWeight> integer = entry.getValue();
//                    if (StringUtils.isNotEmpty(word)) {
//                        String replace = word.replace(",", "，");
//                        if (StringUtils.isNotEmpty(replace)){
//                            bw.append(replace).append(",");
//                            bw.append(integer.getTime()+"").append(",");
//                            bw.append("\r");
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//            closeMethod(bw);
//            closeOsw(osw);
//            closeOut(out);
//
//        }
//        System.out.println(s + "数据导出成功");
//    }
}
