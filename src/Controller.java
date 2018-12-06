//Lavet af Nikolaj og Nadia

import java.util.Scanner;

public class Controller
{

    private Data db;
    private Scanner scanner;
    private Traener nuvaerendeTraener;

    AdmController adm;

    public Controller()
    {
        this.db = new Data();
        this.scanner = new Scanner(System.in);
        adm = new AdmController(db);
    }

    public void run()
    {
        int forsaet = 1;
        do
        {
            //Her er hovedmenuen oprettet
            int valg;
            System.out.println("\n\n---------------------------------------------------------------------");
            System.out.println("---------------------- Velkommen til MotionCBS ----------------------");
            System.out.println("---------------------------------------------------------------------\n \n");
            System.out.println("Tast 1 - Opret træner \nTast 2 - Log ind træner \nTast 3 - Log ind administrator \nTast 4 - Afslut program");
            valg = scanner.nextInt();

            switch (valg)
            {
                case 1:
                    opretTraener();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    adm.administratorMenu();
                    break;
                case 4:
                    forsaet = 0;
                    break;
                default:
                    System.out.print("Ugyldigt valg, prøv igen ");
            }
        } while (forsaet == 1);
    }


    public void opretTraener()
    {
        System.out.print("\nIndtast dit fulde navn: ");
        String fejlnavn = scanner.nextLine(); //Oprettet grundet systemfejl
        String navn = scanner.nextLine();

        System.out.print("\nIndtast din mail: ");
        String mail = scanner.nextLine();

        System.out.print("\nIndtast dit CPR-nr: ");
        int cpr = scanner.nextInt();

        System.out.print("\nIndtast din adresse: ");
        String fejladr = scanner.nextLine();
        String adr = scanner.nextLine();

        System.out.print("\nIndtast dit mobil nr: ");
        int mobil = scanner.nextInt();

        System.out.print("\nIndtast din uddannelse: ");
        String fejludd = scanner.nextLine();
        String udd = scanner.nextLine();

        int erfaring = -1;
        boolean format1;
        do //Her har vi oprettet try-catch for erfaring i år
        {
            try
            {
                System.out.print("\nIndtast din erfaring i hele år: ");
                erfaring = scanner.nextInt();
                format1 = true;
            } catch (Exception error)
            {
                System.out.printf("System fejlmeddelselse %s \n", error);
                System.out.println("Der er sket en fejl i indtastningen");
                format1 = false;
            }
        } while (!format1);

        System.out.print("\nIndtast de aftale antal timer pr. måned: ");
        double timer = scanner.nextDouble();

        System.out.print("\nIndtast pinkode: ");
        int pinkode = scanner.nextInt();

        boolean isApproved = false;

        //Printer holdmuligheder
        int traenereErOprettet = 0;

        do {
            System.out.print("\nVælg det hold du skal være træner på: \n");

            int i = 1;
            System.out.printf("\n%-10s %-40s %-40s\n", "Nr", "Navn", "Beskrivelse\n");

            for (Hold holdene : db.getHoldene())
            {
                System.out.printf("%-10d %-40s %-40s\n", i, holdene.getHoldNavn(), holdene.getKortBeskrivelse());
                i++;
            }

            System.out.print("\n\nIndtast nummeret på det hold du skal være træner på: ");
            int svaret = scanner.nextInt();

            switch (svaret)
            {
                case 1:
                    opretStramOp(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode, isApproved);
                    traenereErOprettet = 1;
                    break;
                case 2:
                    opretHit(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode, isApproved);
                    traenereErOprettet = 1;
                    break;
                case 3:
                    opretSpinning(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode, isApproved);
                    traenereErOprettet = 1;
                    break;
                case 4:
                    opretCrossfit(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode, isApproved);
                    traenereErOprettet = 1;
                    break;
                default:
                    System.out.print("Ugyldigt valg - husk du skal taste 1, 2, 3 eller 4 ind- prøv igen");
                    break;
            }
        } while (traenereErOprettet == 0);
    }

    //Her oprettes de 4 forskellige hold
    private void opretStramOp(String navn, String mail, int cpr, String adr, int mobil, String udd, int erfaring,
                              double timer, int pinkode, boolean isApproved)
    {
        db.getTraenere().add(new Traener(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode, isApproved));
        db.getTraenere().get(db.getTraenere().size() - 1).addHold(db.getHoldene().get(0));

        //Tilføjer traenere til hold Arrylisten
        db.getHoldene().get(1).addTraener(db.getTraenere().get(db.getTraenere().size() - 1));

        System.out.print("\nStort tillyke med oprettelsen" + navn + "!" + "\nDu er blevet tildelt holdet Stram op og " +
                "vi er glade for, at du vil være træner hos os!\n\nAfvent godkendelses kontrol, før du kan logge in");
    }

    private void opretHit(String navn, String mail, int cpr, String adr, int mobil, String udd, int erfaring,
                          double timer, int pinkode, boolean isApproved)
    {
        db.getTraenere().add(new Traener(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode, isApproved));
        db.getTraenere().get(db.getTraenere().size() - 1).addHold(db.getHoldene().get(1));

        //Tilføjer traenere til hold Arrylisten
        db.getHoldene().get(0).addTraener(db.getTraenere().get(db.getTraenere().size() - 1));

        System.out.print("\nStort tillyke med oprettelsen" + navn + "!" + "\nDu er blevet tildelt holdet H.I.T. og vi" +
                " er glade for, at du vil være træner hos os! \n\nAfvent godkendelses kontrol, før du kan logge in");
    }
    
    private void opretSpinning(String navn, String mail, int cpr, String adr, int mobil, String udd, int erfaring,
                               double timer, int pinkode, boolean isApproved)
    {
        db.getTraenere().add(new Traener(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode, isApproved));
        db.getTraenere().get(db.getTraenere().size() - 1).addHold(db.getHoldene().get(2));

        //Tilføjer traenere til hold Arrylisten
        db.getHoldene().get(2).addTraener(db.getTraenere().get(db.getTraenere().size() - 1));

        System.out.print("\nStort tillyke med oprettelsen" + navn + "!" + "\nDu er blevet tildelt holdet Spinning og " +
                "vi er glade for, at du vil være traner hos os!\n\nAfvent godkendelses kontrol, før du kan logge in");
    }

    private void opretCrossfit(String navn, String mail, int cpr, String adr, int mobil, String udd, int erfaring,
                               double timer, int pinkode, boolean isApproved)
    {
        db.getTraenere().add(new Traener(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode, isApproved));
        db.getTraenere().get(db.getTraenere().size() - 1).addHold(db.getHoldene().get(3));

        //Tilføjer traenere til hold Arrylisten
        db.getHoldene().get(3).addTraener(db.getTraenere().get(db.getTraenere().size() - 1));

        System.out.print("\nStort tillyke med oprettelsen" + navn + "!" + "\nDu er blevet tildelt holdet Crossfit og " +
                "vi er glade for, at du vil være træner hos os!\n\nAfvent godkendelses kontrol, før du kan logge in");
    }

    public void login()
    {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("-------------------- VELKOMMEN TIL TRÆNER LOGIN --------------------");
        System.out.println("---------------------------------------------------------------------\n \n");

        int cpr = -1;
        boolean format;
        do //Der er oprettet try-catch, så programmet ikke lukker hvis der tastet bogstaver istedet for tal
        {
            try //inspiration fra: https://stackoverflow.com/questions/34077958/do-while-loop-with-try-catch
            {
                System.out.print("\nIndtast dit CPR NR: ");
                cpr = scanner.nextInt();
                format = true;
            } catch (Exception error)
            {
                scanner.nextLine();
                System.out.printf("System fejlmeddelselse %s \n", error);
                System.out.println("Der er sket en fejl i indtastningen");
                format = false;
            }
        }
        while (!format);

        System.out.print("Indtast adgangskode: ");
        int pinkode = scanner.nextInt();
        scanner.nextLine();

        if (userExists(cpr, pinkode) && nuvaerendeTraener.getIsApproved())
        {
            System.out.println("\nVelkommen tilbage, " + nuvaerendeTraener.getNavn() + "!");
            do
            {
                printMenu();
                int choice = scanner.nextInt();

                switch (choice)
                {
                    case 1:
                        AendreOplysninger();
                        break;
                    case 2:
                        visTraenere();
                        break;
                    case 3:
                        logUd();
                        break;
                    default:
                        System.out.println("Ugyldigt valg.");
                }
            } while (nuvaerendeTraener != null);
        } else
            {
                System.out.println("Forkerte oplysninger eller du er ikke blevet godkendt!");
            }

    }

    //Her kontrolleres der om brugeren eksisterer
    private boolean userExists(int cpr, int pinkode)
    {

        for (Traener traener : db.getTraenere())
        {
            if (traener.getCpr() == cpr && traener.getPinkode() == pinkode)
            {
                this.nuvaerendeTraener = traener;
                return true;
            }
        }
        return false;
    }

    private void printMenu()
    {
        System.out.println("\nDu har nu følgende valgmuligheder: \n");
        System.out.println("1) Ændre dine oplysninger");
        System.out.println("2) Vis trænere kategoriseret efter holdtype");
        System.out.println("3) Log ud");

    }

    private void AendreOplysninger()
    {
        boolean keepChanging = true;
        int svar = -1;
        do {
            System.out.println("\n---------------------------------------------------------------------");
            System.out.println("---------------------- Ændre dine oplysninger  ---------------------");
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
            System.out.println("Tast 11 - Tilbage til træner menuen");

            svar = scanner.nextInt();

            switch (svar)
            {

                case 1:
                    ændreHold();
                    break;
                case 2:
                    System.out.println("Indtast dit nye navn: ");
                    scanner.nextLine();
                    String svarNavn = scanner.nextLine();
                    nuvaerendeTraener.setNavn(svarNavn);
                    break;
                case 3:
                    System.out.println("Indtast din nye mail: ");
                    scanner.nextLine();
                    String svarMail = scanner.nextLine();
                    nuvaerendeTraener.setMail(svarMail);
                    break;
                case 4:
                    System.out.println("Indtast dit nye CPR: ");
                    int svarCpr = scanner.nextInt();
                    nuvaerendeTraener.setCpr(svarCpr);
                    break;
                case 5:
                    System.out.println("Indtast din nye adresse: ");
                    scanner.nextLine();
                    String svarAdr = scanner.nextLine();
                    nuvaerendeTraener.setAdresse(svarAdr);
                    break;
                case 6:
                    System.out.println("Indtast dit nye mobilnummer: ");
                    int svarMobil = scanner.nextInt();
                    nuvaerendeTraener.setMobil(svarMobil);
                    break;
                case 7:
                    System.out.println("Indtast nye oplysninger om uddannelse: ");
                    scanner.nextLine();
                    String svarUdd = scanner.nextLine();
                    nuvaerendeTraener.setUdd(svarUdd);
                    break;
                case 8:
                    System.out.println("Indtast ny erfaring i antal år: ");
                    int svarErf = scanner.nextInt();
                    nuvaerendeTraener.setErfaring(svarErf);
                    break;
                case 9:
                    System.out.println("Indtast nye oplysninger om antal timer: ");
                    int svarTimer = scanner.nextInt();
                    nuvaerendeTraener.setTimer(svarTimer);
                    break;
                case 10:
                    System.out.println("Indtast ny pinkode: ");
                    int svarPin = scanner.nextInt();
                    nuvaerendeTraener.setPinkode(svarPin);
                    break;
                case 11:
                    System.out.println("Viderestiller til trænermenu");
                    keepChanging = false;
                    break;
                default:
                    System.out.println("Du har indtastet forkert, prøv igen.");
                    break;
            }
            scanner.nextLine();
        } while (svar != 11);
    }


    private void ændreHold()
    {
        System.out.print("\nVælg dit nye hold:\" \n");

        int i = 1;
        System.out.printf("\n%-10s %-40s %-40s\n", "Nr", "Navn", "Beskrivelse\n");

        for (Hold holdene : db.getHoldene())
        {
            System.out.printf("%-10d %-40s %-40s\n", i, holdene.getHoldNavn(), holdene.getKortBeskrivelse());
            i++;
        }

        System.out.print("\n\nIndtast nummeret på det nye hold du skal være træner på: ");
        int svarHold = scanner.nextInt()-1;
        Hold holdDerFjernesFraBruger = nuvaerendeTraener.getHoldene().get(0);

        //Fjerner det tidligere hold ud fra indeks nul og tilføjer det nye
        nuvaerendeTraener.getHoldene().set(0, db.getHoldene().get(svarHold));

        db.getHoldene().get(svarHold).addTraener(nuvaerendeTraener);

        Hold holdAtFjernesFra = null;


        //Vær opmærksom på hvis to hold har samme navn, så virker denne metode ikke
        for (Hold hold: db.getHoldene())
        {
            if (holdDerFjernesFraBruger.getHoldNavn().equals(hold.getHoldNavn()))
            {
                holdAtFjernesFra = hold;
            }
        }

        holdAtFjernesFra.removeTraener(nuvaerendeTraener);

        System.out.print("Holdet er nu ændret");
    }

    //Printer en liste med vigtigste oplysninger over alle trænere
    private void visTraenere()
    {
        int i = 1;
        System.out.printf("%-10s %-40s %-30s %-30s\n", "Nr.", "Navn", "Hold", "mobilnummer");
        for (Traener traenere : db.getTraenere())
        {
            System.out.printf("%-10d %-40s %-30s %-30d\n", i, traenere.getNavn(), traenere.getHoldene().get(0).getHoldNavn(), traenere.getMobil());
            i++;
        }
    }

    private void logUd()
    {
        nuvaerendeTraener = null;
        System.out.println("\nDu er nu logget ud... Viderestiller til startsiden");
    }
}
