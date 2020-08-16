$('document').ready(function() {
	// Call form Edit
	$('.table #editButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href')
		console.log(href)
		$.get(href, function(invoice, status) {
			$('#idEdit').val(invoice.id);
			$('#invoiceDateEdit').val(invoice.invoiceDate);
			$('#remarksEdit').val(invoice.remarks);
			$('#statusEdit').val(invoice.invoicestatusid);
			$('#clientEdit').val(invoice.clientid);
		});
		$('#editModal').modal();
	});

	// Call alert Delete
	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href')
		$('#confirmDeleteButton').attr('href', href)
		$('#deleteModal').modal();
	});
})