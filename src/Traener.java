// Lavet af Nadia og Nikolaj


import java.util.ArrayList;

public class Traener
{
    private String navn;
    private String mail;
    private int cpr;
    private String adresse;
    private int mobil;
    private String udd;
    private int erfaring;
    private double timer;
    private int pinkode;
    private ArrayList<Hold> holdene;
    private boolean isApproved;

    //Her oprettes en konstructor
    public Traener(String navn, String mail, int cpr, String adresse, int mobil,
                   String udd, int erfaring, double timer, int pinkode, boolean isApproved)
    {
        this.navn = navn;
        this.mail = mail;
        this.cpr=cpr;
        this.adresse = adresse;
        this.mobil = mobil;
        this.udd = udd;
        this.erfaring = erfaring;
        this.timer = timer;
        this.pinkode = pinkode;
        this.holdene = new ArrayList<>();
        this.isApproved = isApproved;
    }

    public Traener(){}

    //Der oprettes get og set metoder
    public String getNavn() {return navn;}
    public void setNavn(String navn) {this.navn = navn;}

    public String getMail() {return mail;}
    public void setMail(String mail) {this.mail = mail;}

    public int getCpr() {return cpr;}
    public void setCpr(int cpr) {this.cpr = cpr;}

    public String getAdresse() {return adresse;}
    public void setAdresse(String adresse) {this.adresse = adresse;}

    public int getMobil() {return mobil;}
    public void setMobil(int mobil) {this.mobil = mobil;}

    public String getUdd() {return udd;}
    public void setUdd(String udd) {this.udd = udd;}

    public int getErfaring() {return erfaring;}
    public void setErfaring(int erfaring) {this.erfaring = erfaring;}

    public double getTimer() {return timer;}
    public void setTimer(double timer) {this.timer = timer;}

    public int getPinkode() {return pinkode;}
    public void setPinkode(int pinkode) {this.pinkode = pinkode;}

    public ArrayList<Hold> getHoldene () {return holdene;}
    public void setHoldene (ArrayList<Hold> holdene) {this.holdene = holdene;}

    public boolean getIsApproved() {return isApproved;}
    public void setIsApproved(boolean isApproved) {this.isApproved = isApproved;}

    // Andre metoder
    public void addHold(Hold hold) {holdene.add(hold);}


}
