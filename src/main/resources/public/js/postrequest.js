

$( document ).ready(function(){
	
	//submit form
	$("#clientForm").submit(function(event){
		
		//prevent the form
		event.preventDefault();
		
		var idClient = makeRequest();
		
		
	});
	
	function makeRequest() {
		//var idClient;

		var formData = {
				login : $("#login").val(),
				password : $("#password").val(),
				client : {
					firstname : $("#firstname").val(),
					lastname : $("#lastname").val(),
					email : $("#email").val(),
					city : $("#city").val(),
					street : $("#street").val(),
					number : $("#number").val(),
					phone : $("#phone").val()
				}
		}
		console.log(JSON.stringify(formData));
		$.ajax({
			 type: "POST",
 			 contentType : "application/json",
 			 data : JSON.stringify(formData),
			 url: "/accounts/saveAccount",
				success : function(result) {
						
					alert("Done");
					window.location.href="http://localhost:8080/index.html";
				},
				error : function(e) {
					alert("Error!"+e)
					console.log("ERROR: ", e);
				}
		});
		//return idClient;
	}
	
	function resetData(){
		
		$("#firstname").val("");
		$("#lastname").val("");
		$("#email").val("");
		$("#city").val("");
		$("#street").val("");
		$("#number").val("");
		$("#phone").val("");
	}
	
})