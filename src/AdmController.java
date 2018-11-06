import java.util.Scanner;

public class AdmController
{

    private Data db;
    private Scanner scanner;
    private Adm nuAdm;

    public AdmController()
    {
       this.db = db;
       this.scanner = new Scanner(System.in);
    }


    public void administratorMenu()
    {
        System.out.println("****************************************");
        System.out.println("*                                      *");
        System.out.println("*    VELKOMMEN TIL ADMINISTRATIONEN    *");
        System.out.println("*                                      *");
        System.out.println("****************************************");

            while (nuAdm == null)
            {
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
                                visTraenere();
                                break;
                            case 7:
                                Arbejdsfordeling();
                                break;
                            case 8:
                                logOut();
                                break;
                            default:
                                System.out.println("Ugyldigt valg.");
                        }
                    }
                    while (nuAdm != null);
                } else {
                    System.out.println("Forkerte oplysninger.. Prøv igen!");
                }
            }
        }

    private boolean userExists(int admID, int pinkode) {

        for (Adm adm : db.getAdministratore())
        {
            if (adm.getAdmID() == admID && adm.getAdmKode() == pinkode)
            {
                this.nuAdm = adm;
                return true;
            }
        }
        return false;
    }

    private void printMenu()
    {
        System.out.println("\nDu har nu følgende valgmuligheder: \n");
        System.out.println("1) Ændre dine oplysninger");
        System.out.println("2) Godkend nye trænere");
        System.out.println("3) Slet trænere");
        System.out.println("4) Vis alle oplysninger om en bestemt træner");
        System.out.println("5) Vis alle oplysninger om trænere af en bestem holdtype");
        System.out.println("6) Vis trænere kategoriseret efter holdtype");
        System.out.println("7) Vis statistik over arbejdsfordelingen på trænerne");
        System.out.println("8) Log ud");

    }

    private void AendreOplysninger()
    {

    }

    private void GodkendTraener()
    {

    }

    private void SletTraener()
    {

    }

    private void bestemtTraener()
    {

    }

    private void BestemtHoldtype()
    {

    }

    private void visTraenere()
    {

    }

    private void Arbejdsfordeling()
    {

    }

    private void logOut()
    {
        nuAdm = null; // nullifying the currentStudent object resets the login args / values of the currentStudent object.
        System.out.println("\nDu er nu logget ud... Viderestiller til login.");
    }

}
