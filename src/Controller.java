import java.util.Scanner;
import java.util.ArrayList;

public class Controller
{
    private Data db;
    private Scanner scanner;
    private Traener nuTraenere;

    AdmController adm = new AdmController();
     //Traener test = new Traener();

    public Controller()
    {
        this.db = new Data();
        this.scanner= new Scanner(System.in);
    }

    public void run()
    {
        int valg;
        System.out.println("-----------------------------------------------");
        System.out.println("----------- Velkommen til MotionCBS -----------");
        System.out.println("-----------------------------------------------\n \n");
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
        } while (valg > 4 && valg < 1);
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

            int i = 0;
            System.out.printf("\n %-10s %-40s %-30s\n", "Nr", "Navn", "Beskrivelse");
            for (Hold holdene : db.getHoldene())
            {
                System.out.printf("%-10s %-40s %-30s\n", i + 1, holdene.getHoldNavn(), holdene.getKortBeskrivelse());
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
        System.out.println("****************************************");
        System.out.println("*                                      *");
        System.out.println("*     VELKOMMEN TIL TRAENER LOGIN      *");
        System.out.println("*                                      *");
        System.out.println("****************************************");

        while (nuTraenere == null)
        {
            System.out.print("\nIndtast dit CPR NR: ");
            int cpr = scanner.nextInt();

            System.out.print("Indtast adgangskode: ");
            int pinkode = scanner.nextInt();
            scanner.nextLine();

            if (userExists(cpr, pinkode))
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
        System.out.println("****************************************");
        System.out.println("*                                      *");
        System.out.println("*       AENDRE DINE OPLYSNINGER        *");
        System.out.println("*                                      *");
        System.out.println("****************************************\n\n");

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
        int svar = scanner.nextInt();

        /* do
        {
            switch (svar)
            {
                case 1:
                    test.setNavn();
                    break;
                case 2:
                    test.setMail();
                    break;
                case 3:
                    test.setCpr();
                    break;
                case 4:
                    test.setAdresse();
                    break;
                case 5:
                    test.setMobil();
                    break;
                case 6:
                    test.setUdd();
                    break;
                case 7:
                    test.setErfaring();
                    break;
                case 8:
                    test.setTimer();
                    break;
                case 9:
                    test.setPinkode();
                    break;
                case 10:
                    test.setHold();
                    break;



            }
        } while () */
    }

    private void visTraenere()
    {
        int i = 1;
        System.out.printf("%-10s %-40s %-30s \n", "Nr.", "Navn", "Hold");
        for (Traener traenere: db.getTraenere())
        {
             System.out.printf("%-10s %-40s %-30s\n", i, traenere.getNavn(), traenere.getHold());
             i++;
        }
    }

    private void logOut() {
        nuTraenere = null;
        System.out.println("\nDu er nu logget ud... Viderestiller til startsiden");
    }


    private void afslut()
    {

    }


}

