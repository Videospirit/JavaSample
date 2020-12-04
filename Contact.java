/*
Project Members:
Jeremy Buchanan, 100928225
Adam Vandyke, 101023594
Ibrahim Elmi 101241704
*/

package java_assignment2.pkg2;

public class Contact {
    private String firstName,lastName,homePhone,workPhone,email,notes;
    private Address homeAddress;
    private MyDate birthday;

    public Contact(String firstName, String lastName, String homePhone, String workPhone, Address homeAddress, String email, String notes, MyDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.homeAddress = homeAddress;
        this.email = email;
        this.birthday = birthday;
        this.notes = notes;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }
   
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
        
    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getHomeAddress()
    {
        return homeAddress.toString();
    }

    public Address getAddress()
    {
        return homeAddress;
    }

    public void setAddress(Address newA)
    {
        homeAddress = newA;
    }
    
    public String getCity(){
        return homeAddress.city;
    }

    public void setHomeAddress(String streetInfo1, String streetInfo2, String province, String city, String postalCode, String country) {
        homeAddress.streetInfo1 = streetInfo1;
        homeAddress.streetInfo2 = streetInfo2;
        homeAddress.city = city;
        homeAddress.postalCode = postalCode;
        homeAddress.province = province;
        homeAddress.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getBirthday() {
        return birthday.getDay() + "/" + birthday.getMonthShortForm() + "/" + birthday.getYear();
    }

    public int getbirthday() {
        return birthday.getDay();
    }
    
    public MyDate getBirthDay()
    {
        return birthday;
    }
    
    public void setBirthDay(MyDate newD)
    {
        birthday = newD;
    }

    public void setBirthday(int birthday) {
        this.birthday.setDay(birthday);
    }

    public void setBirthMonth(int birthMonth){
        birthday.setMonth(birthMonth);
    }

    public int getBirthMonth(){
        return birthday.getMonth();
    }

    public String getBirthMonthShortForm(){
        return birthday.getMonthShortForm();
    }

    /*public String getBirthMonthLongForm(){
        return birthday.getMonthLongForm();
    }*/

    public int getBirthYear(){
        return birthday.getYear();
    }

    public void setBirthYear(int birthYear){
        birthday.setYear(birthYear);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "First Name: " + firstName + '\'' +
                ", Last Name: " + lastName + '\'' +
                ", HomePhone: " + homePhone + '\'' +
                ", WorkPhone: " + workPhone + '\'' +
                ", Address: " + homeAddress + '\'' +
                ", Email: " + email + '\'' +
                ", Notes: " + notes + '\'' +
                ", Birthdate: " + birthday +
                '}';
    }
}
