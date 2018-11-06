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
                                listOfBooks();
                                break;
                            case 2:
                                addBook();
                                break;
                            case 3:
                                deleteBook();
                                break;
                            case 4:
                                sellBook();
                                break;
                            case 5:
                                buyBook();
                                break;
                            case 6:
                                logOut();
                                break;
                            default:
                                System.out.println("Ugyldigt valg.");
                        }
                    }
                while (nuTraenere != null); // execute while user is still logged in (the case until the user press 6 to log out). If user chooses to log out (currentStudent = null), jump out of the do-while loop.
            } else {
                System.out.println("Forkerte oplysninger.. Prøv igen!");
            }
        }
    }

    private boolean userExists(int cpr, int pinkode) {

        for (Traener traener : db.getTraenere()) { // for each Student object (called student) in the list of getStudents() from our database instantiated as db
            if (traener.getCpr() == cpr && traener.getPinkode() == pinkode) {
                this.nuTraenere = traener;
                return true;

                /* Comments to: this.currentStudent = student; (as the name of the student objects are not equal in this case, you don't necessarily need "this.". However, using "this." makes it clear that you refer to a global variable.

                   Global variables ==> variables that are declared outside a function making it possible to access (use) the variable anywhere in the program.
                   Can be used in the class just by invoking it - but also in other classes by defining a getter to get the private attribute as from the model classes.

                   Local variables ==> variables that are declared inside a function and can be used only inside that function.

                   Assigning the global variable to the local variable (in this case in line 78s: the global Student object equal to the local Student object found from the for loop,
                   makes it possible to access (use) the local variable in the rest of the program (as long as you invoke the method assigning the global variable to the local variable at first,
                   otherwise a NullPointerException will be thrown. This is the reason we validate "if (userExists)" before invoking currentStudent.getUserName() method).
                   Without doing so, currentStudent will remain as null (without values for userName, password etc.) and can only be used for checking whether currentStudent is null or not (e.g. for login).

                   ____________________________

                   This is exactly the same case as when you assign your global variables to your local variables in your model class setters and set constructors.
                   E.g. this.title = title;

                   "this.title" is used to refer to the global variable title (to be used anywhere in the program) - assigning it to the local variable with the same name
                   (making it possible to use the local variable anywhere in the program).
                */
            }
        }
        return false;
    }

    private void printMenu() {
        System.out.println("\nDu har nu følgende valgmuligheder: \n");
        System.out.println("1) Ændre dine oplysninger");
        System.out.println("2) Vis trænere kategoriseret efter holdtype");
        System.out.println("3) Log ud");

    }

    private void listOfBooks() {

        if (nuTraenere.getBooks().isEmpty()) { // same as: currentStudent.getBooks().size == 0.
            System.out.println("Ingen bøger blev fundet i din bogsamling..");
        } else { // We only want an overview of our books / a for loop printing our books - as long as we have any books in our personal list, otherwise it makes no sense.
            int i = 1;

            System.out.printf("%-10s %-40s %-30s %-20s\n", "Nr.", "Titel:", "Forfatter(e):", "Pris:");
            for (Book book : currentStudent.getBooks()) {
                System.out.printf("%-10d %-40s %-30s %-20.2f\n", i, book.getTitle(), book.getAuthor(), book.getPrice());
                i++;
            }
        }
    }

    private void listOfMarketPlaceBooks() {
        int i = 1;

        if (!db.getMarketPlace().isEmpty()) { // if list of books in the marketplace is NOT empty (!).
            System.out.printf("%-10s %-40s %-30s %-20s\n", "Nr.", "Titel:", "Forfatter(e):", "Pris:");
            for (Book book : db.getMarketPlace()) {
                System.out.printf("%-10d %-40s %-30s %-20.2f\n", i, book.getTitle(), book.getAuthor(), book.getPrice());
                i++;
            }
        } else {
            System.out.println("Der er ingen brugte bøger til salg i øjeblikket.. Desværre!");
        }
    }

    private void addBook() {
        System.out.print("\nIndtast bogens titel: ");
        String title = scanner.nextLine();

        System.out.print("\nIndtast bogens forfatter(e): ");
        String author = scanner.nextLine();

        System.out.print("\nIndtast bogens pris: ");
        double price = scanner.nextDouble();

        currentStudent.getBooks().add(new Book(title, author, price));
        System.out.println("Bogen er nu tilføjet til din samling. Vender tilbage til hovedmenuen...");
    }

    private void deleteBook() {
        listOfBooks();

        if (!currentStudent.getBooks().isEmpty()) {
            System.out.println("\nIndtast nummeret på bogen som skal slettes:");
            int bookNo = scanner.nextInt();
            Book bookToDelete = currentStudent.getBooks().get(--bookNo); // book number starts with 1, index starts with 0. We need the index of the book to sell, hence --bookNo as pre-decrement returns bookNo-1.
            currentStudent.getBooks().remove(bookToDelete);
            System.out.println("Bogen '" + bookToDelete.getTitle() + "' er nu slettet fra din samling. Vender tilbage til hovedmenuen...");
        }
    }

    private void sellBook() {
        listOfBooks();

        if (!currentStudent.getBooks().isEmpty()) { // you can't sell any books if you don't have any books stored in your getBooks() arrayList.
            System.out.println("\nIndtast nummeret på bogen som skal sælges:");
            int bookNo = scanner.nextInt();
            Book bookToSell = currentStudent.getBooks().get(--bookNo); // book number starts with 1, index starts with 0. We need the index of the book to sell, hence --bookNo as pre-decrement returns bookNo-1.

            System.out.println("Hvilken pris vil du sælge bogen til?");
            double sellingPrice = scanner.nextDouble();
            bookToSell.setPrice(sellingPrice); // setting new price for the book to sell by using one of our set methods.

            db.getMarketPlace().add(bookToSell); // adding the book object to the market place of books.
            currentStudent.getBooks().remove(bookToSell); // removing the book object from currentStudent's personal list of books.
            System.out.printf("Bogen '%s' er nu sat til salg for %.2f kroner. \n", bookToSell.getTitle(), bookToSell.getPrice());
        }
    }

    private void buyBook() {
        listOfMarketPlaceBooks();

        if (!db.getMarketPlace().isEmpty()) { // if market place arrayList is NOT empty
            System.out.println("\nIndtast nummeret på bogen som skal købes:");
            int bookNo = scanner.nextInt();
            Book bookToBuy = db.getMarketPlace().get(--bookNo);

            currentStudent.getBooks().add(bookToBuy);
            db.getMarketPlace().remove(bookToBuy);

            System.out.println("Bogen er nu blevet købt.. Find den i din personlige liste med det samme!");
        }
    }

    private void logOut() {
        nuTraenere = null; // nullifying the currentStudent object resets the login args / values of the currentStudent object.
        System.out.println("\nDu er nu logget ud... Viderestiller til login.");
    }

}

