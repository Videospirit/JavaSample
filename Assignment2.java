/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_assignment2.pkg2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
/**
 *
 * @author Jeremy
 */
public class Assignment2 extends Application {
    static ContactManager cMan;
    
    public Text viewWelcome(){
        Text t = new Text("Welcome to the Java Assignment 2 Project");
        return t;
    }
    
    public VBox viewAddContact(){
        VBox v = new VBox();
        // addContact(String firstName, String lastName, String homePhone, String workPhone, Address homeAddress,
        //String email, String notes, MyDate birthday){
        //public Address(String st1,String st2,String city,String postCode,String prov,String country){
    
        
        TextField fName=new TextField();
        Label fNameLabel=new Label("First Name: ");
        fNameLabel.setLabelFor(fName);
        HBox fNameBox = new HBox();
        fNameBox.getChildren().addAll(fNameLabel,fName);
        TextField lName=new TextField();
        Label lNameLabel=new Label("Last Name: ");
        lNameLabel.setLabelFor(lName);
        HBox lNameBox = new HBox();
        lNameBox.getChildren().addAll(lNameLabel,lName);
        TextField hPhone=new TextField();
        Label hPhoneLabel=new Label("Home Phone: ");
        hPhoneLabel.setLabelFor(hPhone);
        HBox hPhoneBox = new HBox();
        hPhoneBox.getChildren().addAll(hPhoneLabel,hPhone);
        TextField wPhone=new TextField();
        Label wPhoneLabel=new Label("Work Phone: ");
        wPhoneLabel.setLabelFor(wPhone);
        HBox wPhoneBox = new HBox();
        wPhoneBox.getChildren().addAll(wPhoneLabel,wPhone);
        TextField aSt1=new TextField();
        Label aSt1Label=new Label("Address Street Line 1: ");
        aSt1Label.setLabelFor(aSt1);
        HBox aSt1Box = new HBox();
        aSt1Box.getChildren().addAll(aSt1Label,aSt1);
        TextField aSt2=new TextField();
        Label aSt2Label=new Label("Street Line 2: ");
        aSt2Label.setLabelFor(aSt2);
        HBox aSt2Box = new HBox();
        aSt2Box.getChildren().addAll(aSt2Label,aSt2);
        TextField aCity=new TextField();
        Label aCityLabel=new Label("City: ");
        aCityLabel.setLabelFor(aCity);
        HBox aCityBox = new HBox();
        aCityBox.getChildren().addAll(aCityLabel,aCity);
        TextField aPostCode=new TextField();
        Label aPostCodeLabel=new Label("Postal Code: ");
        aPostCodeLabel.setLabelFor(aPostCode);
        HBox aPostCodeBox = new HBox();
        aPostCodeBox.getChildren().addAll(aPostCodeLabel,aPostCode);
        TextField aProvince=new TextField();
        Label aProvinceLabel=new Label("Province: ");
        aProvinceLabel.setLabelFor(aProvince);
        HBox aProvinceBox = new HBox();
        aProvinceBox.getChildren().addAll(aProvinceLabel,aProvince);
        TextField aCountry=new TextField();
        Label aCountryLabel=new Label("Country: ");
        aCountryLabel.setLabelFor(aCountry);
        HBox aCountryBox = new HBox();
        aCountryBox.getChildren().addAll(aCountryLabel,aCountry);
        TextField email=new TextField();
        Label emailLabel=new Label("Email Address: ");
        emailLabel.setLabelFor(email);
        HBox emailBox = new HBox();
        emailBox.getChildren().addAll(emailLabel,email);
        HBox birthday = new HBox();
        // public MyDate(int d, int m ,int y){
        NumberField day = new NumberField();
        Label dayLabel = new Label("Birthday Day: ");
        dayLabel.setLabelFor(day);
        NumberField month = new NumberField();
        Label monthLabel = new Label(" Month: ");
        monthLabel.setLabelFor(month);
        NumberField year = new NumberField();
        Label yearLabel = new Label(" Year: ");
        yearLabel.setLabelFor(year);
        birthday.getChildren().addAll(dayLabel,day,monthLabel,month,yearLabel,year);
        TextField notes=new TextField();
        Label notesLabel=new Label("Notes: ");
        notesLabel.setLabelFor(notes);
        HBox notesBox = new HBox();
        notesBox.getChildren().addAll(notesLabel,notes);
        Button btnAddContact = new Button("Submit");
        Text confirmText = new Text("Please Enter the Contact Information");
        btnAddContact.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(cMan.addContact(fName.getText(),lName.getText(),hPhone.getText(),wPhone.getText(),new Address(aSt1.getText(),aSt2.getText(),aCity.getText(),aPostCode.getText(),aProvince.getText(),aCountry.getText()),email.getText(),notes.getText(),new MyDate(Integer.parseInt(day.getText()),Integer.parseInt(month.getText()),Integer.parseInt(year.getText())))){
                    confirmText.setText(fName.getText()+" "+lName.getText()+" Has Been added succesfully");
                } else {
                    confirmText.setText("Your Address Book is Full, please Contact Technical Support to increase the size of the Address Book");
                }
            }
        });
        v.getChildren().addAll(confirmText,fNameBox,lNameBox,hPhoneBox,wPhoneBox,aSt1Box,aSt2Box,aPostCodeBox,aProvinceBox,aCountryBox,emailBox,birthday,notesBox,btnAddContact);
        
        return v;
    }
    
    public void init(){
        cMan = new ContactManager(100);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button();
        btn1.setText("Add Contact");
        Button btn2 = new Button();
        btn2.setText("Edit Contact");
        Button btn3 = new Button();
        btn3.setText("Delete Contact");
        Button btn4 = new Button();
        btn4.setText("View all Contacts");
        Button btn5 = new Button();
        btn5.setText("Find Contact");
        Button btn6 = new Button();
        btn6.setText("View Contacts in a City");
        BorderPane root = new BorderPane();
        HBox menu = new HBox();
        menu.getChildren().addAll(btn1,btn2,btn3,btn4,btn5,btn6);
        root.setTop(menu);
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                root.setCenter(viewAddContact());
            }
        });
        
        Scene scene = new Scene(root, 900, 900);
        
        primaryStage.setTitle("Java Assignment 2");
        primaryStage.setScene(scene);
        primaryStage.show();
        root.setCenter(viewWelcome());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
