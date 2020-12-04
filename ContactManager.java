/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_assignment2.pkg2;

/**
 *
 * @author Ibrahim
 */
    import java.util.Scanner;
    

public class ContactManager {
    private Contact[] cList;
    private int currentContact,maxcontacts;
    
  public ContactManager(int max){
        currentContact=0;
        maxcontacts=max;
        cList = new Contact[max];
    }

    public Contact findContact(String firstName, String lastName){
        for (int i = 0; i < currentContact; i++){
            if(cList[i].getFirstName().equals(firstName) && cList[i].getLastName().equals(lastName)) {
                return cList[i];
            }
        }
        return null;
    }

     public Contact[] allContacts() {
        Contact[] s = new Contact[currentContact];
        for (int i = 0; i < currentContact; i++) {
            s[i] = cList[i];
        }
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
            s = "Contact " + cList[i].getFirstName() + " number " + cList[i].getHomePhone() + " deleted";
            cList[i] = null;
            currentContact ++;
            return s;
    }
    }
            s = "Contact deleted";
            return s;
    }
}
  
   
   

