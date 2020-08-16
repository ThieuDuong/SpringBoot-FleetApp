$('document').ready(function() {
	// Call form Edit
	$('.table #editButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href')
		console.log(href)
		$.get(href, function(vehicle, status) {
			$('#idEdit').val(vehicle.id);
			$('#nameEdit').val(vehicle.name);
			$('#ddlVehicleTypeEdit').val(vehicle.vehicletypeid);
			$('#ddlVehicleMakeEdit').val(vehicle.vehiclemakeid);
			$('#ddlVehicleStatusEdit').val(vehicle.vehiclestatusid);
			$('#ddlVehicleModelEdit').val(vehicle.vehiclemodelid);
			$('#ddlEmployeeEdit').val(vehicle.employeeid);
			$('#vehicleNumberEdit').val(vehicle.vehicleNumber);
			$('#netWeightEdit').val(vehicle.netWeight);
			$('#registrationDateEdit').val(vehicle.registrationDate);
			$('#acquisitionDateEdit').val(vehicle.acquisitionDate);
			$('#descriptionEdit').val(vehicle.description);
			$('#powerEdit').val(vehicle.power);
			$('#fuelCapacityEdit').val(vehicle.fuelCapacity);
			$('#ddlLocationEdit').val(vehicle.locationid);
			$('#remarksEdit').val(vehicle.remarks);
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