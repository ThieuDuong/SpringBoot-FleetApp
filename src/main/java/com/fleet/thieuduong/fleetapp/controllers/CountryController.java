package com.fleet.thieuduong.fleetapp.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fleet.thieuduong.fleetapp.export.ExcelExportFormat;
import com.fleet.thieuduong.fleetapp.models.Country;
import com.fleet.thieuduong.fleetapp.services.CountryService;

@Controller
public class CountryController {
	@Autowired
	private CountryService countryService;

	@Autowired
	private ExcelExportFormat excelExportFormat;

	// Excel File Location
	public static final String currentDirection = "\\F:\\FleetApp_Excel_Export\\Country_Export\\";
	public static final String currentLocation = "\\Country_Export_";
	
	@GetMapping("/countries")
	public String getCountries(Model model, @RequestParam(defaultValue = "0") int page) {
		List<Country> countries = countryService.getCountries();
		Page<Country> countriesPagination = countryService.getCountriesPagination(page);
		long countriesTotal = countriesPagination.getTotalElements();
		model.addAttribute("countriesTotal", countriesTotal);
		model.addAttribute("countries", countries);
		model.addAttribute("countriesPagination", countriesPagination);
		model.addAttribute("currentPage",page);
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
	public String exportCountriesToExcel(Model model)
			throws IOException, IllegalArgumentException, IllegalAccessException {
		DateTimeFormatter datetimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		LocalDateTime dateTimeNow = LocalDateTime.now();

		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create sheet name "Countries"
		XSSFSheet sheet = workbook.createSheet("Countries");

		// Format Header Style
		XSSFCellStyle headerStyle = workbook.createCellStyle();
		XSSFFont fontHeader = ((XSSFWorkbook) workbook).createFont();
		excelExportFormat.formatHeaderCellStyle(headerStyle, fontHeader);

		// Format Row Style
		XSSFCellStyle rowStyle = workbook.createCellStyle();
		XSSFFont fontRow = ((XSSFWorkbook) workbook).createFont();
		excelExportFormat.formatValueCellStyle(rowStyle, fontRow);

		// Create header row
		
		List<Country> countryList = countryService.getCountries();
		List<String> countryColumnName = countryService.getColumnName();
		
		XSSFRow headerRow = sheet.createRow(0);
		int countColumnName = countryColumnName.size() - 1;
		int sizeListCountries = countryList.size();

		for (int i = 0; i < countColumnName; i++) {
			// Create column
			sheet.setColumnWidth(i, 5000);
			// Create header cell, set value and format this cell
			XSSFCell headerCell = headerRow.createCell(i);
			headerCell.setCellValue(countryColumnName.get(i));
			headerCell.setCellStyle(headerStyle);
		}

		// Create value cell, set value and format this cell
		for (int i = 0; i < sizeListCountries; i++) {
			XSSFRow row = sheet.createRow(i + 1);

			XSSFCell cell = row.createCell(0);
			cell.setCellValue(countryList.get(i).getId());
			cell.setCellStyle(rowStyle);

			cell = row.createCell(1);
			cell.setCellValue(countryList.get(i).getCapital());
			cell.setCellStyle(rowStyle);

			cell = row.createCell(2);
			cell.setCellValue(countryList.get(i).getCode());
			cell.setCellStyle(rowStyle);

			cell = row.createCell(3);
			cell.setCellValue(countryList.get(i).getContinent());
			cell.setCellStyle(rowStyle);

			cell = row.createCell(4);
			cell.setCellValue(countryList.get(i).getDescription());
			cell.setCellStyle(rowStyle);

			cell = row.createCell(5);
			cell.setCellValue(countryList.get(i).getNationality());
			cell.setCellStyle(rowStyle);
		}

		File exportDirection = new File(currentDirection);
		String path = exportDirection.getAbsolutePath();
		String fileLocation = path.substring(0, path.length()) + currentLocation + datetimeFormat.format(dateTimeNow)
				+ ".xlsx";
		FileOutputStream outputStream = new FileOutputStream(fileLocation);
		workbook.write(outputStream);
		workbook.close();

		return "redirect:/countries";
	}
}
