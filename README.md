# swApp

Questo progetto è un'applicazione a microservizi scritta in Spring. L'applicazione è composta da diversi microservizi, tra cui:

- **Frontend**: questo microservizio utilizza un container Nginx per l'esecuzione del codice che fa chiamate al backend. Il frontend fornisce l'interfaccia utente dell'applicazione.
- **Api Gateway**: questo microservizio riceve tutte le richieste e le reindirizza ai vari microservizi dell'applicazione. L'Api Gateway è il punto di accesso all'applicazione.
- **MongoDB**: questo microservizio è un container con MongoDB, che è il database utilizzato dall'applicazione.
- **Mongo Express**: questo microservizio è un container con Mongo Express, una interfaccia grafica utente per MongoDB.
- **Matcher**: questo microservizio si occupa di creare un vettore con tutti i possibili match degli annunci che vengono creati.
- **Registration**: questo microservizio si occupa di permettere la registrazione dell'utente interagendo con il db.
- **Ad service**: questo microservizio gestisce tutte le richieste di get e post per l'aggiunta e la lettura di annunci al servizio.

## Architettura dell'applicazione

L'applicazione a microservizi è stata progettata per essere scalabile, resiliente e facilmente manutenibile. L'architettura dell'applicazione è basata sul pattern di progettazione a microservizi, dove ogni microservizio è autonomo e interagisce con gli altri attraverso interfacce ben definite.

L'Api Gateway funge da interfaccia pubblica dell'applicazione e reindirizza le richieste ai microservizi corretti. Il frontend è responsabile della presentazione dell'interfaccia utente e utilizza il backend per eseguire le operazioni necessarie. Il backend, composto dai microservizi MongoDB e Mongo Express, gestisce l'archiviazione e l'accesso ai dati dell'applicazione.

