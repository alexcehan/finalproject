package com.siit.finalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalprojectApplication.class, args);
    }

}

/**
 * Proiectul incearca sa simuleze oarecum un aeroport dar cu comportament mai degraba atipic, ca si cum toate biletele pentru toate cursele le vinde aeroportul ci nu o companie aeriana.
 *
 * Numele bazei de date este LRIA (LRIA este notatia ICAO a Aeroportului din Iasi) si contine 6 tabele dupa cum urmeaza:
 * - clients : aici se adauga toti pasagerii "creati", ca date de identificare am folosit doar prenume, nume si varsta. nu am pus nicio conditie de unicitate deoarece un client poate sa cumpere mai multe bilete si pentru alte zboruri
 *              - cele mai multe operatiuni CRUD sunt facute pe ClientRestController pentru ca in mod normal asta este si interesul clientilor.
 *              - am creat ceva de GET si in FLightRestController dar nu am dezvoltat prea mult, fiind mai putin important
 *
 * - destination - e un tabel cu informatii despre locul de destinatie (oras, tara, distanta, timp de zbor)
 *               - in tabela flights este setat un FK spre tabela asta
 *               - date din tabela asta sunt folosite si pentru validarea updateului sau calculare pretului biletului
 *
 * - ticket-type - contine 3 tipuri de bilete cu beneficii minime specificate la fiecare
 *               - tabela clients contine un FK spre tabela asta
 *               - in functie de tipul de bilet specificat aici este calculat pretul biletului
 *
 * - airplanes  - contine informatii despre avioanele cu care se zboara
 *              - tabela flights contine un FK spre tabela asta
 *              - numarul de bilete disponibile initiale pentru fiecare clasa la fiecare zbor sunt calculate pe baza datelor din tabela asta
 *
 * - crews      - contine numele pilotului si copilotului. aceste date in mod normal nu sunt publice pentru clienti deci... as zice ca e cam inutila.
 *
 * - flights    - contine toate zborurile disponibile
 *              - tabela clients contine un FK spre tabela asta
 *              - sunt 6 zboruri pe zi catre 6 destinatii diferite
 *              - am creat zboruri pentru toata luna mai, 155 in total.
 *
 * - ticketsavailable - e in plus, o voi sterge ulterior.
 *
 *
 * CRUD:
 *              - am creat metode CRUD in ClientService
 *              - pentru csv-upload am atasat fisierul addCLients in resources
 *              - pentru testare bulk am adaugat un json in resources
 *
 * Suplimentar:
 *              Am creat mai multe metode in functie de ce am considerat ca ar fi normal intr-un proiect de genul:
 *              - de fiecare data cand se creeaza un client nou (se cumpara un bilet) numarul disponibil de bilete pentru acea clasa-zbor scade
 *              - cand se sterge/updateaza un client, numarul de bilete creste inapoi
 *              - la updatare am pus si conditia ca update-ul sa se poata face pe acelasi zbor (schimbarea clasei) sau schimbarea zilei dar aceeasi destinatie. ca si in realitate daca vrei alta destinatie trebuie luat alt bilet.
 *              - am creat o metoda de calculare a pretului pe baza: distanta, clasa, timp ramas pana la decolare + stabilirea locului in avion.
 *
 *              - am setat proiectul pe port 8070 pentru ca ma saturasem sa tot descopar de ce portul este deja folosit.
 *              - in resources am adaugat si un dump cu db-ul
 *
 *              - pe parcurs mi-au tot venit idei care erau un pic diferite de cele cu care pornisem si unele metode in loc sa le adaptez ca lumea le-am tot peticit cate un pic astfel ca in unele locuri ar putea parea cam
 *              dezordonat proiectul. Nu m-am apucat sa il... "ordonez" am lasat asa sa vad daca zici tu ca e necesar (sa nu muncim mai mult decat e nevoie... nu?)
 *
 *              - nu am facut inca testele unitare.
 *              - probabil trebuie sa mai umblu la comportamentul exceptiilor, in pachetul exception este o clasa cu numele "ErrorResponse", o copioasem din proiectul tau dar nu face nimic aici, trebuie sa o cercetez
 *              - nu am impus deloc conditii la input (NotNull/NotBlank/Etc), urmeaza sa ma mai uit si la asta.
 *
 */