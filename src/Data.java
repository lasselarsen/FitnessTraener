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
                33334444, "Fysioterapeut", 12, 10, 1234);

        henning.setIsApproved(false);

        Traener anette = new Traener( "Anette Simonsen", "a.s@gmail.com", 2110850686, "Stengade 15",
                44443333, "Personlig Træner", 5, 12, 1111);
        Traener brian = new Traener(  "Brian Jensen", "b.j@gmail.com", 2108900687, "Husgade 15",
                88888888, "Personlig Træner", 5, 20, 2222);
        Traener susanne = new Traener("Susanne Nielsen", "s.n@gmail.com", 1706850896, "Murvej 5",
                12345678, "Crossfit level one", 6, 32, 3333);
        Traener lasse = new Traener(  "Lasse Larsen", "l.l@gmail.com", 1903970497, "Danshøjvej 1",
                22909816, "Crossfit level two", 2, 37, 4444);
        Traener nikolaj = new Traener("Nikolaj Olsen", "n.o@gmail.com", 1310970897, "Brøndkaervej 15",
                20463633, "Fysioterapeut", 3, 38, 8888);
        Traener christi = new Traener("Christian Adrian", "c.a@gmail.com", 1208970887, "Hyldebjergallé 50",
                24812080, "Personlig Træner", 4, 38, 7777);
        Traener nadia = new Traener(  "Nadia Nielsen", "n.n@gmail.com", 1808980896, "Limfjordsvej 43",
                61602630, "Tidl. cykelrytter", 2, 39.5, 9999);

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
        Hold crossfit = new Hold("Crossfit", "Dette hold er for dig, der elsker motion");

        //Hold bliver tilføjet Arrylisten
        holdene.add(stramOp);
        holdene.add(hit);
        holdene.add(spinning);
        holdene.add(crossfit);

        //Traenerne faar tildelt et hold
        henning.addHold(hit);
        anette.addHold(spinning);
        brian.addHold(stramOp);
        susanne.addHold(crossfit);
        lasse.addHold(crossfit);
        nikolaj.addHold(hit);
        christi.addHold(stramOp);
        nadia.addHold(spinning);

        //Holdene faar tildelt traenere
        hit.addTraener(henning);
        spinning.addTraener(anette);
        stramOp.addTraener(brian);
        crossfit.addTraener(susanne);
        crossfit.addTraener(lasse);
        hit.addTraener(nikolaj);
        stramOp.addTraener(christi);
        spinning.addTraener(nadia);
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

