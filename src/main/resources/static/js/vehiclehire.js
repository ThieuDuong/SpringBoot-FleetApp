$('document').ready(function() {
	// Call form Edit
	$('.table #editButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href')
		console.log(href)
		$.get(href, function(vehiclehire, status) {
			$('#idEdit').val(vehiclehire.id);
			$('#ddlVehicleEdit').val(vehiclehire.vehicleid);
			$('#ddlLocationEdit').val(vehiclehire.locationid);
			$('#ddlClientEdit').val(vehiclehire.clientid);
			$('#dateInEdit').val(vehiclehire.dateIn);
			$('#dateOutEdit').val(vehiclehire.dateOut);
			$('#timeInEdit').val(vehiclehire.timeIn);
			$('#timeOutEdit').val(vehiclehire.timeOut);
			$('#priceEdit').val(vehiclehire.price);
			$('#remarksEdit').val(vehiclehire.remarks);
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