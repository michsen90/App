<!DOCTYPE html>
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
       	<h2>Lista rezerwacji</h2>
		Rezerwacja<br>
		<input class="form-control" id="myInput" type="text" placeholder="Szukaj...">
		<br>
		<table>
       	
       			
       			<thead>
       				<th>Data rozpoczecia rezerwacji: </th>
       				<th>Data zakonczenia rezerwacji: </th>
       				<th>Numer pokoju: </th>
       				<th>Imie klienta: </th>
       				<th>Nazwisko klienta: </th>
       			</thead>
       			<%
       		Iterable<Reservations> reservations = (Iterable<Reservations>)request.getAttribute("reservation");
       		for(Reservations r: reservations) { %>
       			<tbody id="myTable">
       				<tr>
       				<td><%=r.getStartDate() %></td>
       				<td><%=r.getFinishDate() %></td>
       				<td><%=r.getRoom().getIdRoom() %></td>
       				<td><%=r.getClient().getFirstname() %></td>
       				<td><%=r.getClient().getLastname() %></td>
       				</tr>
       			</tbody>
       		<%}
       	%>
        </table>
  	<script>
  	$(document).ready(function(){
  	  $("#myInput").on("keyup", function() {
  	    var value = $(this).val().toLowerCase();
  	    $("#myTable tr").filter(function() {
  	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
  	    });
  	  });
  	});
  	</script>
  	   
       
    </article>

   
</div>
</body>
</html>