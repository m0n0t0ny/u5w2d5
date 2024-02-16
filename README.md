## Introduzione
Questo progetto è un'applicazione web sviluppata con Spring Boot, che gestisce dispositivi e dipendenti di un'azienda. L'applicazione offre funzionalità per aggiungere, visualizzare, aggiornare e eliminare dispositivi e dipendenti. Utilizza anche Cloudinary per gestire e memorizzare le immagini del profilo dei dipendenti.

## Configurazione del Server
Il pacchetto antoniobertuccio.u5w2d5.config contiene la classe ServerConfig che configura e inizializza il bean Cloudinary per gestire il caricamento delle immagini.

## Controller dei Dispositivi
Il pacchetto antoniobertuccio.u5w2d5.controllers contiene la classe DeviceController, che gestisce le richieste relative ai dispositivi.

## Endpoint dei Dispositivi
POST /device: Crea un nuovo dispositivo.
GET /device: Restituisce tutti i dispositivi o i dispositivi associati a un dipendente specifico.
GET /device/{deviceId}: Restituisce un dispositivo con l'ID specificato.
PUT /device/{deviceId}: Aggiorna un dispositivo esistente.
DELETE /device/{deviceId}: Elimina un dispositivo esistente.

## Controller dei Dipendenti
Il pacchetto antoniobertuccio.u5w2d5.controllers contiene la classe EmployeeController, che gestisce le richieste relative ai dipendenti.

## Endpoint dei Dipendenti
POST /employees: Crea un nuovo dipendente.
GET /employees: Restituisce tutti i dipendenti.
GET /employees/{employeeId}: Restituisce un dipendente con l'ID specificato.
PUT /employees/{employeeId}: Aggiorna un dipendente esistente.
DELETE /employees/{employeeId}: Elimina un dipendente esistente.
PATCH /employees/{employeeId}/profilePic: Carica un'immagine del profilo per il dipendente specificato.

## Entità
Il pacchetto antoniobertuccio.u5w2d5.entities contiene le classi Device e Employee, che rappresentano rispettivamente i dispositivi e i dipendenti.

## Gestione delle Eccezioni
Il pacchetto antoniobertuccio.u5w2d5.exceptions contiene le classi di eccezione personalizzate per gestire situazioni anomale durante l'esecuzione dell'applicazione.

## Payloads
Il pacchetto antoniobertuccio.u5w2d5.payloads contiene le classi utilizzate per trasferire dati tra il client e il server.

## Repository
Il pacchetto antoniobertuccio.u5w2d5.repositories contiene le interfacce di repository per l'accesso ai dati relativi ai dispositivi e ai dipendenti.

## Servizi
Il pacchetto antoniobertuccio.u5w2d5.services contiene le classi di servizio che gestiscono la logica di business dell'applicazione.
