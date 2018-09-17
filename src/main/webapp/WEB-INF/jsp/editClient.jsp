<!DOCTYPE html>
<%@page import="booking.application.Clients"%>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="styles.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div>

    <header>
        <h1>Pensjonat</h1>
    </header>

    <nav>
        <ul>
            <li><a href="onas.html">O nas</a></li>
            <li><a href="aktualnosci.html">Aktualnosci</a></li>
            <li><a href="galeria.html">Galeria</a></li>
            <li><a href="cennik.html">Cennik</a></li>
            <li><a href="rezerwuj.html">Rezerwacja</a></li>
            <li><a href="kontakt.html">Kontakt</a></li>

        </ul>
    </nav>
    <aside>
        <ul>
            <li><a href="logowanie.html">Zaloguj</a></li>
            <li><a href="rejestracja.html">Zarejestruj sie</a></li>
            <li><a href="konto.html">Konto</a></li>
        </ul>
    </aside>
    <article>
        <h2>Uzupelnij dane: </h2>
        <% Clients c = (Clients)request.getAttribute("dane"); %>
        <form action="editClient">
        	<input type="hidden" name="id" id="id" value="<%=c.getIdClient()%>"><br>
			Imie: <input type="text" name="firstname" id="name" value="<%=c.getFirstname()%>"><br>
			Nazwisko: <input type="text" name="lastname" value="<%=c.getLastname()%>"><br>
			E-mail: <input type="email" name="email" value="<%=c.getEmail()%>"><br>
			Miasto: <input type="text" name="city" value="<%=c.getCity()%>"><br>
			Ulica: <input type="text" name="street" value="<%=c.getStreet()%>"><br>
			Numer lokalu: <input type="text" name="number" value="<%=c.getNumber()%>"><br>
			Telefon: <input type="text" name="phone" value="<%=c.getPhone()%>"><br>
			<button type="submit" value="editClient">Aktualizuj dane</button>
		</form>
	<div class="col-sm-7" id="postResultDiv">
</article>
       
        

    </article>

   
</div>
</body>
</html>