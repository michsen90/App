

$( document ).ready(function(){
	
	//submit form
	$("#clientForm").submit(function(event){
		
		//prevent the form
		event.preventDefault();
		
		var idClient = makeRequest();
		
		window.location.href="http://localhost:8080/tworzeniekonta.html?id=" + idClient;
	});
	
	function makeRequest() {
		var idClient;

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
									
					//alert(result);
					//alert(JSON.stringify(result));
					idClient = result['data']['idClient'];
					alert(idClient);
				},
				error : function(e) {
					alert("Error!"+e)
					console.log("ERROR: ", e);
				}
		});
		return idClient;
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