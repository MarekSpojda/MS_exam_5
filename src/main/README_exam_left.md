### Zadanie 3 (3 pkt)

1. Utwórz komponent `FileService`.
2. Utwórz w nim metodę `printDirectories(String path)`, która wyświetli na konsoli wszystkie katalogi ze ścieżki zadanej w parametrze `path`.
3. Wykorzystaj wyrażenia lambda w celu sprawdzania czy element jest katalogiem - możesz skorzystać z metody `isDirectory()` klasy `File`.


### Zadanie 4 (3 pkt)

W kontrolerze `Exam5Controller` napisz akcje akcje:
1. Dostępną pod adresem `/createCookie/{cookieName}/{cookieValue}/{cookieTime}` - 
 Ma ona nastawiać ciasteczko o podanej nazwie na podaną wartość. Ciasteczko ma żyć przez `cookieTime` minut.
2. Dostępną pod adresem `/deleteCookie/{cookieName}` - wyświetla zawartość ciasteczka o podanej nazwie i następnie je usuwa. 
Jeżeli takiego ciasteczka nie ma &ndash; powinien wyświetlać informację "Brak ciasteczka".
