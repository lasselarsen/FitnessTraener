//Lavet af Lasse og Christian


//Vi opretter en offentlig klasse, med attributter der tilhører administratoren.
public class Adm
{
    private int admID;
    private int admKode;
    private String admnavn;

    //Her laver vi en offentlig constructor og sætter this. til vores attributter .
    public Adm(int admID, int admKode, String admnavn)
    {
        this.admID = admID;
        this.admKode = admKode;
        this.admnavn = admnavn;
    }

    // Get og set metoder
    public void setAdmID(int admID) {this.admID = admID;}
    public int getAdmID() {return admID;}

    public void setAdmKode(int admKode) {this.admKode = admKode;}
    public int getAdmKode() {return admKode;}

    public void setAdmnavn(String admnavn) {this.admnavn = admnavn;}
    public String getAdmnavn() {return admnavn;}
}


