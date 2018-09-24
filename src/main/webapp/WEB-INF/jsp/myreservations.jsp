<!DOCTYPE html>

<%@page import="booking.application.Clients"%>
<%@page import="booking.application.Reservations"%>
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
        <h2>Twoje rezerwacje:</h2>
        
        
         <table>
        <thead>
        	<th>Data poczatku rezerwacji</th>
        	<th>Data konca rezerwacji</th>
        	<th>Typ pokoju</th>
        </thead>
        <%
        	Iterable<Reservations> reservations = (Iterable<Reservations>)request.getAttribute("reservations");
        	
        	for (Reservations r: reservations) {
        %>	
        <tbody>
        <tr>
        	<td> <%= r.getStartDate()%> </td>
        	<td> <%= r.getFinishDate()%> </td>
        	<td> <%= r.getRoom().getRoomType()%> </td>
        </tr>
        </tbody>
        
        <%} %>
        
        </table>
		
		
    </article>

   
</div>
</body>
</html>