package com.fleet.thieuduong.fleetapp.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fleet.thieuduong.fleetapp.models.Country;
import com.fleet.thieuduong.fleetapp.services.CountryService;

@Controller
public class CountryController {
	@Autowired
	private CountryService countryService;

	@GetMapping("/countries")
	public String getCountries(Model model) {
		System.out.println(countryService.getColumnName());
		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countries", countryList);
		return "Country";
	}

	@PostMapping("/countries/addNew")
	public String addNewCountry(Country country) {
		countryService.saveCountry(country);
		return "redirect:/countries";
	}

	@RequestMapping("/countries/findById")
	@ResponseBody
	public Optional<Country> getCountryById(int id) {
		return countryService.getCountryById(id);
	}

	@RequestMapping(value = "/countries/edit", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateCountry(Country country) {
		countryService.saveCountry(country);
		return "redirect:/countries";
	}

	@RequestMapping(value = "/countries/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteCountry(int id) {
		countryService.deleteCountry(id);
		return "redirect:/countries";
	}

	@GetMapping("/countries/exportToExcel")
	public String exportCountriesToExcel(Model model) throws IOException {
		DateTimeFormatter datetimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		LocalDateTime dateTimeNow = LocalDateTime.now();

		Workbook workbook = new XSSFWorkbook();

		// Create sheet name "Countries"
		Sheet sheet = workbook.createSheet("Countries");

		// Create column
		for (int i = 0; i < countryService.countCountryColumn() - 1; i++) {
			sheet.setColumnWidth(i, 5000);
		}
//		sheet.setColumnWidth(0, 5000);
//		sheet.setColumnWidth(1, 5000);
//		sheet.setColumnWidth(2, 5000);
//		sheet.setColumnWidth(3, 5000);
//		sheet.setColumnWidth(4, 5000);
//		sheet.setColumnWidth(5, 5000);

		Row headerRow = sheet.createRow(0);

		// Format Header Style
		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headerStyle.setAlignment(HorizontalAlignment.CENTER);

		XSSFFont fontHeader = ((XSSFWorkbook) workbook).createFont();
		fontHeader.setFontName("Arial");
		fontHeader.setFontHeightInPoints((short) 14);
		headerStyle.setFont(fontHeader);

		// Tạo ra cell dòng 1 cột 1
		Cell headerCell00 = headerRow.createCell(0);
		headerCell00.setCellValue("ID");
		headerCell00.setCellStyle(headerStyle);

		// Tạo ra cell dòng 1 cột 2
		Cell headerCell01 = headerRow.createCell(1);
		headerCell01.setCellValue("Name");
		headerCell01.setCellStyle(headerStyle);

		// Tạo ra cell dòng 1 cột 3
		Cell headerCell02 = headerRow.createCell(2);
		headerCell02.setCellValue("Capital");
		headerCell02.setCellStyle(headerStyle);

		// Tạo ra cell dòng 1 cột 4
		Cell headerCell03 = headerRow.createCell(3);
		headerCell03.setCellValue("Code");
		headerCell03.setCellStyle(headerStyle);

		// Tạo ra cell dòng 1 cột 5
		Cell headerCell04 = headerRow.createCell(4);
		headerCell04.setCellValue("Continent");
		headerCell04.setCellStyle(headerStyle);

		// Tạo ra cell dòng 1 cột 6
		Cell headerCell05 = headerRow.createCell(5);
		headerCell05.setCellValue("Nationality");
		headerCell05.setCellStyle(headerStyle);

		// Format Row Style
		CellStyle rowStyle = workbook.createCellStyle();
		rowStyle.setWrapText(true);
		rowStyle.setAlignment(HorizontalAlignment.CENTER);

		XSSFFont fontRow = ((XSSFWorkbook) workbook).createFont();
		fontRow.setFontName("Arial");
		fontRow.setFontHeightInPoints((short) 12);
		rowStyle.setFont(fontRow);

		// Import data to cell
		for (int i = 0; i < countryService.getCountries().size(); i++) {
			Row row = sheet.createRow(i + 1);

			// Country ID
			Cell cell = row.createCell(0);
			cell.setCellValue(countryService.getCountries().get(i).getId());
			cell.setCellStyle(rowStyle);

			// Country Name
			cell = row.createCell(1);
			cell.setCellValue(countryService.getCountries().get(i).getDescription());
			cell.setCellStyle(rowStyle);

			// Country Capital
			cell = row.createCell(2);
			cell.setCellValue(countryService.getCountries().get(i).getCapital());
			cell.setCellStyle(rowStyle);

			// Country Code
			cell = row.createCell(3);
			cell.setCellValue(countryService.getCountries().get(i).getCode());
			cell.setCellStyle(rowStyle);

			// Country Continent
			cell = row.createCell(4);
			cell.setCellValue(countryService.getCountries().get(i).getContinent());
			cell.setCellStyle(rowStyle);

			// Country Nationality
			cell = row.createCell(5);
			cell.setCellValue(countryService.getCountries().get(i).getNationality());
			cell.setCellStyle(rowStyle);
		}

		File currDir = new File("\\F:\\FleetApp_Excel_Export\\Country_Export\\");
		System.out.println("current direction: " + currDir);
		String path = currDir.getAbsolutePath();
		String fileLocation = path.substring(0, path.length()) + "\\Country_Export_"
				+ datetimeFormat.format(dateTimeNow) + ".xlsx";
		System.out.println("fileLocation: " + fileLocation);

		FileOutputStream outputStream = new FileOutputStream(fileLocation);
		workbook.write(outputStream);
		workbook.close();

		return "redirect:/countries";
	}

}
