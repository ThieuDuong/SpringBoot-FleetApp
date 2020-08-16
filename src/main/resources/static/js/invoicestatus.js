$('document').ready(function() {
	// Call form Edit
	$('.table #editButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href')
		console.log(href)
		$.get(href, function(invoicestatus, status) {
			$('#idEdit').val(invoicestatus.id);
			$('#descriptionEdit').val(invoicestatus.description);
			$('#detailsEdit').val(invoicestatus.details);
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