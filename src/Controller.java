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
        System.out.println("Velkommen til MotionCBS");
        System.out.println("Tast 1 - Opret ny træner \f Tast 2 - Log ind");
    }

}
