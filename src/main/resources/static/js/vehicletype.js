$('document').ready(function() {
	// Call form Edit
	$('.table #editButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href')
		console.log(href)
		$.get(href, function(vehicletype, status) {
			$('#idEdit').val(vehicletype.id);
			$('#descriptionEdit').val(vehicletype.description);
			$('#detailsEdit').val(vehicletype.details);
		});
		$('#editModal').modal();
	});
	
	// Call details
	$('.table #detailsButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href')
		console.log(href)
		$.get(href, function(vehicletype, status) {
			$('#idDetails').val(vehicletype.id);
			$('#descriptionDetails').val(vehicletype.description);
			$('#detailsDetails').val(vehicletype.details);
			$('#createDateDetails').val(vehicletype.createdDate);
			$('#createByDetails').val(vehicletype.createdBy);
			$('#lastModifiedDateDetails').val(vehicletype.lastModifiedDate);
			$('#lastModifiedByDetails').val(vehicletype.lastModifiedBy);
		});
		$('#detailsModal').modal();
	});

	// Call alert Delete
	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href')
		$('#confirmDeleteButton').attr('href', href)
		$('#deleteModal').modal();
	});
})