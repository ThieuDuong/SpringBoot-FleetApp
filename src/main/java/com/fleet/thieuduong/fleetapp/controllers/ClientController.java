package com.fleet.thieuduong.fleetapp.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

import com.fleet.thieuduong.fleetapp.models.Client;
import com.fleet.thieuduong.fleetapp.services.ClientService;
import com.fleet.thieuduong.fleetapp.services.CountryService;
import com.fleet.thieuduong.fleetapp.services.StateService;

@Controller
public class ClientController {
	@Autowired
	private ClientService clientService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;

	@GetMapping("/clients")
	public String getclients(Model model) {
		model.addAttribute("clients", clientService.getClients());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		return "Client";
	}

	@PostMapping("/client/addNew")
	public String addNewClient(Client Client) {
		clientService.saveClient(Client);
		return "redirect:/clients";
	}

	@RequestMapping("/client/findById")
	@ResponseBody
	public Optional<Client> getClientById(int id) {
		return clientService.getClientById(id);
	}

	@RequestMapping(value = "/client/edit", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateClient(Client Client) {
		clientService.saveClient(Client);
		return "redirect:/clients";
	}

	@RequestMapping(value = "/client/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteClient(int id) {
		clientService.deleteClient(id);
		return "redirect:/clients";
	}

	@GetMapping("/clients/exportToExcel")
	public String exportCountriesToExcel(Model model) throws IOException {
		DateTimeFormatter datetimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		LocalDateTime dateTimeNow = LocalDateTime.now();

		Workbook workbook = new XSSFWorkbook();

		// Create sheet name "Countries"
		Sheet sheet = workbook.createSheet("Clients");

		// Create column
		sheet.setColumnWidth(0, 5000);
		sheet.setColumnWidth(1, 8000);
		sheet.setColumnWidth(2, 5000);
		sheet.setColumnWidth(3, 5000);
		sheet.setColumnWidth(4, 5000);
		sheet.setColumnWidth(5, 8000);
		sheet.setColumnWidth(6, 5000);
		sheet.setColumnWidth(7, 5000);
		sheet.setColumnWidth(8, 5000);
		sheet.setColumnWidth(9, 5000);
		sheet.setColumnWidth(10, 8000);

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
		headerCell01.setCellValue("Address");
		headerCell01.setCellStyle(headerStyle);

		// Tạo ra cell dòng 1 cột 3
		Cell headerCell02 = headerRow.createCell(2);
		headerCell02.setCellValue("City");
		headerCell02.setCellStyle(headerStyle);

		// Tạo ra cell dòng 1 cột 4
		Cell headerCell03 = headerRow.createCell(3);
		headerCell03.setCellValue("Country");
		headerCell03.setCellStyle(headerStyle);

		// Tạo ra cell dòng 1 cột 5
		Cell headerCell04 = headerRow.createCell(4);
		headerCell04.setCellValue("Details");
		headerCell04.setCellStyle(headerStyle);

		// Tạo ra cell dòng 1 cột 6
		Cell headerCell05 = headerRow.createCell(5);
		headerCell05.setCellValue("Email");
		headerCell05.setCellStyle(headerStyle);

		// Tạo ra cell dòng 1 cột 7
		Cell headerCell06 = headerRow.createCell(6);
		headerCell06.setCellValue("Mobile");
		headerCell06.setCellStyle(headerStyle);

		// Tạo ra cell dòng 1 cột 8
		Cell headerCell07 = headerRow.createCell(7);
		headerCell07.setCellValue("Name");
		headerCell07.setCellStyle(headerStyle);

		// Tạo ra cell dòng 1 cột 9
		Cell headerCell08 = headerRow.createCell(8);
		headerCell08.setCellValue("Phone");
		headerCell08.setCellStyle(headerStyle);

		// Tạo ra cell dòng 1 cột 10
		Cell headerCell09 = headerRow.createCell(9);
		headerCell09.setCellValue("State");
		headerCell09.setCellStyle(headerStyle);

		// Tạo ra cell dòng 1 cột 11
		Cell headerCell10 = headerRow.createCell(10);
		headerCell10.setCellValue("Website");
		headerCell10.setCellStyle(headerStyle);

		// Format Row Style
		CellStyle rowStyle = workbook.createCellStyle();
		rowStyle.setWrapText(true);
		rowStyle.setAlignment(HorizontalAlignment.CENTER);

		XSSFFont fontRow = ((XSSFWorkbook) workbook).createFont();
		fontRow.setFontName("Arial");
		fontRow.setFontHeightInPoints((short) 12);
		rowStyle.setFont(fontRow);

		// Import data to cell
		for (int i = 0; i < clientService.getClients().size(); i++) {
			Row row = sheet.createRow(i + 1);
			
			//Client ID
			Cell cell = row.createCell(0);
			cell.setCellValue(clientService.getClients().get(i).getId());
			cell.setCellStyle(rowStyle);

			//Client Address
			cell = row.createCell(1);
			cell.setCellValue(clientService.getClients().get(i).getAddress());
			cell.setCellStyle(rowStyle);

			//Client City
			cell = row.createCell(2);
			cell.setCellValue(clientService.getClients().get(i).getCity());
			cell.setCellStyle(rowStyle);

			//Client Country
			cell = row.createCell(3);
			cell.setCellValue(clientService.getClients().get(i).getCountry().getDescription());
			cell.setCellStyle(rowStyle);

			//Client Details
			cell = row.createCell(4);
			cell.setCellValue(clientService.getClients().get(i).getDetails());
			cell.setCellStyle(rowStyle);

			//Client Email
			cell = row.createCell(5);
			cell.setCellValue(clientService.getClients().get(i).getEmail());
			cell.setCellStyle(rowStyle);
			
			//Client Mobile
			cell = row.createCell(6);
			cell.setCellValue(clientService.getClients().get(i).getMobile());
			cell.setCellStyle(rowStyle);
			
			//Client Name
			cell = row.createCell(7);
			cell.setCellValue(clientService.getClients().get(i).getName());
			cell.setCellStyle(rowStyle);
			
			//Client Phone
			cell = row.createCell(8);
			cell.setCellValue(clientService.getClients().get(i).getPhone());
			cell.setCellStyle(rowStyle);
			
			//Client State
			cell = row.createCell(9);
			cell.setCellValue(clientService.getClients().get(i).getState().getName());
			cell.setCellStyle(rowStyle);
			
			//Client Website
			cell = row.createCell(10);
			cell.setCellValue(clientService.getClients().get(i).getWebsite());
			cell.setCellStyle(rowStyle);
		}

		File currDir = new File("\\F:\\FleetApp_Excel_Export\\Client_Export\\");
		String path = currDir.getAbsolutePath();
		String fileLocation = path.substring(0, path.length()) + "\\Client_Export_"
				+ datetimeFormat.format(dateTimeNow) + ".xlsx";
		FileOutputStream outputStream = new FileOutputStream(fileLocation);
		workbook.write(outputStream);
		workbook.close();

		return "redirect:/clients";
	}
}
