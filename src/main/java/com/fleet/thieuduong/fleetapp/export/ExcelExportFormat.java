package com.fleet.thieuduong.fleetapp.export;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.springframework.stereotype.Component;

@Component
public class ExcelExportFormat {
	public void formatHeaderCellStyle(XSSFCellStyle headerStyle, XSSFFont fontHeader) {
		headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headerStyle.setAlignment(HorizontalAlignment.CENTER);

		fontHeader.setFontName("Arial");
		fontHeader.setFontHeightInPoints((short) 14);
		headerStyle.setFont(fontHeader);
	}

	public void formatValueCellStyle(XSSFCellStyle rowStyle, XSSFFont fontRow) {
		rowStyle.setWrapText(true);
		rowStyle.setAlignment(HorizontalAlignment.CENTER);
		fontRow.setFontName("Arial");
		fontRow.setFontHeightInPoints((short) 12);
		rowStyle.setFont(fontRow);
	}

}
