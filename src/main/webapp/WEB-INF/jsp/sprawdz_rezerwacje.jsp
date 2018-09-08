<%@ page import="booking.application.Rooms" %>
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
            <li><a href="aktualnosci.html">Aktualności</a></li>
            <li><a href="galeria.html">Galeria</a></li>
            <li><a href="cennik.html">Cennik</a></li>
            <li><a href="rezerwuj.html">Rezerwacja</a></li>
            <li><a href="kontakt.html">Kontakt</a></li>

        </ul>
    </nav>
    <aside>
        <ul>
            <li><a href="logowanie.html">Zaloguj</a></li>
            <li><a href="rejestracja.html">Zarejestruj się</a></li>
        </ul>
    </aside>
    <article>
        <h2>Dostepne pokoje</h2>
        <%Iterable<Rooms> pokoje = (Iterable<Rooms>)request.getAttribute("pokoje");
            for (Rooms pokoj: pokoje)        {
        %>
            <h1>Numer <%=pokoj.getIdRoom()%></h1>
            <p>Typ <%=pokoj.getRoomType()%></p>
            <p>Czy moga byc zwierzeta <%=pokoj.getAnimals()%></p>
            <p>Balkon <%=pokoj.getBalcone()%></p>
            <p>Pietro <%=pokoj.getFloor()%></p>

            <%}%>
    </article>

    <footer>Copyright &copy Michal Senkowicz</footer>
</div>
</body>
</html>