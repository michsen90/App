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
        <h2>Twoje dane:</h2>
        
        <%
        	Clients c = (Clients)request.getAttribute("dane");
        	
        	String m = (String) request.getAttribute("message");
            if (m!=null) {
        %>
        		<h2><%=m %></h2>
        <%} %>
        <table>
        
        <p>
        
        <tr><br> Imie <%=c.getFirstname()%></tr> 
        <tr><br> Nazwisko <%=c.getLastname()%></tr>
        <tr><br> Email <%=c.getEmail()%></tr>
        <tr><br> Miasto <%=c.getCity()%></tr>
        <tr><br> Ulica <%=c.getStreet()%></tr> 
        <tr><br> Numer <%=c.getNumber()%></tr>
        <tr><br> Telefon <%=c.getPhone()%></tr>        
        </p>
        
        
        </table>
		
    </article>

   
</div>
</body>
</html>