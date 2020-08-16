$('document').ready(function() {
	// Call form Edit
	$('.table #editButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href')
		console.log(href)
		$.get(href, function(contact, status) {
			$('#idEdit').val(contact.id);
			$('#firstNameEdit').val(contact.firstname);
			$('#lastNameEdit').val(contact.lastname);
			$('#phoneEdit').val(contact.phone);
			$('#emailEdit').val(contact.email);
			$('#mobileEdit').val(contact.mobile);
			$('#remarksEdit').val(contact.remarks);
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