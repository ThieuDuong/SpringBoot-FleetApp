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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fleet.thieuduong.fleetapp.export.ExcelExportFormat;
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

	@Autowired
	private ExcelExportFormat excelExportFormat;

	// Excel File Location
	public static final String currentDirection = "\\F:\\FleetApp_Excel_Export\\Client_Export\\";
	public static final String currentLocation = "\\Client_Export_";

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

		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create sheet name "Clients"
		XSSFSheet sheet = workbook.createSheet("Clients");

		// Format Header Style
		XSSFCellStyle headerStyle = workbook.createCellStyle();
		XSSFFont fontHeader = ((XSSFWorkbook) workbook).createFont();
		excelExportFormat.formatHeaderCellStyle(headerStyle, fontHeader);

		// Format Row Style
		XSSFCellStyle rowStyle = workbook.createCellStyle();
		XSSFFont fontRow = ((XSSFWorkbook) workbook).createFont();
		excelExportFormat.formatValueCellStyle(rowStyle, fontRow);

		// Create header row
		XSSFRow headerRow = sheet.createRow(0);
		int countColumnName = clientService.getColumnName().size();
		int sizeListClients = clientService.getClients().size();

		for (int i = 0; i < countColumnName; i++) {
			// Create column
			sheet.setColumnWidth(i, 5000);
			// Create header cell, set value and format this cell
			XSSFCell headerCell = headerRow.createCell(i);
			headerCell.setCellValue(clientService.getColumnName().get(i));
			headerCell.setCellStyle(headerStyle);
		}

		// Import data to cell
		for (int i = 0; i < sizeListClients; i++) {
			XSSFRow row = sheet.createRow(i + 1);

			XSSFCell cell = row.createCell(0);
			cell.setCellValue(clientService.getClients().get(i).getId());
			cell.setCellStyle(rowStyle);

			// Client Address
			cell = row.createCell(1);
			cell.setCellValue(clientService.getClients().get(i).getAddress());
			cell.setCellStyle(rowStyle);

			// Client City
			cell = row.createCell(2);
			cell.setCellValue(clientService.getClients().get(i).getCity());
			cell.setCellStyle(rowStyle);

			// Client Country
			cell = row.createCell(3);
			cell.setCellValue(clientService.getClients().get(i).getCountry().getDescription());
			cell.setCellStyle(rowStyle);

			// Client Details
			cell = row.createCell(4);
			cell.setCellValue(clientService.getClients().get(i).getDetails());
			cell.setCellStyle(rowStyle);

			// Client Email
			cell = row.createCell(5);
			cell.setCellValue(clientService.getClients().get(i).getEmail());
			cell.setCellStyle(rowStyle);

			// Client Mobile
			cell = row.createCell(6);
			cell.setCellValue(clientService.getClients().get(i).getMobile());
			cell.setCellStyle(rowStyle);

			// Client Name
			cell = row.createCell(7);
			cell.setCellValue(clientService.getClients().get(i).getName());
			cell.setCellStyle(rowStyle);

			// Client Phone
			cell = row.createCell(8);
			cell.setCellValue(clientService.getClients().get(i).getPhone());
			cell.setCellStyle(rowStyle);

			// Client State
			cell = row.createCell(9);
			cell.setCellValue(clientService.getClients().get(i).getState().getName());
			cell.setCellStyle(rowStyle);

			// Client Website
			cell = row.createCell(10);
			cell.setCellValue(clientService.getClients().get(i).getWebsite());
			cell.setCellStyle(rowStyle);
		}

		File currDir = new File(currentDirection);
		String path = currDir.getAbsolutePath();
		String fileLocation = path.substring(0, path.length()) + currentLocation + datetimeFormat.format(dateTimeNow)
				+ ".xlsx";
		FileOutputStream outputStream = new FileOutputStream(fileLocation);
		workbook.write(outputStream);
		workbook.close();

		return "redirect:/clients";
	}
}
