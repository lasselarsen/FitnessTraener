import java.util.Scanner;
import java.util.ArrayList;

public class Controller
{
    private Data db;
    private Scanner scanner;
    private Traener nuTraenere;

    AdmController adm = new AdmController();

    public Controller()
    {
        this.db = db;
        this.scanner= new Scanner(System.in);
    }

    public void run()
    {
        int valg;
        System.out.println("-----------------------------------------------");
        System.out.println("----------- Velkommen til MotionCBS -----------");
        System.out.println("-----------------------------------------------\n \n");
        System.out.println("Tast 1 - Opret traener \n Tast 2 - Log ind traener \n Tast 3 - Log ind administrator");
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
                default:System.out.print("Ugyldigt valg, proev igen ");
            }
        } while (valg > 3 && valg < 1);
    }


    public void addTraener()
    {
        System.out.print("\n Intast dit fulde navn: ");
        String navn = scanner.nextLine();

        System.out.print("\n Intast din mail: ");
        String mail = scanner.nextLine();

        System.out.print("\n Intast dit CPR-nr: ");
        int cpr = scanner.nextInt();

        System.out.print("\n Intast din adresse: ");
        String adr = scanner.nextLine();

        System.out.print("\n Intast dit mobil nr: ");
        int mobil = scanner.nextInt();

        System.out.print("\n Intast din uddannelse: ");
        String udd = scanner.nextLine();

        System.out.print("\n Intast din erfaring: ");
        String erfaring = scanner.nextLine();

        System.out.print("\n Intast de aftale antal timer pr. maaned: ");
        double timer = scanner.nextDouble();

        System.out.print("\n Intast ny pinkode: ");
        int pinkode = scanner.nextInt();

        System.out.print("\n Vælg nu dit hold \n Tast 1 - Stram op \n Tast 2 - H.I.T. \n Tast 3 - Spinning \n Tast 4 - Crossfit ");
        int hold = scanner.nextInt();

        /* switch (hold) {
            case 1: hold[0];
                    break;
            case 2: hold[1];
                    break;
            case 3: hold[2];
                    break;
            case 4: hold[3];
                    break;
            default: system.out.print("Du har tastet forkert, prøv venligst igen");

        }*/

        System.out.print("Du er nu oprettet og vil blive godkendt hurtigst muligt");

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

        do
        {
            switch (svar)
            {
                case 1:
                    hej
                    break;
                case 2:
                    hej
                    break;
                case 3:
                    hej
                    break;
                case 4:
                    hej
                    break;
                case 5:
                    hej
                    break;
                case 6:
                    hej
                    break;
                case 7:
                    hej
                    break;
                case 8:
                    hej
                    break;
                case 9:
                    hej
                    break;
                case 10:
                    hej
                    break;



            }
        }
    }

    private void visTraenere()
    {

    }

    private void logOut() {
        nuTraenere = null; // nullifying the currentStudent object resets the login args / values of the currentStudent object.
        System.out.println("\nDu er nu logget ud... Viderestiller til login.");
    }

}

