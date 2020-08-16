$('document').ready(function() {
	// Call form Edit
	$('.table #editButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href')
		console.log(href)
		$.get(href, function(client, status) {
			$('#idEdit').val(client.id);
			$('#nameEdit').val(client.name);
			$('#addressEdit').val(client.address);
			$('#cityEdit').val(client.city);
			$('#phoneEdit').val(client.phone);
			$('#mobileEdit').val(client.mobile);
			$('#websiteEdit').val(client.website);
			$('#emailEdit').val(client.email);
			$('#detailsEdit').val(client.details);
			$('#ddlStateEdit').val(client.stateid);
			$('#ddlCountryEdit').val(client.countryid);
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
