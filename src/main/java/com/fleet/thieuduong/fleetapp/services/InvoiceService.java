package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.Invoice;
import com.fleet.thieuduong.fleetapp.repositories.InvoiceRepository;

@Service
public class InvoiceService {
	@Autowired
	InvoiceRepository invoiceRepository;

	// Get all countries
	public List<Invoice> getInvoices() {
		return invoiceRepository.findAll();
	}

	// New Invoice
	public void saveInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
	}

	// Get Invoice by Id
	public Optional<Invoice> getInvoiceById(int id) {
		return invoiceRepository.findById(id);
	}

	// Delete Invoice
	public void deleteInvoice(int id) {
		invoiceRepository.deleteById(id);
	}
}
