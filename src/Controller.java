//Lavet af Nikolaj og Nadia
//Vi skal have lavet en arrayliste for den træner som er logget ind. Herefter kan vi ændre oplysninger

import java.util.ArrayList;
import java.util.Scanner;

public class Controller
{
    private Data db;
    private Scanner scanner;
    private Traener nuTraenere;

    AdmController adm = new AdmController();



    public Controller()
    {
        this.db = new Data();
        this.scanner = new Scanner(System.in);
        this.nuTraenere = new Traener();
    }

    public void run()
    {
        boolean keepRunning = true;
        do
        {
            int valg;
            System.out.println("---------------------------------------------------------------------");
            System.out.println("---------------------- Velkommen til MotionCBS ----------------------");
            System.out.println("---------------------------------------------------------------------\n \n");
            System.out.println("Tast 1 - Opret traener \nTast 2 - Log ind traener \nTast 3 - Log ind administrator \nTast 4 - Afslut program");
            valg = scanner.nextInt();


            switch (valg)
            {
                case 1:
                    addTraener();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    adm.administratorMenu();
                    break;
                case 4:
                    keepRunning = false;
                    break;
                default:
                    System.out.print("Ugyldigt valg, prøv igen ");
            }
        } while (keepRunning = true);
    }


    public void addTraener()
    {
        System.out.print("\nIndtast dit fulde navn: ");
        String navn = scanner.nextLine();

        System.out.print("\nIndtast din mail: ");
        String mail = scanner.nextLine();

        System.out.print("\nIndtast dit CPR-nr: ");
        int cpr = scanner.nextInt();

        System.out.print("\nIndtast din adresse: ");
        String adr = scanner.nextLine();
        scanner.nextLine();

        System.out.print("\nIndtast dit mobil nr: ");
        int mobil = scanner.nextInt();

        System.out.print("\nIndtast din uddannelse: ");
        String udd = scanner.nextLine();
        scanner.nextLine();

        System.out.print("\nIndtast din erfaring i hele år: ");
        int erfaring = scanner.nextInt();

        System.out.print("\nIndtast de aftale antal timer pr. måned: ");
        double timer = scanner.nextDouble();

        System.out.print("\nIndtast pinkode: ");
        int pinkode = scanner.nextInt();

        boolean isApproved = false;

        // printer holdmulighederne ud
        int traenereErOprettet = 0;

        do
        {
            System.out.print("\nVælg det hold du skal vaere traener på: \n");

            int i = 1;
            System.out.printf("\n%-10s %-40s %-40s\n", "Nr", "Navn", "Beskrivelse\n");

            for (Hold holdene : db.getHoldene())
            {
                System.out.printf("%-10d %-40s %-40s\n", i, holdene.getHoldNavn(), holdene.getKortBeskrivelse());
                i++;
            }

            System.out.print("\n\nIntast nummeret på det hold du skal være træner på: ");
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
                   // traenereErOprettet = 0;
                    break;
            }
        } while (traenereErOprettet == 0);
    }

    // Her oprettes de 4 forskellige hold
    private void opretHit(String navn, String mail, int cpr, String adr, int mobil, String udd, int erfaring, double timer, int pinkode, boolean isApproved)
    {
        db.getTraenere().add(new Traener(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode, isApproved));
        db.getTraenere().get(db.getTraenere().size() - 1).addHold(db.getHoldene().get(0));

        //Tilfoejer traenere til hold Arrylisten
        db.getHoldene().get(0).addTraener(db.getTraenere().get(db.getTraenere().size() - 1));

        System.out.print("\nStort tillyke med oprettelsen" + navn + "!" + "\nDu er blevet tildelt holdet H.I.T. og vi er glade for, at du vil være træner hos os! \n\nAfvent godkendelses kontrol, før du kan logge in");
    }

    private void opretStramOp(String navn, String mail, int cpr, String adr, int mobil, String udd, int erfaring, double timer, int pinkode, boolean isApproved)
    {
        db.getTraenere().add(new Traener(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode, isApproved));
        db.getTraenere().get(db.getTraenere().size() - 1).addHold(db.getHoldene().get(1));

        //Tilfoejer traenere til hold Arrylisten
        db.getHoldene().get(1).addTraener(db.getTraenere().get(db.getTraenere().size() - 1));

        System.out.print("\nStort tillyke med oprettelsen" + navn + "!" + "\nDu er blevet tildelt holdet Stram op og vi er glade for, at du vil være træner hos os!\n\nAfvent godkendelses kontrol, før du kan logge in");
    }

    private void opretSpinning(String navn, String mail, int cpr, String adr, int mobil, String udd, int erfaring, double timer, int pinkode, boolean isApproved)
    {
        db.getTraenere().add(new Traener(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode, isApproved));
        db.getTraenere().get(db.getTraenere().size() - 1).addHold(db.getHoldene().get(2));

        //Tilfoejer traenere til hold Arrylisten
        db.getHoldene().get(2).addTraener(db.getTraenere().get(db.getTraenere().size() - 1));

        System.out.print("\nStort tillyke med oprettelsen" + navn + "!" + "\nDu er blevet tildelt holdet Spinning og vi er glade for, at du vil være traner hos os!\n\nAfvent godkendelses kontrol, før du kan logge in");
    }

    private void opretCrossfit(String navn, String mail, int cpr, String adr, int mobil, String udd, int erfaring, double timer, int pinkode, boolean isApproved)
    {
        db.getTraenere().add(new Traener(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode, isApproved));
        db.getTraenere().get(db.getTraenere().size() - 1).addHold(db.getHoldene().get(3));

        //Tilfoejer traenere til hold Arrylisten
        db.getHoldene().get(3).addTraener(db.getTraenere().get(db.getTraenere().size() - 1));

        System.out.print("\nStort tillyke med oprettelsen" + navn + "!" + "\nDu er blevet tildelt holdet Crossfit og vi er glade for, at du vil være træner hos os!\n\nAfvent godkendelses kontrol, før du kan logge in");
    }

    public void login()
    {

        //Henvisning til "AdmController class" hvor brugeren "TRÆNER" er enten er godkendt eller nægtet adgang
        //Opret userApproved ved "if (userExists) statement

        System.out.println("---------------------------------------------------------------------");
        System.out.println("-------------------- VELKOMMEN TIL TRÆNER LOGIN --------------------");
        System.out.println("---------------------------------------------------------------------\n \n");


            System.out.print("\nIndtast dit CPR NR: ");
            int cpr = scanner.nextInt();

            System.out.print("Indtast adgangskode: ");
            int pinkode = scanner.nextInt();
            scanner.nextLine();

            if (userExists(cpr, pinkode) && nuTraenere.getIsApproved())
            {
                System.out.println("\nVelkommen tilbage, " + nuTraenere.getNavn() + "!");
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
                            visTraenere();
                            break;
                        case 3:
                            logOut();
                            break;
                        default:
                            System.out.println("Ugyldigt valg.");
                    }
                } while (nuTraenere != null);
            } else
              {
                System.out.println("Forkerte oplysninger eller du er ikke blevet godkendt!");
              }

    }

    private boolean userExists(int cpr, int pinkode)
    {

        for (Traener traener : db.getTraenere())
        {
            if (traener.getCpr() == cpr && traener.getPinkode() == pinkode)
            {
                this.nuTraenere = traener;
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

            /*{
                int i = 1;
                System.out.printf("%-10s %-40s %-30s \n", "Nr.", "Navn", "Hold", "mobilnummer");
                for (Traener traenere : db.getTraenere())
                {
                    System.out.printf("%-10d %-40s %-30s %-30d\n", i, traenere.getNavn().get().nuTraenere, traenere.getMail(nuTraenere).get(0).getHoldNavn(), traenere.getMobil());
                    i++;
                }
            }*/



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

            switch (svar) {

                case 1:
                    ændreHold();
                    break;
                case 2:
                    System.out.println("Indtast dit nye navn: ");
                    String svarNavn = scanner.nextLine();
                    //db.getTraenere().get().setNavn(svarNavn);
                    break;
                case 3:
                    System.out.println("Indtast din nye mail: ");
                    String svarMail = scanner.nextLine();
                    nuTraenere.setMail(svarMail);
                    break;
                case 4:
                    System.out.println("Indtast dit nye CPR: ");
                    int svarCpr = scanner.nextInt();
                    nuTraenere.setCpr(svarCpr);
                    break;
                case 5:
                    System.out.println("Indtast din nye adresse: ");
                    String svarAdr = scanner.nextLine();
                    nuTraenere.setAdresse(svarAdr);
                    break;
                case 6:
                    System.out.println("Indtast dit nye mobilnummer: ");
                    int svarMobil = scanner.nextInt();
                    nuTraenere.setMobil(svarMobil);
                    break;
                case 7:
                    System.out.println("Indtast nye oplysninger om uddannelse: ");
                    String svarUdd = scanner.nextLine();
                    nuTraenere.setUdd(svarUdd);
                    break;
                case 8:
                    System.out.println("Indtast ny erfaring i antal år: ");
                    int svarErf = scanner.nextInt();
                    nuTraenere.setErfaring(svarErf);
                    break;
                case 9:
                    System.out.println("Indtast nye oplysninger om antal timer: ");
                    int svarTimer = scanner.nextInt();
                    nuTraenere.setTimer(svarTimer);
                    break;
                case 10:
                    System.out.println("Indtast ny pinkode: ");
                    int svarPin = scanner.nextInt();
                    nuTraenere.setPinkode(svarPin);
                    break;
                case 11:
                    System.out.println("Retunerer til træner menu");
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
        int svarHold = scanner.nextInt();


        //Fjerner det tidligere hold ud fra indeks nul og tilføjer det nye
        nuTraenere.getHoldene().set(0, db.getHoldene().get(--svarHold));

        System.out.print("Holdet er nu ændret");
    }

    private void visTraenere()
    {
        int i = 1;
        System.out.printf("%-10s %-40s %-30s \n", "Nr.", "Navn", "Hold", "mobilnummer");
        for (Traener traenere : db.getTraenere())
        {
            System.out.printf("%-10d %-40s %-30s %-30d\n", i, traenere.getNavn(), traenere.getHoldene().get(0).getHoldNavn(), traenere.getMobil());
            i++;
        }
    }

    private void logOut()
    {
        nuTraenere = null;
        System.out.println("\nDu er nu logget ud... Viderestiller til startsiden");
    }

}
