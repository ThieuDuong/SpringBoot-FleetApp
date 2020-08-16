$('document').ready(function() {
	// Call form Edit
	$('.table #editButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href')
		console.log(href)
		$.get(href, function(vehiclemaintenance, status) {
			$('#idEdit').val(vehiclemaintenance.id);
			$('#ddlVehicleEdit').val(vehiclemaintenance.vehicleid);
			$('#ddlSupplierDetails').val(vehiclemaintenance.supplierid);
			$('#startDateEdit').val(vehiclemaintenance.startDate);
			$('#endDateEdit').val(vehiclemaintenance.endDate);
			$('#priceEdit').val(vehiclemaintenance.price);
			$('#remarksEdit').val(vehiclemaintenance.remarks);
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