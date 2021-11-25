package com.murx.xlsx;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXReader {

	public String[][] getUserInfo() throws IOException { // we can get the file path from properties file & class in future

		FileInputStream stream = new FileInputStream(".\\resources\\test_data\\Sample Test data for scripting.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int rowcount = sheet.getLastRowNum();
		int cellcount = sheet.getRow(0).getLastCellNum();
		String data[][] = new String[rowcount-1][cellcount-1];

		for (int i = 1; i < rowcount; i++) {

			for (int j = 1; j < cellcount; j++) {
				XSSFRow r = sheet.getRow(j);
				XSSFCell c = r.getCell(i);
				String value = dataFormatter(c);
				//System.out.println(value);
				data[i - 1][j-1] = value;
			}
		}
		
		return data;
	}

	public String dataFormatter(XSSFCell cell) {
		DataFormatter df = new DataFormatter();
		return df.formatCellValue(cell);
	}

	public static void main(String[] args) {
		try {
			String[][] reader = new XLSXReader().getUserInfo();
			System.out.println("reader.length---"+reader.length);
			for(int i=0;i<reader.length;i++) {
				for(int j=0;j<reader.length-1;j++) {
					System.out.print(reader[i][j]);
				}
				System.out.println();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
