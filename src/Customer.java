
public class Customer {

    private int Id;
    private String Name;
    private String Surname;
    private String Email;
    private String PhoneNumber;


    public Customer(int id, String name, String surname, String email, String phoneNumber) {
        this.Id = id;
        this.Name = name;
        this.Surname = surname;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
