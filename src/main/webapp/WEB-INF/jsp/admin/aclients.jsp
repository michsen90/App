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
            <li><a href="cennik">Cennik</a></li>
            <li><a href="rezerwuj.html">Rezerwacja</a></li>
            <li><a href="kontakt.html">Kontakt</a></li>
            
            <li><a href="aclients">1. Zarzadzaj klientami</a></li>
        	<li><a href="aacounts">2. Zarzadzaj kontami</a></li>
        	<li><a href="arooms">3. Zarzadzaj pokojami</a></li>
        	<li><a href="areservations">4. Zarzadzaj rezerwacjami</a></li>

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
       	<h2>Klienci:</h2>
       	
        <%
        	Iterable<Clients> clients = (Iterable<Clients>)request.getAttribute("clients");
        	for (Clients c: clients){ 
        	
        	%>
        	
        	<p>
        		
        		Klient <br>
        		Id:		   <%=c.getIdClient() %>
        		Imie:      <%=c.getFirstname() %><br>
        		Nazwisko : <%=c.getLastname() %><br>
        		E-mail:    <%=c.getEmail() %><br>
        		Miasto:    <%=c.getCity() %><br>
        		Ulica:     <%=c.getStreet() %><br>
        		Numer:     <%=c.getNumber() %><br>
        		Telefon:   <%=c.getPhone() %><br>
        	</p>
        
        <%		
        	}
        %>
        
       	
       
    </article>

   
</div>
</body>
</html>