$('document').ready(function() {
	// Call form Edit
	$('.table #editButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href')
		console.log(href)
		$.get(href, function(supplier, status) {
			$('#idEdit').val(supplier.id);
			$('#nameEdit').val(supplier.name);
			$('#addressEdit').val(supplier.address);
			$('#cityEdit').val(supplier.city);
			$('#phoneEdit').val(supplier.phone);
			$('#mobileEdit').val(supplier.mobile);
			$('#websiteEdit').val(supplier.website);
			$('#emailEdit').val(supplier.email);
			$('#ddlStateDetails').val(supplier.stateid);
			$('#ddlCountryDetails').val(supplier.countryid);
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