$( document ).ready(function(){
	
	//submit form
	$("#clientForm").submit(function(event){
		
		//prevent the form
		event.preventDefault();
		
		makeRequest();
		window.location.href="http://localhost:8080/tworzeniekonta.html";
	});
	
	function makeRequest() {
		
		var formData = {
				firstname : $("#firstname").val(),
				lastname : $("#lastname").val(),
				email : $("#email").val(),
				city : $("#city").val(),
				street : $("#street").val(),
				number : $("#number").val(),
				phone : $("#phone").val()
		}
		console.log(JSON.stringify(formData));
		$.ajax({
			 type: "POST",
 			 contentType : "application/json",
 			 data : JSON.stringify(formData),
			 url: "/clients/saveClient",
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
		$("#firstname").val("");
		$("#lastname").val("");
		$("#email").val("");
		$("#city").val("");
		$("#street").val("");
		$("#number").val("");
		$("#phone").val("");
	}
	
})