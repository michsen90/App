<!DOCTYPE html>
<%@page import="booking.application.Prices"%>

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
            
            <li><a href="aacounts">1. Zarzadzaj kontami</a></li>
        	<li><a href="arooms">2. Zarzadzaj pokojami</a></li>
        	<li><a href="areservations">3. Zarzadzaj rezerwacjami</a></li>

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
       	<h2>Pokoje:</h2>
       	
       	<a href="addingnewroom">Dodaj nowy pokoj</a>
       	
        <form action="aeditingRooms">
        <%
        	Iterable<Prices> prices = (Iterable<Prices>)request.getAttribute("rooms");
        	for (Prices p: prices){ %>
        		
        		
        		<p>
        			<input type="checkbox" name="id" value="<%=p.getIdPrice()%>">
        			
        			Typ pokoju <%=p.getRoom().getRoomType() %><br>
        			Balkon <%=p.getRoom().getBalcone()%><br>
        			Pietro <%=p.getRoom().getFloor() %><br>
        			Pokoj rodzinny <%=p.getRoom().getFamilyRoom() %><br>
        			Zwierzeta <%=p.getRoom().getAnimals() %><br>
        			Cena za dzien <%= p.getPricePerDay()%> PLN <br>
        			<br>
        		</p>
        		
        	
        	<%}
        %>
        	<input type="submit" value="Edytuj pokoj">
        </form>
        
        
        
    </article>

   
</div>
</body>
</html>