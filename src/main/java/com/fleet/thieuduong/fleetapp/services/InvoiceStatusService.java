package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.InvoiceStatus;
import com.fleet.thieuduong.fleetapp.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {
	@Autowired
	InvoiceStatusRepository invoiceStatusRepository;

	// Get all invoice status
	public List<InvoiceStatus> getInvoicesStatus() {
		return invoiceStatusRepository.findAll();
	}

	// New invoice
	public void saveInvoiceStatus(InvoiceStatus invoice) {
		invoiceStatusRepository.save(invoice);
	}

	// Get invoice by Id
	public Optional<InvoiceStatus> getInvoiceStatusById(int id) {
		return invoiceStatusRepository.findById(id);
	}

	// Delete invoice
	public void deleteInvoiceStatus(int id) {
		invoiceStatusRepository.deleteById(id);
	}

}
