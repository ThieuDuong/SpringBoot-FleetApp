$('document').ready(function() {
	$('.table #editButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href')
		$.get(href, function(state, status) {
			$('#idEdit').val(state.id);
			$('#descriptionEdit').val(state.name);
			$('#ddlCountryEdit').val(state.countryid);
			$('#capitalEdit').val(state.capital);
			$('#codeEdit').val(state.code);
			$('#detailsEdit').val(state.details);
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