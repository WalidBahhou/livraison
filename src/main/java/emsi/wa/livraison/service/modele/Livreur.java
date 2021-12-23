package emsi.wa.livraison.service.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livreur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long livreurID;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Livreur(String firstName, String lastName, String phoneNumber) {
        this.livreurID = livreurID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Livreur() {
    }

    public Long getLivreurID() {
        return livreurID;
    }

    public void setLivreurID(Long livreurID) {
        this.livreurID = livreurID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Livreur{" +
                "livreurID=" + livreurID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
