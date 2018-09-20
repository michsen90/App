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
       	<h2>Zarzadnie pokojami</h2>
        
        <%=request.getAttribute("m") %>
        
        <form action="aaddRoom">
        			Typ pokoju: <input type="text" name="type_room"><br>
      				Balkon: <input type="text" name="balcone"><br>
      				Pietro: <input type="text" name="floor"><br>
      				Pokoj rodzinny: <input type="text" name="family_room"> <br>
      				Zwierzeta: <input type="text" name="animals"><br>
      				Cena za dzien: <input type="text" name="price_per_day"><br>
      			<button type="submit" value="aaddRoom">Dodaj pokoj</button>
        </form>
        
    </article>

   
</div>
</body>
</html>