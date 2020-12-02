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
public class Address {
    public String streetInfo1,streetInfo2,city,postalCode,province,country;
    
    public Address(String st1,String st2,String city,String postCode,String prov,String country){
        streetInfo1=st1;
        streetInfo2=st2;
        this.city =city;
        postalCode=postCode;
        province=prov;
        this.country=country;
    }
    
    public String toString(){
        return "StreetInfo: "+streetInfo1+"\n"+streetInfo2+"\nCity: "+city+"\nPostal Code: "+postalCode+"\nProvince: "+province+ "\nCountry: "+country;
    }
        
}
