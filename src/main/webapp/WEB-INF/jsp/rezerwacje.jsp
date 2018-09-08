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
        <h2>Formularz rezerwacji</h2>
        <form action="/sprawdz_rezerwacje">
            Data przyjazdu: <input type="date" name="data_przyjazdu" id="wyjazd"><br>
            Data wyjazdu <input type="date" name="data_wyjazdu" ><br>
            Ilosc Osob <input type="number" name="ilosc_osob"><br>
            <input type="submit" value="Sprawdz Rezerwacje"><br>
        </form>

    </article>

    <footer>Copyright &copy Michal Senkowicz</footer>
</div>
</body>
</html>