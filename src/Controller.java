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

        switch (valg)
        {
            case 1: addTraener();
                    break;
            case 2: login();
                    break;
            default:System.out.print("Ugyldigt valg, prøv igen ");
        }

    }


    public void addTraener()
    {
        System.out.print("\n Intast dit fulde navn: ");
        String navn = scanner.nextLine();

        System.out.print("\n Intast din mail: ");
        String mail = scanner.nextLine();

    }

    public void login()
    {

    }

}
