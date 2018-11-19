//Lavet af Nikolaj og Nadia


import java.util.ArrayList;

public class Data
{
    private ArrayList<Traener> traenere;
    private ArrayList<Adm> administratore;
    private ArrayList<Hold> holdene;

    // Her oprettes en konstruktor
    public Data()
    {

        this.traenere = new ArrayList<>();
        this.administratore = new ArrayList<>();
        this.holdene = new ArrayList<>();
        generateData();
    }

    //Her oprettes eksisterende traenere i systemet og tildeles et hold
    public void generateData()
    {
        // Opretter traenere
        Traener henning = new Traener("Henning Andersen", "h.a@gmail.com", 1112700697, "Stengade 13",
                33334444, "Fysioterapeut", 12, 10, 1234, false);
        Traener anette = new Traener( "Anette Simonsen", "a.s@gmail.com", 2110850686, "Stengade 15",
                44443333, "Personlig Træner", 5, 12, 1111, false);
        Traener brian = new Traener(  "Brian Jensen", "b.j@gmail.com", 2108900687, "Husgade 15",
                88888888, "Personlig Træner", 5, 20, 2222, false);
        Traener susanne = new Traener("Susanne Nielsen", "s.n@gmail.com", 1706850896, "Murvej 5",
                12345678, "Crossfit level one", 6, 32, 3333, false);
        Traener lasse = new Traener(  "Lasse Larsen", "l.l@gmail.com", 1903970497, "Danshøjvej 1",
                22909816, "Crossfit level two", 2, 37, 4444, true);
        Traener nikolaj = new Traener("Nikolaj Olsen", "n.o@gmail.com", 1310970897, "Brøndkærvej 15",
                20463633, "Fysioterapeut", 3, 38, 8888, true);
        Traener christi = new Traener("Christian Adrian", "c.a@gmail.com", 1208970913, "Hyldebjergallé 50",
                24812080, "Personlig Træner", 4, 38, 7777, true);
        Traener nadia = new Traener(  "Nadia Nielsen", "n.n@gmail.com", 2, "Limfjordsvej 43",
                61602630, "Tidl. cykelrytter", 2, 39.5, 2, true);

        // Tilføjer traenerne til Arraylisten
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

        // Tilføj administrator til Arraylisten
        administratore.add(administrator);

        //Oprettelse af de 4 hold
        Hold stramOp = new Hold("Stram op","Dette hold er for dig, der elsker at løfte vægte");
        Hold hit = new Hold("H.I.T.", "Dette hold er for dig, der elsker at have pulsen oppe");
        Hold spinning = new Hold("Spinning", "Dette hold er for dig, der elsker at cykle");
        Hold crossfit = new Hold("Crossfit", "Dette hold er for dig, der elsker motion ");

        //Hold bliver tilføjet Arrylisten
        holdene.add(stramOp);
        holdene.add(hit);
        holdene.add(spinning);
        holdene.add(crossfit);

        //Traenerne faar tildelt et hold
        henning.addHold(stramOp);
        anette.addHold(stramOp);
        brian.addHold(hit);
        susanne.addHold(hit);
        lasse.addHold(spinning);
        nikolaj.addHold(spinning);
        christi.addHold(crossfit);
        nadia.addHold(crossfit);

        //Holdene faar tildelt traenere
        stramOp.addTraener(henning);
        stramOp.addTraener(anette);
        hit.addTraener(brian);
        hit.addTraener(susanne);
        spinning.addTraener(lasse);
        spinning.addTraener(nikolaj);
        crossfit.addTraener(christi);
        crossfit.addTraener(nadia);

    }


    // Set og get metode
    public ArrayList<Traener> getTraenere() {return traenere;}
    public void setTraenere(ArrayList<Traener> traenere) {this.traenere = traenere;}

    public ArrayList<Adm> getAdministratore() {return administratore;}
    public void setAdministratore(ArrayList<Adm> administratore) {this.administratore = administratore;}

    public ArrayList<Hold> getHoldene() {return holdene;}
    public void setHoldene(ArrayList<Hold> holdene) {this.holdene = holdene;}


    //Metoder
    public void addTraener(ArrayList<Traener> traenere) {this.traenere = traenere;}


}

