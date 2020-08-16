$('document').ready(function() {
	$('.table .btn-primary').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href')
		$.get(href, function(location, status) {
			$('#idEdit').val(location.id);
			$('#descriptionEdit').val(location.description);
			$('#ddlCountryDetailsEdit').val(location.countryid);
			$('#ddlStateDetailsEdit').val(location.stateid);
			$('#addressEdit').val(location.address);
			$('#cityEdit').val(location.city);
			$('#detailsEdit').val(location.details);
		});
		$('#editModal').modal();
	});
	
	//Call alert Delete
	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href')
		$('#confirmDeleteButton').attr('href', href)
		$('#deleteModal').modal();
	});
})