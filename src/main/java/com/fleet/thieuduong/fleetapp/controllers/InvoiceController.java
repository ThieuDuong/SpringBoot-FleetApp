package com.fleet.thieuduong.fleetapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fleet.thieuduong.fleetapp.models.Invoice;
import com.fleet.thieuduong.fleetapp.services.ClientService;
import com.fleet.thieuduong.fleetapp.services.InvoiceService;
import com.fleet.thieuduong.fleetapp.services.InvoiceStatusService;

@Controller
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	@Autowired
	private ClientService clientService;

	@GetMapping("/invoices")
	public String getInvoices(Model model) {
		model.addAttribute("invoices", invoiceService.getInvoices());
		model.addAttribute("statuses", invoiceStatusService.getInvoicesStatus());
		model.addAttribute("clients", clientService.getClients());
		return "Invoice";
	}

	@PostMapping("/invoice/addNew")
	public String addNewInvoice(Invoice Invoice) {
		invoiceService.saveInvoice(Invoice);
		return "redirect:/invoices";
	}
	
	@RequestMapping("/invoice/findById")
	@ResponseBody
	public Optional<Invoice> getInvoiceById(int id) {
		return invoiceService.getInvoiceById(id);
	}
	
	@RequestMapping(value="/invoice/edit", method= {RequestMethod.PUT, RequestMethod.GET})
	public String updateInvoice(Invoice Invoice){
		invoiceService.saveInvoice(Invoice);
		return "redirect:/invoices";
	}
	
	@RequestMapping(value="/invoice/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteInvoice(int id){
		invoiceService.deleteInvoice(id);
		return "redirect:/invoices";
	}
}
