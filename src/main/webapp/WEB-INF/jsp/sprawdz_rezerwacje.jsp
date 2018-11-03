<%@ page import="booking.application.Rooms" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="styles.css"/>
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
        <h2>Dostepne pokoje</h2>
        <form action="/rezerwuj_pokoj">
            <%  Iterable<Rooms> pokoje = (Iterable<Rooms>)request.getAttribute("pokoje");
                for (Rooms pokoj: pokoje)        {
            %>
                    <p>
                    <input type="radio" name="pokoj" value="<%=pokoj.getIdRoom()%>">
                    Pokoj numer <%=pokoj.getIdRoom()%> <br>
                    Typ <%=pokoj.getRoomType()%><br>
                    Czy moga byc zwierzeta <%=pokoj.getAnimals()%><br>
                    Balkon <%=pokoj.getBalcone()%><br>
                    Pietro <%=pokoj.getFloor()%><br>
                    Maksymalna liczba osób do zakwaterowania: <%=pokoj.getPeopleCanBook() %>

                <%}%>
            <input type="submit" value="Rezerwuj">
        </form>
    </article>

    <footer>Copyright &copy Michal Senkowicz</footer>
</div>
</body>
</html>