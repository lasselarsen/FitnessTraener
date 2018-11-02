import java.util.Scanner;

public class Controller
{
    private Data db;
    private Scanner scanner;
    private Traener nuTraenere;

    public Controller()
    {
        this.db = db;
        this.scanner= new Scanner(System.in);
    }

    public void run()
    {
        int valg;
        System.out.println("----------- Velkommen til MotionCBS ----------- \n \n");
        System.out.println("Tast 1 - Opret ny træner \n Tast 2 - Log ind");
        valg = scanner.nextInt();

        do {
            switch (valg)
            {
                case 1: addTraener();
                    break;
                case 2: login();
                    break;
                default:System.out.print("Ugyldigt valg, prøv igen ");
            }
        } while (valg != 1 || valg != 2);

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
    }

    public void login()
    {

    }

}
