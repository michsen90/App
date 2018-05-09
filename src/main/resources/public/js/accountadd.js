$( document ).ready(function(){

	//submit form
	$("#accountForm").submit(function(event){
		
		//prevent the form
		event.preventDefault();
		
		makeRequest();
	});
	
	function makeRequest(){
		var search = window.location.search;
		var id = search.split('=')[1];
		alert(id);
		var formData = {
				login : $("#login").val(),
				password : $("#password").val(),
				client : {
					firstname : 'dsadasd',
					lastname : 'sdasdadsa',
					email : 'dsadas@o2.pl',
					city : 'dsaddasd',
					street : 'dasda',
					number : '2',
					phone : '423423423'
				}

		}
		
		console.log(JSON.stringify(formData));
		$.ajax({
			type: "POST",
			contentType : "application/json",
			data : JSON.stringify(formData),
			url : "/accounts/saveAccount",
				success : function(result) {
				
					alert("OK");
				},
				error : function(e) {
					alert("Error!"+e)
					console.log("ERROR: ", e);
			}
		});
		
	}
	function resetData(){
		
		$("#login").val("");
		$("#password").val("");
	}
})