package domain;

/**
 *
 * @author stackOverflow
 */

public class Driver {
    private int IDCard;
    private String ime;
    private String prezime;

    public Driver(int IDCard, String ime, String prezime) {
        this.IDCard = IDCard;
        this.ime = ime;
        this.prezime = prezime;
    }

    public int getIDCard() {
        return IDCard;
    }

    public void setIDCard(int IDCard) {
        this.IDCard = IDCard;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    
    
}
