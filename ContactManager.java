/*
Project Members:
Jeremy Buchanan, 100928225
Adam Vandyke, 101023594
Ibrahim Elmi 101241704
*/
package java_assignment2.pkg2;

/**
 *
 * @author Jeremy , Adam, Ibrahim
 */
public class ContactManager {
    private Contact[] cList;
    //currentContact is the number of Contacts in cList. maxContacts is the maximum number
    private int currentContact,maxContacts;
    
    public ContactManager(int max){
        currentContact=0;
        maxContacts=max;
        cList = new Contact[max];
    }
    
    //Adds a new Contact to the cList array
    public boolean addContact(String firstName, String lastName, String homePhone, String workPhone, Address homeAddress, String email, String notes, MyDate birthday){
        if(currentContact<maxContacts){
            cList[currentContact]=new Contact(firstName,lastName,homePhone,workPhone,homeAddress,email,notes,birthday); 
            currentContact++;
            return true;
        }
        return false;
    }
    
    public Contact[] allContacts() {
        Contact[] s = new Contact[currentContact];
        for (int i = 0; i < currentContact; i++) {
            s[i] = cList[i];
        }
        return s;
    }
    
    public Contact findContact(String firstName, String lastName){
        for (int i = 0; i < currentContact; i++){
            if(cList[i].getFirstName().equals(firstName) && cList[i].getLastName().equals(lastName)) {
                return cList[i];
            }
        }
        return null;
    }
    
    public Contact[] showContact(String firstName, String lastName){
        Contact[] s = new Contact[currentContact];
        for ( int i = 0; i < currentContact; i++){
            if(cList[i].getFirstName().equals(firstName) && cList[i].getLastName().equals(lastName)) {
                s[i] = cList[i];
            }
        }
        return s;
    }
    
    public boolean findCity(String city){
        Contact[] s = new Contact[currentContact];
        for ( int i = 0; i < currentContact; i++){
            if(cList[i].getCity().equals(city)){
                return true;
            }
        }
        return false;
    }
       public boolean findContact(String firstname){
        Contact[] s = new Contact[currentContact];
        for ( int i = 0; i < currentContact; i++){
            if(cList[i].getFirstName().equals(firstname)){
                return true;
            }
        }
        return false;
    }

    
    public String deleteContact(String firstName, String lastName){
        String s = "";
        if(findContact(firstName, lastName) == null){
            s = "Contact not found";
            return s;
        }
        for (int i = 0; i < currentContact; i++){
            if(cList[i].getFirstName().equals(firstName) && cList[i].getLastName().equals(lastName)){
                s = "First name " + cList[i].getFirstName() + " last name " + cList[i].getLastName() + " deleted";
                cList[i] = cList[currentContact-1];
                currentContact --;
                return s;
            }
        }
        s = "Contact deleted";
        return s;
    }

    public Contact[] viewContactsInCity(String city){
        Contact[] s = new Contact[currentContact];
        for ( int i = 0; i < currentContact; i++){
            if(cList[i].getCity().equals(city)){
                s[i] = cList[i];
            }
        }
        return s;
    }
}

   


