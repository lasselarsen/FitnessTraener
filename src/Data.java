//Lavet af Nikolaj og Nadia

import javax.xml.ws.Holder;
import java.util.ArrayList;

public class Data
{
    private ArrayList<Traener> traenere;
    private ArrayList<Adm> administratore;

    // Her oprettes en konstruktor
    public Data()
    {
        this.traenere = traenere;
    }

    //Her oprettes eksisterende traenere i systemet og tildeles et hold
    public void generateData()
    {

        // Opretter en Array med hold
        String[] hold=new String[]{"Stram op", "H.I.T.", "Spinning", "Crossfit"};

        // Opretter traenere
        Traener henning = new Traener("Henning Andersen", "h.a@gmail.com", 1112700697, "Stengade 13",
                                      33334444, "Fysioterapeut", 12, 10, 1234, hold[0]);
        Traener anette = new Traener( "Anette Simonsen", "a.s@gmail.com", 2110850686, "Stengade 15",
                                      44443333, "Personlig Traener", 5, 12, 1111, hold[0]);
        Traener brian = new Traener(  "Brian Jensen", "b.j@gmail.com", 2108900687, "Husgade 15",
                                      88888888, "Personlig Traener", 5, 20, 2222, hold[1]);
        Traener susanne = new Traener("Susanne Nielsen", "s.n@gmail.com", 1706850896, "Murvej 5",
                                      12345678, "Crossfit level one", 6, 32, 3333, hold[1]);
        Traener lasse = new Traener(  "Lasse Larsen", "l.l@gmail.com", 1903970497, "Danshojvej 1",
                                      22909816, "Crossfit level two", 2, 37, 4444, hold[2]);
        Traener nikolaj = new Traener("Nikolaj Olsen", "n.o@gmail.com", 1310970897, "Broendkaervej 15",
                                      20463633, "Fysioterapeut", 3, 38, 8888, hold[2]);
        Traener christi = new Traener("Christian Adrian", "c.a@gmail.com", 1208970887, "Hyldebjergallé 50",
                                      24812080, "Personlig Traener", 4, 38, 7777, hold[3]);
        Traener nadia = new Traener(  "Nadia Nielsen", "n.n@gmail.com", 1808980896, "Limfjordsvej 43",
                                      61602630, "Tidl. cykelrytter", 2, 39.5, 9999, hold[3]);

        // Tilføjer traenerne til Arrylisten
        traenere.add(henning);
        traenere.add(anette);
        traenere.add(brian);
        traenere.add(susanne);
        traenere.add(lasse);
        traenere.add(nikolaj);
        traenere.add(christi);
        traenere.add(nadia);

        // Opretter en administrator
        Adm administrator = new Adm(1111, 2222, "administrator");

        // Tilføj administrator til Arrylisten
        administratore.add(administrator);
    }










    // Set og get metode
    public ArrayList<Traener> getTraenere() {return traenere;}
    public void setTraenere(ArrayList<Traener> traenere) {this.traenere = traenere;}

    public ArrayList<Adm> getAdministratore() {return administratore;}
    public void setAdministratore(ArrayList<Adm> administratore) {this.administratore = administratore;}

    //Metoder
    public void addTraener(ArrayList<Traener> traenere) {this.traenere = traenere;}

}

