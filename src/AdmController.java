import java.util.ArrayList;
import java.util.Scanner;

public class AdmController
{

    private Data db;
    private Scanner scanner;
    private Adm nuAdm;

    public AdmController()
    {
       this.db = new Data();
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
        System.out.println("1) Ændr træner oplysninger");
        System.out.println("2) Godkend nye trænere");
        System.out.println("3) Slet trænere");
        System.out.println("4) Vis alle oplysninger om en bestemt træner");
        System.out.println("5) Vis alle oplysninger om trænere af en bestem holdtype");
        System.out.println("6) Vis trænere kategoriseret efter holdtype");
        System.out.println("7) Vis statistik over arbejdsfordelingen på trænerne");
        System.out.println("8) Log ud");

    }

    private void TraenerListe()
    {
        System.out.printf("%-10s %-40s %-30s %-20s %-30s %-30s %-30s %-30s %-30s %-30s %-30s\n",
                "Nr.", "Navn:", "Mail:", "CPR:", "Adresse:", "Mobil:", "Uddannelse:",
                "Erfaring:", "Timer:", "Pinkoder:", "Hold");
        for (Traener traener: db.getTraenere())
        {
            System.out.println(traener);
        }
    }


    private void AendreOplysninger()
    {
        TraenerListe();

    }

    public void GodkendTraener()
    {
        TraenerListe();
        System.out.print("\n Indtast nummeret på træneren");
        int traenerNr = scanner.nextInt();
        traenerNr = db.getTraenere // ???

        System.out.println("Skal træneren godkendes? (svar med: y / n)");
        char svar = scanner.next().charAt(0);
        if (svar == 'y')
            //Godkend træner ved "Login" i Controller class
            //Opret godkendelsesMetode

        else if (svar == 'n')
            db.getTraenere().remove(db.getTraenere());
        }


    private void SletTraener()
    {
        TraenerListe();
        System.out.println("\nIndtast nummeret på den træner som skal slettes:");
        int traenernr = scanner.nextInt();
        Traener traenerToDelete = db.getTraenere().get(--traenernr); // book number starts with 1, index starts with 0. We need the index of the book to sell, hence --bookNo as pre-decrement returns bookNo-1.
        db.getTraenere().remove(traenerToDelete);
        System.out.println("Bogen '" + traenerToDelete.getNavn() + "' er nu slettet fra din samling. Vender tilbage til hovedmenuen...");
    }

    private void bestemtTraener()
    {


    }

    private void BestemtHoldtype()
    {

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

    private void Arbejdsfordeling()
    {

    }

    private void logOut()
    {
        nuAdm = null; // nullifying the currentStudent object resets the login args / values of the currentStudent object.
        System.out.println("\nDu er nu logget ud... Viderestiller til login.");
    }

}
