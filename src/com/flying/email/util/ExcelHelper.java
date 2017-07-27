package com.flying.email.util;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * auth:flying date:2017年7月25日
 **/
public class ExcelHelper {

	/**
	 * 将Resultset的内容导入Excel
	 * 
	 * @param resultSet
	 * @param filename
	 * @return
	 */
	public static boolean ResultSetToExcel(ResultSet resultSet, String filename) {
		boolean flag = false;
		WritableWorkbook writableWorkbook = null;
		WritableSheet writableSheet = null;
		Label label = null;
		try {
			//// 创建Excel表
			writableWorkbook = Workbook.createWorkbook(new File(filename));
			//// 创建Excel表里面的Sheet
			writableSheet = writableWorkbook.createSheet("First Sheet", 0);
			//// 向Excel中添加数据
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			String columnName = null;
			int row = 0;
			for (int i = 0; i < columnCount; i++) {
				columnName = resultSetMetaData.getColumnName(i + 1);
				label = new Label(i, row, columnName);
				writableSheet.addCell(label);
			}

			//// 标题写第一行
			row++;

			while (resultSet.next()) {
				for (int i = 0; i < columnCount; i++) {
					label = new Label(i, row, resultSet.getString(i + 1));
					writableSheet.addCell(label);
				}

				//// 下一次应该写的数据行
				row++;
			}
			writableWorkbook.write();
			flag = true;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				writableWorkbook.close();
				return flag;
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return flag;
	}
}
