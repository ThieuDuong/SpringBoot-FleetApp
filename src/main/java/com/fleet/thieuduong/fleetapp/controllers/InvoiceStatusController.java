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

import com.fleet.thieuduong.fleetapp.models.InvoiceStatus;
import com.fleet.thieuduong.fleetapp.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {
	@Autowired
	private InvoiceStatusService invoiceStatusService;

	@GetMapping("/invoicestatuses")
	public String getInvoiceStatuses(Model model) {
		model.addAttribute("invoicestatuses", invoiceStatusService.getInvoicesStatus());
		return "InvoiceStatus";
	}

	@PostMapping("/invoicestatus/addNew")
	public String addNewInvoiceStatus(InvoiceStatus invoiceStatus) {
		invoiceStatusService.saveInvoiceStatus(invoiceStatus);
		return "redirect:/invoicestatuses";
	}

	@RequestMapping("/invoicestatus/findById")
	@ResponseBody
	public Optional<InvoiceStatus> getInvoiceStatusById(int id) {
		return invoiceStatusService.getInvoiceStatusById(id);
	}

	@RequestMapping(value = "/invoicestatus/edit", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateInvoiceStatus(InvoiceStatus invoiceStatus) {
		invoiceStatusService.saveInvoiceStatus(invoiceStatus);
		return "redirect:/invoicestatuses";
	}

	@RequestMapping(value = "/invoicestatus/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteInvoiceStatus(int id) {
		invoiceStatusService.deleteInvoiceStatus(id);
		return "redirect:/invoicestatuses";
	}
}
