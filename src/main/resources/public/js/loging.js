
var login =  document.getElementById("login").value;
var password = document.getElementById("password").value;

function validate(){

	
	if (login = "" && password = ""){
		
		alert("uzupełnij login i hasło")
		return false;
	}else
		function checkExisting(){
		
		var xhttp = new XMLHttpRequest();
		xhttp.open("GET", "http://localhost:8080/accounts/findByLogin", true);
		xhttp.send();
		console.log(xhttp.response);
			
		
	}
	
}


