//Lavet af Nikolaj og Nadia

import java.util.ArrayList;

public class Data
{
    private ArrayList<Hold> holdListe;
    private ArrayList<Traener> traenere;

    // Her oprettes en konstruktor
    public Data()
    {
        this.holdListe = holdListe;
        this.traenere = traenere;
    }

    //Her oprettes eksisterende traenere i systemet
    private void generateData()
    {
        Traener henning = new Traener("Henning Andersen", "h.a@gmail.com", 1112700697, "Stengade 13",
                                      33334444, "H.I.T.", "Fysioterapeut", 12, 10, 1234);
        Traener anette = new Traener( "Anette Simonsen", "a.s@gmail.com", 2110850686, "Stengade 15",
                                      44443333, "Stram op", "Personlig Traener", 5, 12, 1111);
        Traener brian = new Traener(  "Brian Jensen", "b.j@gmail.com", 2108900687, "Husgade 15",
                                      88888888, "Spinning", "Personlig Traener", 5, 20, 2222);
        Traener susanne = new Traener("Susanne Nielsen", "s.n@gmail.com", 1706850896, "Murvej 5",
                                      12345678, "Crossfit", "Crossfit level one", 6, 32, 3333);
        Traener lasse = new Traener(  "Lasse Larsen", "l.l@gmail.com", 1903970497, "Danshojvej 1",
                                      22909816, "Crossfit", "Crossfit level two", 2, 37, 4444);
        Traener nikolaj = new Traener("Nikolaj Olsen", "n.o@gmail.com", 1310970897, "Broendkaervej 15",
                                      20463633, "H.I.T.", "Fysioterapeut", 3, 38, 8888);
        Traener christi = new Traener("Christian Adrian", "c.a@gmail.com", 1208970887, "Hyldebjergallé 50",
                                      24812080, "Stram op", "Personlig Traener", 4, 38, 7777);
        Traener nadia = new Traener(  "Nadia Nielsen", "n.n@gmail.com", 1808980896, "Limfjordsvej 43",
                                      61602630, "Spinning", "Tidl. cykelrytter", 2, 39.5, 9999);

        // Tilføjer traenerne til Arrylisten
        traenere.add(henning);
        traenere.add(anette);
        traenere.add(brian);
        traenere.add(susanne);
        traenere.add(lasse);
        traenere.add(nikolaj);
        traenere.add(christi);
        traenere.add(nadia);



    }










    // Set og get metode
    public ArrayList<Traener> getTraenere() {return traenere;}
    public void setTraenere(ArrayList<Traener> traenere) {this.traenere = traenere;}
}
