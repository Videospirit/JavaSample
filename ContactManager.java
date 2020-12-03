/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_assignment2.pkg2;

/**
 *
 * @author Jeremy
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
    
}
