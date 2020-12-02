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
    
}
