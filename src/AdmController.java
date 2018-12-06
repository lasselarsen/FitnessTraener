//Lavet af Christian og lasse

import java.util.ArrayList;
import java.util.Scanner;

//Vi opretter vores attributter, samt objekt "traenerToEdit" som sætter vores angivne oplysninger senere i AdmMenu'en.
public class AdmController 
{
    private Data db;
    private Scanner scanner;
    private Adm nuAdm;
    Traener traenerAendre = new Traener();
    
    //Vores attributter laver vi til objekt metoder, ved at sætte "this." på.
    public AdmController(Data data)
    {
        this.db = data;
        this.scanner = new Scanner(System.in);
    }


    //Den første fremviste menu, som scanner AdmID'et og adgangskoden. 
    //Hvorefter den henføre til "printMenu" som er en switch-case mmetode med otte valgmuligheder
    public void administratorMenu() 
    {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("------------------ Velkommen til administrator menu -----------------");
        System.out.println("---------------------------------------------------------------------\n \n");

        System.out.print("\nIndtast dit ADMID: ");
        int admID = scanner.nextInt();

        System.out.print("Indtast adgangskode: ");
        int pinkode = scanner.nextInt();
        scanner.nextLine();

        if (userExists(admID, pinkode))
        {
            System.out.println("\nVelkommen tilbage, " + nuAdm.getAdmnavn() + "!");
            do 
                {
                printMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // consumes the new line left-over. An error in the Scanner object.

                switch (choice) 
                {
                    case 1:
                        AendreOplysninger();
                        break;
                    case 2:
                        GodkendTraener();
                        break;
                    case 3:
                        SletTraener();
                        break;
                    case 4:
                        bestemtTraener();
                        break;
                    case 5:
                        BestemtHoldtype();
                        break;
                    case 6:
                        visTraenereEfterHold();
                        break;
                    case 7:
                        Arbejdsfordeling();
                        break;
                    case 8:
                        logUd();
                        break;
                    default:
                        System.out.println("Ugyldigt valg.");
                }
            }
            while (nuAdm != null);
        } else 
            {
            System.out.println("Forkerte oplysninger.. Prøv igen!");
        }

    }

    //Her tjekkes det om brugeren eksistere, at der er blevet oprettet et admId og pinkode for administratoren
    private boolean userExists(int admID, int pinkode) 
    {
        for (Adm adm : db.getAdministratore()) 
        {
            if (adm.getAdmID() == admID && adm.getAdmKode() == pinkode) {
                this.nuAdm = adm;
                return true;
            }
        }
        return false;
    }

    //En menu som printer administratorens muligheder, henvist fra "printMenu" metoden.
    private void printMenu() 
    {
        System.out.println("\nDu har nu følgende valgmuligheder: \n");
        System.out.println("1) Ændr træner oplysninger");
        System.out.println("2) Godkend nye trænere");
        System.out.println("3) Slet trænere");
        System.out.println("4) Vis alle oplysninger om en bestemt træner");
        System.out.println("5) Vis alle oplysninger om trænere af en bestem holdtype");
        System.out.println("6) Vis trænere kategoriseret efter holdtype");
        System.out.println("7) Vis statistik over arbejdsfordelingen på trænerne");
        System.out.println("8) Log ud");
    }

    //En liste over trænerene printes.
    private void TraenerListe() 
    {
        int i = 1;
        System.out.printf("%-10s %-40s %-30s\n", "Nr.", "Navn:", "CPR:");
        for (Traener traenere : db.getTraenere()) 
        {
            System.out.printf("%-10d %-40s %-30s\n", i, traenere.getNavn(), traenere.getCpr());
            i++;
        }
    }

    //En liste over ikke godkendte trænere. Dermed de som har værdien boolean false.
    private void ikkegodkendtTraenerListe() 
    {
        System.out.printf("%-10s %-40s %-30s %-20s\n", "Nr.", "Navn:", "CPR:", "Status:");
        for (Traener traenere : db.getTraenere()) 
        {
            if (traenere.getIsApproved() == false) 
            {
                System.out.printf("%-10s %-40s %-30s %-20s\n", db.getTraenere().indexOf(traenere), traenere.getNavn(), traenere.getCpr(), traenere.getIsApproved());
            }
        }
    }
    
    //En liste over holdene printes.
    private void HoldListe() 
    {
        int i = 1;
        System.out.printf("%-10s %-40s \n", "Nr. ", "Hold: ");
        for (Hold holdene : db.getHoldene()) 
        {
            System.out.printf("%-10d %-40s \n", i, holdene.getHoldNavn());
            i++;
        }
    }
    
    //Her får du administratoren muligheden for at ændre alle oplysningerne på en bestemt træner, valgt ud fra 
    // "TraenerListe" metoden.
    private void AendreOplysninger() 
    {
        TraenerListe();
        System.out.println("Indtast nummeret på træneren: ");
        int traenerNr = scanner.nextInt();
        traenerAendre = db.getTraenere().get(--traenerNr);
        int svar;

        do 
            {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("---------------------- Ændre træner oplysninger  ---------------------");
            System.out.println("---------------------------------------------------------------------\n \n");

            System.out.println("Hvilke oplysninger ønsker du at ændre?");
            System.out.println("Tast 1 - Hold");
            System.out.println("Tast 2 - Navn");
            System.out.println("Tast 3 - Mail");
            System.out.println("Tast 4 - CPR-nr");
            System.out.println("Tast 5 - Adresse");
            System.out.println("Tast 6 - Mobil nr");
            System.out.println("Tast 7 - Uddannelse");
            System.out.println("Tast 8 - Erfaring");
            System.out.println("Tast 9 - Aftalte antal timer pr. måned");
            System.out.println("Tast 10 - Pinkode");
            System.out.println("Tast 11 - Tilbage til menu");
            svar = scanner.nextInt();

            switch (svar) 
            {
                case 1:
                    admAendreHold();
                    break;
                case 2:
                    System.out.println("Indtast nyt navn: ");
                    scanner.nextLine();
                    String svarNavn = scanner.nextLine();
                    traenerAendre.setNavn(svarNavn);
                    break;
                case 3:
                    System.out.println("Indtast din nye mail: ");
                    scanner.nextLine();
                    String svarMail = scanner.nextLine();
                    traenerAendre.setMail(svarMail);
                    break;
                case 4:
                    System.out.println("Indtast dit nye CPR: ");
                    int svarCpr = scanner.nextInt();
                    traenerAendre.setCpr(svarCpr);
                    break;
                case 5:
                    System.out.println("Indtast din nye adresse: ");
                    scanner.nextLine();
                    String svarAdr = scanner.nextLine();
                    traenerAendre.setAdresse(svarAdr);
                    break;
                case 6:
                    System.out.println("Indtast dit nye mobilnummer: ");
                    int svarMobil = scanner.nextInt();
                    traenerAendre.setMobil(svarMobil);
                    break;
                case 7:
                    System.out.println("Indtast nye oplysninger om uddannelse: ");
                    scanner.nextLine();
                    String svarUdd = scanner.nextLine();
                    traenerAendre.setUdd(svarUdd);
                    break;
                case 8:
                    System.out.println("Indtast ny erfaring i antal år: ");
                    int svarErf = scanner.nextInt();
                    traenerAendre.setErfaring(svarErf);
                    break;
                case 9:
                    System.out.println("Indtast nye oplysninger om antal timer: ");
                    int svarTimer = scanner.nextInt();
                    traenerAendre.setTimer(svarTimer);
                    break;
                case 10:
                    System.out.println("Indtast ny pinkode: ");
                    int svarPin = scanner.nextInt();
                    traenerAendre.setPinkode(svarPin);
                    break;
                case 11:
                    printMenu();
                default:
                    System.out.println("Du har indtastet forkert, prøv igen.");


            } scanner.nextLine();
        } while (svar != 11);
    }

    //Administratorens funktion til at ændre holdtypen på en bestemt træner.
    private void admAendreHold()
    {
        System.out.print("\nVælg dit nye hold:\" \n");

        int i = 1;
        System.out.printf("\n%-10s %-40s %-40s\n", "Nr", "Navn", "Beskrivelse\n");

        for (Hold holdene : db.getHoldene())
        {
            System.out.printf("%-10d %-40s %-40s\n", i, holdene.getHoldNavn(), holdene.getKortBeskrivelse());
            i++;
        }
        System.out.print("\n\nIndtast nummeret på det nye hold du skal være træner på:  ");
        int svarHold = scanner.nextInt()-1;
        Hold holdDerFjernesFraBruger = traenerAendre.getHoldene().get(0);

        //Fjerner det tidligere hold ud fra indeks nul og tilføjer det nye
        traenerAendre.getHoldene().set(0, db.getHoldene().get(svarHold));

        db.getHoldene().get(svarHold).addTraener(traenerAendre);

        Hold holdAtFjernesFra = null;

        //VÆR OPMÆRKSOM PÅ HVIS 2 HOLD HAR SAMME NAVN
        for (Hold hold: db.getHoldene())
        {
            if (holdDerFjernesFraBruger.getHoldNavn().equals(hold.getHoldNavn()))
            {
                holdAtFjernesFra = hold;
            }
        }

        holdAtFjernesFra.removeTraener(traenerAendre);

        System.out.print("Holdet er nu ændret");
    }

    //En metode som printer en liste over ikke-godkendte trænere (trænere som har boolean værdien "false".
    //Derefter giver den mulighed for at godkende ved at indtaste index-nummeret på træneren.
    public void GodkendTraener()
    {
        ikkegodkendtTraenerListe();
        System.out.println("\nIndtast nummeret på træneren som skal godkendes: ");
        int traenerNr = scanner.nextInt();
        Traener traenertoApprove = db.getTraenere().get(traenerNr);
        traenertoApprove.setIsApproved(true);
        System.out.println(traenertoApprove.getNavn() + " blev godkendt!");
    }

    //En metode som printer trænerlisten og derefter giver muligheden for at slette træneren fra databasen.
    private void SletTraener()
    {
        TraenerListe();
        System.out.println("\nIndtast nummeret på den træner som skal slettes:");
        int traenernr = scanner.nextInt();
        Traener traenerSletning = db.getTraenere().get(--traenernr);
        db.getTraenere().remove(traenerSletning);
        System.out.println("Træneren '" + traenerSletning.getNavn() + "' er nu slettet fra systemet. "
                + "Vender tilbage til hovedmenuen...");
    }

    //En metode som printer alle oplysninger om én bestemt træner, valgt ud fra trænerlisten.
    private void bestemtTraener()
    {
        TraenerListe();
        System.out.println("\nIndtast nummeret på træneren for at tilgå trænerens informationer: ");
        int trænerNr = scanner.nextInt();

        Traener traenerInformation = db.getTraenere().get(--trænerNr);
        System.out.println("Hold:           \t" + traenerInformation.getHoldene().get(0).getHoldNavn());
        System.out.println("Navn:           \t" + traenerInformation.getNavn());
        System.out.println("Mail:           \t" + traenerInformation.getMail());
        System.out.println("CPR:            \t" + traenerInformation.getCpr());
        System.out.println("Adresse:        \t" + traenerInformation.getAdresse());
        System.out.println("Mobil:          \t" + traenerInformation.getMobil());
        System.out.println("Uddannelse:     \t" + traenerInformation.getUdd());
        System.out.println("Erfaring:       \t" + traenerInformation.getErfaring());
        System.out.println("Timer:          \t" + traenerInformation.getTimer());
        System.out.println("Pinkode:        \t" + traenerInformation.getPinkode());
        System.out.println("Godkendt?:      \t" + traenerInformation.getIsApproved());
    }

    //Ud fra metoden Holdliste, printes holdene, derefter printes oplysningerne om trænerne på det valgte hold
    private void BestemtHoldtype()
    {
        HoldListe();
        System.out.println("\nIndtast nummeret på holdet: ");
        int holdnr = scanner.nextInt();
        Hold traenerEfterHold = db.getHoldene().get(--holdnr);
        int i = 0;
        do
        {
            System.out.println("Navn:           \t" + traenerEfterHold.getTraenere().get(i).getNavn());
            System.out.println("Mail:           \t" + traenerEfterHold.getTraenere().get(i).getMail());
            System.out.println("CPR:            \t" + traenerEfterHold.getTraenere().get(i).getCpr());
            System.out.println("Adresse:        \t" + traenerEfterHold.getTraenere().get(i).getAdresse());
            System.out.println("Mobil:          \t" + traenerEfterHold.getTraenere().get(i).getMobil());
            System.out.println("Uddannelse:     \t" + traenerEfterHold.getTraenere().get(i).getUdd());
            System.out.println("Erfaring:       \t" + traenerEfterHold.getTraenere().get(i).getErfaring());
            System.out.println("Timer:          \t" + traenerEfterHold.getTraenere().get(i).getTimer());
            System.out.println("Pinkode:        \t" + traenerEfterHold.getTraenere().get(i).getPinkode());
            System.out.println("Godkendt?:      \t" + traenerEfterHold.getTraenere().get(i).getIsApproved() + "\n\n");
            i++;
        } while (i < traenerEfterHold.getTraenere().size());
    }

    //Trænerne printes under det hold de er på.
    private void visTraenereEfterHold() {
        ArrayList<Hold> hold = db.getHoldene();
        System.out.print("Hold:" + "\t \t \t \t Trænere:");

        int i = 0;
        int j;

        do
        {
            Hold holdene = db.getHoldene().get(i);
            System.out.print("\n"+holdene.getHoldNavn());
            j = 0;

            do {
                System.out.printf("\t \t \t "+holdene.getTraenere().get(j).getNavn() + "\n" + "\t \t");
                j++;
            } while (j < holdene.getTraenere().size());

            i++;
        } while (i < hold.size());

    }

    //Metoden "sorterTimer" køres og trænerne printes efter der arbejdestimer
    private void Arbejdsfordeling()
    {
        for (Traener traener : sorterTimer())
        {
            System.out.println(traener.getTimer() + "\t" + traener.getNavn());
        }
    }

    private ArrayList<Traener> sorterTimer()
    {
        ArrayList<Traener> sorteretListe = new ArrayList<>();

        for (Traener traener : db.getTraenere())
        {
            if (sorteretListe.size() == 0)
            {
                sorteretListe.add(traener);
            } else
                {
                int index = -1;
                for (Traener sorteretTraener : sorteretListe)
                {
                    if (sorteretTraener.getTimer() < traener.getTimer() && index == -1)
                    {
                        index = sorteretListe.indexOf(sorteretTraener);
                    }
                }
                sorteretListe.add(index, traener);
            }
        }
        return sorteretListe;
    }

    //printMenu stoppes og man bliver sendt tilbage til start menuen.
    private void logUd()
    {
        nuAdm = null;
        System.out.println("\nDu er nu logget ud... Viderestiller til login.");
    }


}
