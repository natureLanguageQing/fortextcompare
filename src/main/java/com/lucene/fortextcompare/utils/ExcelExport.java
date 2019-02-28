package com.lucene.fortextcompare.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

//easyExcel导出
public class ExcelExport {
    public static void main(String[] args) throws IOException {
        ExcelExport excelExport = new ExcelExport();
        excelExport.writeV2007();
    }

    public void writeV2007() throws IOException {
        OutputStream out = new FileOutputStream("2007.xlsx");
        ExcelWriter writer = EasyExcelFactory.getWriter(out);
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet1 = new Sheet(1, 3);
        sheet1.setSheetName("第一个sheet");
        //设置列宽 设置每列的宽度
        Map<Integer, Integer> columnWidth = new HashMap<>();
        columnWidth.put(0, 10000);
        columnWidth.put(1, 40000);
        columnWidth.put(2, 10000);
        columnWidth.put(3, 10000);
        sheet1.setColumnWidthMap(columnWidth);
        writer.finish();
        out.close();

    }


}
