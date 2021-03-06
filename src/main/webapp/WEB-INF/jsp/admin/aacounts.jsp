<!DOCTYPE html>
<%@page import="booking.application.Accounts"%>
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
       	<h2>Szczegoly kont uzytkownikow:</h2>
       	
       	<p><a href="aaccountdelete">Usun klienta</a></p>
       	<%
       		Iterable<Accounts> accounts = (Iterable<Accounts>)request.getAttribute("accounts");
       		for (Accounts a: accounts){
       	%>
        	<p>Klient: </p>
        		
        		
        		login: 	   <%=a.getLogin() %><br>
        		Id klienta:<%=a.getClient().getIdClient() %><br>
        		Imie:      <%=a.getClient().getFirstname() %><br>
        		Nazwisko : <%=a.getClient().getLastname() %><br>
        		E-mail:    <%=a.getClient().getEmail() %><br>
        		Miasto:    <%=a.getClient().getCity() %><br>
        		Ulica:     <%=a.getClient().getStreet() %><br>
        		Numer:     <%=a.getClient().getNumber() %><br>
        		Telefon:   <%=a.getClient().getPhone() %><br>
        	
        <%} %>
       	
       
    </article>

   
</div>
</body>
</html>