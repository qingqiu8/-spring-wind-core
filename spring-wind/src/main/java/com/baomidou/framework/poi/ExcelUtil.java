package com.baomidou.framework.poi;

import org.apache.poi.ss.usermodel.Row;

import java.util.List;
import java.util.Map;

/**
 * Created by creazier.huang on 16/4/15.
 */
public class ExcelUtil {
    public void fullCell(Row row, Map<Integer,Object> rmap){
        for(int i:rmap.keySet()){
            if (rmap.get(i) == null){
                row.createCell(i).setCellValue("");
            } else if (rmap.get(i) instanceof String) {
                row.createCell(i).setCellValue((String) rmap.get(i));
            } else if (rmap.get(i) instanceof Integer) {
                row.createCell(i).setCellValue((Integer) rmap.get(i));
            } else if (rmap.get(i) instanceof Long) {
                row.createCell(i).setCellValue((Long) rmap.get(i));
            } else if (rmap.get(i) instanceof Double) {
                row.createCell(i).setCellValue((Double) rmap.get(i));
            } else if (rmap.get(i) instanceof Float) {
                row.createCell(i).setCellValue((Float) rmap.get(i));
            }
        }
    }

    public void setTitle(Row row,List<String> list){
        for(int i=0;i<list.size();i++){
            row.createCell(i).setCellValue(list.get(i).toString());
        }
    }
}
