$('document').ready(function() {
	// Call form Edit
	$('.table #editButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href')
		console.log(href)
		$.get(href, function(employee, status) {
			$('#idEdit').val(employee.id);
			$('#dobEdit').val(employee.dateOfBirth);
			$('#usernameEdit').val(employee.username);
			$('#hireDateEdit').val(employee.hireDate);
			$('#ddlTitleEdit').val(employee.title);
			$('#ddlStateEdit').val(employee.stateid);
			$('#intialsEdit').val(employee.initials);
			$('#cityEdit').val(employee.city);
			$('#socialsecurityEdit').val(employee.socialSecurityNumber);
			$('#phoneEdit').val(employee.phone);
			$('#firstNameEdit').val(employee.firstname);
			$('#mobileEdit').val(employee.mobile);
			$('#lastNameEdit').val(employee.lastname);
			$('#ddlMaritalStatusEdit').val(employee.maritalStatus);
			$('#otherNameEdit').val(employee.othername);
			$('#emailEdit').val(employee.email);
			$('#ddlGenderEdit').val(employee.gender);
			$('#ddlJobTitleEdit').val(employee.jobtitleid);
			$('#ddlCountryEdit').val(employee.countryid);
			$('#ddlEmployeeTypeEdit').val(employee.employeetypeid);
			$('#addressEdit').val(employee.address);
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

	$('.table #photoButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#photoModal #employeePhoto').attr('src', href);
		$('#photoModal').modal();
	});
})