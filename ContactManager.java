/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_assignment2.pkg2;

/**
 *
 * @author Jeremy , Adam
 */
public class ContactManager {
    private Contact[] cList;
    private int currentContact,maxcontacts;
    
    public ContactManager(int max){
        currentContact=0;
        maxcontacts=max;
        cList = new Contact[max];
    }
    
    public boolean addContact(String firstName, String lastName, String homePhone, String workPhone, Address homeAddress, String email, String notes, MyDate birthday){
        if(currentContact<maxcontacts){
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
       public String deleteContact(String firstName, String lastName){
            String s = "";
            if(findContact(firstName, lastName) == null){
            s = "Contact not found";
            return s;
        }
            for (int i = 0; i < currentContact; i++){
            if(cList[i].getFirstName().equals(firstName) && cList[i].getLastName().equals(lastName)){
            s = "First name " + cList[i].getFirstName() + " last name " + cList[i].getLastName() + " deleted";
            cList[i] = null;
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


