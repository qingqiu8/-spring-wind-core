/**
 * Copyright (c) 2011-2014, hubin (jobob@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.framework.poi;

import org.apache.poi.ss.usermodel.Row;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Excel 工具类
 * </p>
 * 
 * @author creazier.huang
 * @Date 2016-01-15
 */
public class ExcelUtil {

	public void fullCell(Row row, Map<Integer, Object> rmap) {
		for (int i : rmap.keySet()) {
			if (rmap.get(i) == null) {
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

	public void setTitle(Row row, List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			row.createCell(i).setCellValue(list.get(i).toString());
		}
	}
}
