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
        System.out.println("Tast 1 - Opret træner \n Tast 2 - Log ind \n Tast 3 - administrator");
        valg = scanner.nextInt();

        do {
            switch (valg)
            {
                case 1: addTraener();
                        break;
                case 2: login();
                        break;
                case 3: adm();
                        break;
                default:System.out.print("Ugyldigt valg, prøv igen ");
            }
        } while (valg > 3 && valg < 1);
    }


    public void addTraener()
    {
        System.out.print("\n Intast dit fulde navn: ");
        String navn = scanner.nextLine();

        System.out.print("\n Intast din mail: ");
        String mail = scanner.nextLine();

        System.out.print("\n Intast dit CPR-nummer: ");
        int cpr = scanner.nextInt();

        System.out.print("\n Intast din adresse: ");
        String adr = scanner.nextLine();

        System.out.print("\n Intast dit mobil nr: ");
        int mobil = scanner.nextInt();

        System.out.print("\n Intast din uddannelse: ");
        String udd = scanner.nextLine();

        System.out.print("\n Intast din erfaring: ");
        String erfaring = scanner.nextLine();

        System.out.print("\n Intast de aftale tantal timer pr. måned: ");
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

    }

}
