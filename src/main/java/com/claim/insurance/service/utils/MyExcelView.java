package com.claim.insurance.service.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class MyExcelView {

	public void writeToExcelFile(Map<String, Object> model, String fileWithPath) throws IOException {

		System.out.println(fileWithPath);
		// Create a Workbook
		Workbook workbook = new HSSFWorkbook();
		
		int totalSheets = (int) model.get("totalSheets");
		
		for (int i = 1; i <= totalSheets; i++) {
			// Variables required for the model
			String sheetName = (String) model.get(String.format("sheetname%d", i));

			List<String> headers = (List<String>) model.get("headers");
		
			List<List<String>> results = (List<List<String>>) model.get(String.format("results%d", i));

			// Construct excel doc
			HSSFSheet sheet = (HSSFSheet) workbook.createSheet(sheetName);
			sheet.setDefaultColumnWidth((short) 12);
			int currentRow = 0;
			short currentColumn = 0;

			// Style header
			HSSFCellStyle headerStyle = (HSSFCellStyle) workbook.createCellStyle();
			HSSFFont headerFont = (HSSFFont) workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor((short) 100);
			headerStyle.setFont(headerFont);

			// Fill header
			HSSFRow headerRow = sheet.createRow(currentRow);
			for (String header : headers) {
				HSSFRichTextString text = new HSSFRichTextString(header);
				HSSFCell cell = headerRow.createCell(currentColumn);
				cell.setCellStyle(headerStyle);
				cell.setCellValue(text);
				currentColumn++;
			}

			// Fill data records
			currentRow++; // exclude header
			for (List<String> result : results) {
				currentColumn = 0;
				HSSFRow row = sheet.createRow(currentRow);
				for (Object value : result) {// used to count number of columns
					HSSFCell cell = row.createCell(currentColumn);
					Optional<Object> data = Optional.ofNullable(value);
					cell.setCellValue(data.isPresent() ? data.get().toString() : "");
					currentColumn++;
				}
				currentRow++;
			}
		}
		// Still create a blank sheet, when there are no data to populate..
		if (totalSheets == 0) {
			// Construct excel doc
			HSSFSheet sheet = (HSSFSheet) workbook.createSheet("No Data Found");
			sheet.setDefaultColumnWidth((short) 12);
			int currentRow = 0;
			short currentColumn = 0;

			// Style header
			HSSFCellStyle headerStyle = (HSSFCellStyle) workbook.createCellStyle();
			HSSFFont headerFont = (HSSFFont) workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor((short) 100);
			headerStyle.setFont(headerFont);

			// Fill header
			HSSFRow headerRow = sheet.createRow(currentRow);
			List<String> headers = (List<String>) model.get("headers");
			for (String header : headers) {
				HSSFRichTextString text = new HSSFRichTextString(header);
				HSSFCell cell = headerRow.createCell(currentColumn);
				cell.setCellStyle(headerStyle);
				cell.setCellValue(text);
				currentColumn++;
			}
		}

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream(fileWithPath);
		workbook.write(fileOut);
		fileOut.close();

		// Closing the workbook
		workbook.close();
	}

}
