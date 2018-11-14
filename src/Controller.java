//Lavet af Nikolaj og Nadia

import java.util.Scanner;
import java.util.ArrayList;

public class Controller
{
    private Data db;
    private Scanner scanner;
    private Traener nuTraenere;

    AdmController adm = new AdmController();
    Traener nyTraener = new Traener();

    public Controller()
    {
        this.db = new Data();
        this.scanner= new Scanner(System.in);
    }

    public void run()
    {
        int valg;
        System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------------- Velkommen til MotionCBS ----------------------");
        System.out.println("---------------------------------------------------------------------\n \n");
        System.out.println("Tast 1 - Opret traener \n Tast 2 - Log ind traener \n Tast 3 - Log ind administrator \n Tast 4 - Afslut program" );
        valg = scanner.nextInt();

        do
        {
            switch (valg)
            {
                case 1: addTraener();
                        break;
                case 2: login();
                        break;
                case 3: adm();
                        break;
                case 4: afslut();
                        break;
                default:System.out.print("Ugyldigt valg, proev igen ");
            }
        } while (afslut());
    }

    private void adm() { }


    public void addTraener()
    {
        System.out.println("\n Intast dit fulde navn: ");
        String navn = scanner.nextLine();
        scanner.nextLine();

        System.out.println("\n Intast din mail: ");
        String mail = scanner.nextLine();

        System.out.print("\n Intast dit CPR-nr: ");
        int cpr = scanner.nextInt();

        System.out.print("\n Intast din adresse: ");
        String adr = scanner.nextLine();
        scanner.nextLine();

        System.out.print("\n Intast dit mobil nr: ");
        int mobil = scanner.nextInt();

        System.out.print("\n Intast din uddannelse: ");
        String udd = scanner.nextLine();
        scanner.nextLine();

        System.out.print("\n Intast din erfaring i år: ");
        int erfaring = scanner.nextInt();

        System.out.print("\n Intast de aftale antal timer pr. maaned: ");
        double timer = scanner.nextDouble();

        System.out.print("\n Intast ny pinkode: ");
        int pinkode = scanner.nextInt();

        //printer holdmulighederne ud
        int traenereErOprettet = 0;

        do {
            System.out.print("\n Vaelg det hold du skal vaere traener paa: ");

            int i = 1;
            System.out.printf("\n %-10s %-40s %-30s\n", "Nr", "Navn", "Beskrivelse");
            for (Hold holdene : db.getHoldene()) {
                System.out.printf("%-10d %-40s %-30s\n", i, holdene.getHoldNavn(), holdene.getKortBeskrivelse());
                i++;
            }

            System.out.print("\nIntast nummeret på det hold du skal vaere traener på: ");
            int svaret = scanner.nextInt();

                switch (svaret)
                {
                    case 1:
                        opretStramOp(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode);
                        traenereErOprettet = 1;
                        break;
                    case 2:
                        opretHit(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode);
                        traenereErOprettet = 1;
                        break;
                    case 3:
                        opretSpinning(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode);
                        traenereErOprettet = 1;
                        break;
                    case 4:
                        opretCrossfit(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode);
                        traenereErOprettet = 1;
                        break;
                    default:
                        System.out.print("Ugyldigt valg - husk du skal taste 1, 2, 3 eller 4 ind- prøv igen");
                        traenereErOprettet = 0;
                }
            } while (traenereErOprettet == 0);
    }

    private void opretHit(String navn, String mail, int cpr, String adr, int mobil, String udd, int erfaring, double timer, int pinkode)
    {
        db.getTraenere().add(new Traener(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode));
        db.getTraenere().get(db.getTraenere().size()-1).addHold(db.getHoldene().get(0));

        //Tilfoejer traenere til hold Arrylisten
        db.getHoldene().get(0).addTraener(db.getTraenere().get(db.getTraenere().size()-1));

        System.out.print("Stort tillyke med oprettelsen" + navn + "\n Du er blevet tildelt holdet H.I.T. og vi er glade for, at du vil være traner hos os!");
    }

    private void opretStramOp(String navn, String mail, int cpr, String adr, int mobil, String udd, int erfaring, double timer, int pinkode)
    {
        db.getTraenere().add(new Traener(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode));
        db.getTraenere().get(db.getTraenere().size()-1).addHold(db.getHoldene().get(1));

        //Tilfoejer traenere til hold Arrylisten
        db.getHoldene().get(1).addTraener(db.getTraenere().get(db.getTraenere().size()-1));

        System.out.print("Stort tillyke med oprettelsen" + navn + "\n Du er blevet tildelt holdet Stram op og vi er glade for, at du vil være traner hos os!");
    }

    private void opretSpinning(String navn, String mail, int cpr, String adr, int mobil, String udd, int erfaring, double timer, int pinkode)
    {
        db.getTraenere().add(new Traener(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode));
        db.getTraenere().get(db.getTraenere().size()-1).addHold(db.getHoldene().get(2));

        //Tilfoejer traenere til hold Arrylisten
        db.getHoldene().get(2).addTraener(db.getTraenere().get(db.getTraenere().size()-1));

        System.out.print("Stort tillyke med oprettelsen" + navn + "\n Du er blevet tildelt holdet Spinning og vi er glade for, at du vil være traner hos os!");
    }

    private void opretCrossfit(String navn, String mail, int cpr, String adr, int mobil, String udd, int erfaring, double timer, int pinkode)
    {
        db.getTraenere().add(new Traener(navn, mail, cpr, adr, mobil, udd, erfaring, timer, pinkode));
        db.getTraenere().get(db.getTraenere().size()-1).addHold(db.getHoldene().get(3));

        //Tilfoejer traenere til hold Arrylisten
        db.getHoldene().get(3).addTraener(db.getTraenere().get(db.getTraenere().size()-1));

        System.out.print("Stort tillyke med oprettelsen" + navn + "\n Du er blevet tildelt holdet Crossfit og vi er glade for, at du vil være traner hos os!");
    }

    public void login()
    {

        //Henvisning til "AdmController class" hvor brugeren "TRÆNER" er enten er godkendt eller nægtet adgang
        //Opret userApproved ved "if (userExists) statement
        AdmController godkendtEllerNægtet = new AdmController();
        boolean userApproved = godkendtEllerNægtet.GodkendTraener();


        System.out.println("---------------------------------------------------------------------");
        System.out.println("-------------------- VELKOMMEN TIL TRAENER LOGIN --------------------");
        System.out.println("---------------------------------------------------------------------\n \n");

        while (nuTraenere == null)
        {
            System.out.print("\nIndtast dit CPR NR: ");
            int cpr = scanner.nextInt();

            System.out.print("Indtast adgangskode: ");
            int pinkode = scanner.nextInt();
            scanner.nextLine();

            if (userExists(cpr, pinkode) && userApproved)
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
                    }
                while (nuTraenere != null);
            } else {
                System.out.println("Forkerte oplysninger.. Prøv igen!");
            }
        }
    }

    private boolean userExists(int cpr, int pinkode) {

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
        System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------------- Aendre dine oplysninger  ---------------------");
        System.out.println("---------------------------------------------------------------------\n \n");

        System.out.println("Hvilke oplysninger oensker du at aendre?");
        System.out.println("Tast 1 - Navn");
        System.out.println("Tast 2 - Mail");
        System.out.println("Tast 3 - CPR-nr");
        System.out.println("Tast 4 - Adresse");
        System.out.println("Tast 5 - Mobil nr");
        System.out.println("Tast 6 - Uddannelse");
        System.out.println("Tast 7 - Erfaring");
        System.out.println("Tast 8 - Aftalte antal timer pr. maaned");
        System.out.println("Tast 9 - Pinkode");
        System.out.println("Tast 10 - Hold");
        System.out.println("Tast 11 - Tilbage til menu");
        int svar = scanner.nextInt();

         do
        {
            switch (svar)
            {
                case 1:
                    System.out.println("Indtast dit nye navn: ");
                    String svarNavn = scanner.nextLine();
                    nyTraener.setNavn(svarNavn);
                    break;
                case 2:
                    System.out.println("Indtast din nye mail: ");
                    String svarMail = scanner.nextLine();
                    nyTraener.setMail(svarMail);
                    break;
                case 3:
                    System.out.println("Indtast dit nye CPR: ");
                    int svarCpr = scanner.nextInt();
                    nyTraener.setCpr(svarCpr);
                    break;
                case 4:
                    System.out.println("Indtast din nye adresse: ");
                    String svarAdr = scanner.nextLine();
                    nyTraener.setAdresse(svarAdr);
                    break;
                case 5:
                    System.out.println("Indtast dit nye mobilnummer: ");
                    int svarMobil = scanner.nextInt();
                    nyTraener.setMobil(svarMobil);
                    break;
                case 6:
                    System.out.println("Indtast nye oplysninger om uddannelse: ");
                    String svarUdd = scanner.nextLine();
                    nyTraener.setUdd(svarUdd);
                    break;
                case 7:
                    System.out.println("Indtast ny erfaring i antal år: ");
                    int svarErf = scanner.nextInt();
                    nyTraener.setErfaring(svarErf);
                    break;
                case 8:
                    System.out.println("Indtast nye oplysninger om antal timer: ");
                    int svarTimer = scanner.nextInt();
                    nyTraener.setTimer(svarTimer);
                    break;
                case 9:
                    System.out.println("Indtast ny pinkode: ");
                    int svarPin = scanner.nextInt();
                    nyTraener.setPinkode(svarPin);
                    break;
                /*case 10:
                    System.out.println("Vælg dit nye hold");
                    ArrayList<Hold> svarHold = scanner.();
                    nyTraener.setHold(svarHold);
                    break;*/
                case 11:
                    printMenu();
                default:
                    System.out.println("Du har indtastet forkert, prøv igen.");



            }
        } while (svar!=11);
    }

    private void visTraenere()
    {
        int i = 1;
        System.out.printf("%-10s %-40s %-30s \n", "Nr.", "Navn", "Hold");
        for (Traener traenere: db.getTraenere())
        {
             System.out.printf("%-10d %-40s %-30s\n", i, traenere.getNavn(), traenere.getHold());
             i++;
        }
    }

    private void logOut() {
        nuTraenere = null;
        System.out.println("\nDu er nu logget ud... Viderestiller til startsiden");
    }


    private boolean afslut()
    {
        return false;
    }


}

