# Assignment 1

## Descriere
Proiectati si implementati o aplicatie de vanzare a biletelor de avion. Aplicatia va avea doua tipuri de useri (clientul aplicatiei si un administrator), care vor avea nevoie de un username si o parola pentru a folosi aplicatia.

Clientul poate realiza urmatoarele actiuni:
- Cautarea in lista de zboruri disponibile (cautare doar dupa numarul zborului)
- Cumpararea / anularea unui bilet de avion
- Modificarea sumei de bani disponibila in cont

Administratorul poate realiza urmatoarele actiuni:
- CRUD pe informatiile clientilor (exceptand suma de bani disponibila in cont)
- CRUD pe zborurile disponibile
- Generarea unui raport (afisat in aplicatie) care contine numarul de bilete vandut de fiecare companie de zbor

## Constrangeri
- Aplicatia va fi implementata in Java/C# si va avea o structura layered.
- Datele vor fi stocate intr-o baza de date relationala. Nu folositi un framework ORM.
- Orice input de la utilizator trebuie validat.
- Use a domain logic pattern (transaction script or domain model) / a data source hybrid pattern (table module, active record) and a data source pure pattern (table data gateway, row data gateway, data mapper) most suitable for the application.

## Livrabile
- [Documentatie](./Assignment_Analysis_and_Design_Document.docx)
- Script SQL pentru crearea si popularea bazei de date cu valori initiale.
- Implementare, documentatie si script SQL commited&pushed pe GitHub (incremental, nu tot odata).

## Referinte
- Martin Fowler et. al, Patterns of Enterprise Application Architecture, Addison Wesley, 2003
- [Java Swing UI](https://docs.oracle.com/javase/tutorial/uiswing/)
- [JavaFx](https://docs.oracle.com/javase/8/javafx/get-started-tutorial/index.html)
- [Google](https://duckduckgo.com/)