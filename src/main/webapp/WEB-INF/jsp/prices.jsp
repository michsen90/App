<%@page import="booking.application.Prices"%>

<!DOCTYPE html>
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
            <li><a href="cennik">Cennik</a></li>
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
       <h1>Cennik :</h1>
		<% Iterable<Prices> p = (Iterable<Prices>)request.getAttribute("prices"); 
			for (Prices price: p) {
		%>
        <table>
        <p>
        	<tr>Pokój <%=price.getRoom().getRoomType()%></tr>
        	<tr>Cena <%=price.getPricePerDay()%></tr>       
		</p>
		</table>
		<%} %>
			
	
	</article>
</div>
</body>
</html>