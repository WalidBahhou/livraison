package emsi.wa.livraison.domaine;

public class LivreurVO {

    private Long livreurID;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public LivreurVO() {
        super();
    }

    public LivreurVO(String firstName, String lastName, String phoneNumber) {
        super();
        this.livreurID = livreurID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
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
}
