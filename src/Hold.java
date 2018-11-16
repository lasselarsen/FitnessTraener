// Lavet af Nikolaj og Nadia

import java.util.ArrayList;

public class Hold
{
    private String holdNavn;
    private String kortBeskrivelse;
    private ArrayList<Traener> traenere;

    public  Hold(String holdNavn, String kortBeskrivelse)
    {
        this.holdNavn = holdNavn;
        this.kortBeskrivelse = kortBeskrivelse;
        this.traenere = new ArrayList<>();
    }

    public String getHoldNavn() {return holdNavn;}
    public void setHoldNavn(String holdNavn) {this.holdNavn = holdNavn;}

    public String getKortBeskrivelse() {return kortBeskrivelse;}
    public void setKortBeskrivelse(String kortBeskrivelse) {this.kortBeskrivelse = kortBeskrivelse;}

    public ArrayList<Traener> getTraenere() {return traenere;}
    public void setTraenere(ArrayList<Traener> traenere) {this.traenere = traenere;}

    public void addTraener(Traener traener) {traenere.add(traener);}
}
