//Lavet af Christian og lasse

import java.util.ArrayList;
import java.util.Scanner;

public class AdmController {

    private Data db;
    private Scanner scanner;
    private Adm nuAdm;
    Traener traenerToEdit = new Traener();

    public AdmController() {
        this.db = new Data();
        this.scanner = new Scanner(System.in);
    }


    public void administratorMenu() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("------------------ Velkommen til administrator menu -----------------");
        System.out.println("---------------------------------------------------------------------\n \n");

        System.out.print("\nIndtast dit ADMID: ");
        int admID = scanner.nextInt();

        System.out.print("Indtast adgangskode: ");
        int pinkode = scanner.nextInt();
        scanner.nextLine();

        if (userExists(admID, pinkode)) {
            System.out.println("\nVelkommen tilbage, " + nuAdm.getAdmnavn() + "!");
            do {
                printMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // consumes the new line left-over. An error in the Scanner object.

                switch (choice) {
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
                        visTraenereEfterHold();
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

    private boolean userExists(int admID, int pinkode) {

        for (Adm adm : db.getAdministratore()) {
            if (adm.getAdmID() == admID && adm.getAdmKode() == pinkode) {
                this.nuAdm = adm;
                return true;
            }
        }
        return false;
    }

    private void printMenu() {
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

    private void TraenerListe() {
        int i = 1;
        System.out.printf("%-10s %-40s %-30s\n", "Nr.", "Navn:", "CPR:");
        for (Traener traenere : db.getTraenere()) {
            System.out.printf("%-10d %-40s %-30s\n", i, traenere.getNavn(), traenere.getCpr());
            i++;
        }
    }

    private void ikkegodkendtTraenerListe() {
        int i = 1;
        System.out.printf("%-10s %-40s %-30s %-20s\n", "Nr.", "Navn:", "CPR:", "Status:");
        for (Traener traenere : db.getTraenere()) {
            if (traenere.getIsApproved() == false) {
                System.out.printf("%-10s %-40s %-30s %-20s\n", i, traenere.getNavn(), traenere.getCpr(), traenere.getIsApproved());
                i++;
            }
        }
    }


    private void HoldListe() {
        int i = 1;
        System.out.printf("%-10s %-40s \n", "Nr. ", "Hold: ");
        for (Hold holdene : db.getHoldene()) {
            System.out.printf("%-10d %-40s \n", i, holdene.getHoldNavn());
            i++;
        }
    }


    private void AendreOplysninger() {
        TraenerListe();

        System.out.println("Indtast nummeret på træneren: ");
        int traenerNr = scanner.nextInt();
        traenerToEdit = db.getTraenere().get(--traenerNr);
        int svar;

        do {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("---------------------- Ændre træner oplysninger  ---------------------");
            System.out.println("---------------------------------------------------------------------\n \n");

            System.out.println("Hvilke oplysninger ønsker du at ændre?");
            System.out.println("Tast 1 - Navn");
            System.out.println("Tast 2 - Mail");
            System.out.println("Tast 3 - CPR-nr");
            System.out.println("Tast 4 - Adresse");
            System.out.println("Tast 5 - Mobil nr");
            System.out.println("Tast 6 - Uddannelse");
            System.out.println("Tast 7 - Erfaring");
            System.out.println("Tast 8 - Aftalte antal timer pr. måned");
            System.out.println("Tast 9 - Pinkode");
            System.out.println("Tast 10 - Hold");
            System.out.println("Tast 11 - Tilbage til menu");
            svar = scanner.nextInt();

            switch (svar) {
                case 1:
                    System.out.println("Indtast nyt navn: ");
                    scanner.nextLine();
                    String svarNavn = scanner.nextLine();
                    traenerToEdit.setNavn(svarNavn);
                    break;
                case 2:
                    System.out.println("Indtast din nye mail: ");
                    scanner.nextLine();
                    String svarMail = scanner.nextLine();
                    traenerToEdit.setMail(svarMail);
                    break;
                case 3:
                    System.out.println("Indtast dit nye CPR: ");
                    int svarCpr = scanner.nextInt();
                    traenerToEdit.setCpr(svarCpr);
                    break;
                case 4:
                    System.out.println("Indtast din nye adresse: ");
                    scanner.nextLine();
                    String svarAdr = scanner.nextLine();
                    traenerToEdit.setAdresse(svarAdr);
                    break;
                case 5:
                    System.out.println("Indtast dit nye mobilnummer: ");
                    int svarMobil = scanner.nextInt();
                    traenerToEdit.setMobil(svarMobil);
                    break;
                case 6:
                    System.out.println("Indtast nye oplysninger om uddannelse: ");
                    scanner.nextLine();
                    String svarUdd = scanner.nextLine();
                    traenerToEdit.setUdd(svarUdd);
                    break;
                case 7:
                    System.out.println("Indtast ny erfaring i antal år: ");
                    int svarErf = scanner.nextInt();
                    traenerToEdit.setErfaring(svarErf);
                    break;
                case 8:
                    System.out.println("Indtast nye oplysninger om antal timer: ");
                    int svarTimer = scanner.nextInt();
                    traenerToEdit.setTimer(svarTimer);
                    break;
                case 9:
                    System.out.println("Indtast ny pinkode: ");
                    int svarPin = scanner.nextInt();
                    traenerToEdit.setPinkode(svarPin);
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


            } scanner.nextLine();
        } while (svar != 11);
    }


    public void GodkendTraener() {
        ikkegodkendtTraenerListe();
        System.out.println("\nIndtast nummeret på træneren: ");
        int traenerNr = scanner.nextInt();
        Traener traenertoApprove = db.getTraenere().get(--traenerNr);

        System.out.println("Skal træneren godkendes? Svar med ( y / n)");
        char svar = scanner.next().charAt(0);

        if (svar == 'y') {
            traenertoApprove.setIsApproved(true);
            System.out.println("Træneren blev godkendt!");
        } else if (svar == 'n') {
            System.out.println("Træneren blev ikke godkendt!");
        }
    }

    private void SletTraener() {
        TraenerListe();
        System.out.println("\nIndtast nummeret på den træner som skal slettes:");
        int traenernr = scanner.nextInt();
        Traener traenerToDelete = db.getTraenere().get(--traenernr); // book number starts with 1, index starts with 0. We need the index of the book to sell, hence --bookNo as pre-decrement returns bookNo-1.
        db.getTraenere().remove(traenerToDelete);
        System.out.println("Traeneren '" + traenerToDelete.getNavn() + "' er nu slettet fra systemet. Vender tilbage til hovedmenuen...");
    }

    private void bestemtTraener() {
        TraenerListe();
        System.out.println("\nIndtast nummeret på træneren for at tilgå trænerens informationer: ");
        int trænerNr = scanner.nextInt();

        Traener traenerInformation = db.getTraenere().get(--trænerNr);
        System.out.println("Navn:           \t" + traenerInformation.getNavn());
        System.out.println("Mail:           \t" + traenerInformation.getMail());
        System.out.println("CPR:            \t" + traenerInformation.getCpr());
        System.out.println("Adresse:        \t" + traenerInformation.getAdresse());
        System.out.println("Mobil:          \t" + traenerInformation.getMobil());
        System.out.println("Uddannelse:     \t" + traenerInformation.getUdd());
        System.out.println("Erfaring:       \t" + traenerInformation.getErfaring());
        System.out.println("Timer:          \t" + traenerInformation.getTimer());
        System.out.println("Pinkode:        \t" + traenerInformation.getPinkode());
        System.out.println("Godkendt?:      \t" + traenerInformation.getIsApproved());
    }

    private void BestemtHoldtype() {
        HoldListe();
        System.out.println("\nIndtast nummeret på holdet: ");
        int holdnr = scanner.nextInt();
        Hold traenerEfterHold = db.getHoldene().get(--holdnr);
        int i = 0;
        do
        {
            System.out.println("Navn:           \t" + traenerEfterHold.getTraenere().get(i).getNavn());
            System.out.println("Mail:           \t" + traenerEfterHold.getTraenere().get(i).getMail());
            System.out.println("CPR:            \t" + traenerEfterHold.getTraenere().get(i).getCpr());
            System.out.println("Adresse:        \t" + traenerEfterHold.getTraenere().get(i).getAdresse());
            System.out.println("Mobil:          \t" + traenerEfterHold.getTraenere().get(i).getMobil());
            System.out.println("Uddannelse:     \t" + traenerEfterHold.getTraenere().get(i).getUdd());
            System.out.println("Erfaring:       \t" + traenerEfterHold.getTraenere().get(i).getErfaring());
            System.out.println("Timer:          \t" + traenerEfterHold.getTraenere().get(i).getTimer());
            System.out.println("Pinkode:        \t" + traenerEfterHold.getTraenere().get(i).getPinkode());
            System.out.println("Godkendt?:      \t" + traenerEfterHold.getTraenere().get(i).getIsApproved() + "\n\n");
            i++;
        } while (i < traenerEfterHold.getTraenere().size());
    }

    private void visTraenereEfterHold() {
        ArrayList<Hold> hold = db.getHoldene();
        System.out.print("Hold:" + "\t \t \t \t Trænere:");

        int i = 0;
        int j;

        do
        {
            Hold holdene = db.getHoldene().get(i);
            System.out.print("\n"+holdene.getHoldNavn());
            j = 0;

            do {
                System.out.printf("\t \t \t "+holdene.getTraenere().get(j).getNavn() + "\n" + "\t \t");
                j++;
            } while (j < holdene.getTraenere().size());

            i++;
        } while (i < hold.size());

    }


    private void Arbejdsfordeling() {
        for (Traener traener : sortByHours()) {
            System.out.println(traener.getTimer() + "\t" + traener.getNavn());
        }
    }

    private ArrayList<Traener> sortByHours() {

        ArrayList<Traener> sortedList = new ArrayList<>();

        for (Traener traener : db.getTraenere()) {
            if (sortedList.size() == 0) {
                sortedList.add(traener);
            } else {
                int index = -1;
                for (Traener sortedTrainer : sortedList) {
                    if (sortedTrainer.getTimer() < traener.getTimer() && index == -1) {
                        index = sortedList.indexOf(sortedTrainer);
                    }
                }
                sortedList.add(index, traener);
            }
        }
        return sortedList;
    }

    private void logOut() {
        nuAdm = null; // nullifying the currentStudent object resets the login args / values of the currentStudent object.
        System.out.println("\nDu er nu logget ud... Viderestiller til login.");
    }


}
