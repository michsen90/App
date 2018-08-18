$(document).ready(function(){
	
	$('#login').on('blur', function(){
		var input = $(this);
		var name_length = input.val().length;
		if (name_length >= 6 && name_length <= 20){
			input.removeClass("invalid").addClass("valid");
			input.next('.komunikat').text("Ok").removeClass("blad").addClass("Ok");
			
		}
		else{
			input.removeClass("valid").addClass("invalid");
			input.next('.komunikat').text("Login musi mieć min 6 znaków, maks 20").removeClass("Ok").addClass("blad");
		}
	});
	$('#password').on('blur', function(){
		var input = $(this);
		var password_length = input.val().length;
		if (password_length >= 6 && password_length <= 20){
			input.removeClass("invalid").addClass("valid");
			input.next('.komunikat').text("Ok").removeClass("blad").addClass("Ok");
		}
		else{
			input.removeClass("valid").addClass("invalid");
			input.next('.komunikat').text("Hasło musi mieć od 6 do 20 znaków").removeClass("Ok").addClass("blad");
		}
	});
	
	
	
	
	$('#submitButton').click(function(){
		var login = $('#login').val();
		var password = $('#password').val();
		alert(login)
		alert(password)
		event.preventDefault();
		ajaxGet();
		
		
		
		/*$.get("/accounts/findByLogin?login=" + login);
		
		if (login.hasClass('valid') && password.hasClass('valid')){
			alert("działa");
		}
		else{
			alert("Uzupełnij wszystkie pola");
		}*/
		
	});
	
	/*function ajaxGet(){
		$.ajax({
			
			type: "GET",
			url: "/accounts/findByLogin",
			succes: function(result){
				if(result.status == "Done"){
					
				}
			}
			
		});
	}*/	
	
});










