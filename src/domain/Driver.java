package domain;

/**
 *
 * @author stackOverflow
 */

public class Driver {
    private int IDCard;
    private String name;
    private String surname;

    public Driver(int IDCard, String name, String surname) {
        this.IDCard = IDCard;
        this.name = name;
        this.surname = surname;
    }

    public Driver() {
    }

    public int getIDCard() {
        return IDCard;
    }

    public void setIDCard(int IDCard) {
        this.IDCard = IDCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    
    
    
}
