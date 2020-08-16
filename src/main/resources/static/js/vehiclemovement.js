$('document').ready(function() {
	// Call form Edit
	$('.table #editButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href')
		console.log(href)
		$.get(href, function(vehiclemovment, status) {
			$('#idEdit').val(vehiclemovment.id);
			$('#ddlVehicleEdit').val(vehiclemovment.vehicleid);
			$('#ddlLocation1Edit').val(vehiclemovment.locationid1);
			$('#ddlLocation2Edit').val(vehiclemovment.locationid2);
			$('#startDateEdit').val(vehiclemovment.date1);
			$('#endDateEdit').val(vehiclemovment.date2);
			$('#remarksEdit').val(vehiclemovment.remarks);
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