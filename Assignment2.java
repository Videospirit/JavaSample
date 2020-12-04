/*
Project Members:
Jeremy Buchanan, 100928225
Adam Vandyke, 101023594
Ibrahim Elmi 101241704
*/
package java_assignment2.pkg2;

import java.util.Arrays;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Font;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 *
 * @author Jeremy, Adam, Ibrahim
 */
public class Assignment2 extends Application {
    static ContactManager cMan;
    private TableView table = new TableView();
	
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
                if(!day.getText().equals("")&&!month.getText().equals("")&&!year.getText().equals("")){
                    if(Integer.parseInt(month.getText()) >12){
                        confirmText.setText("Your birth month must be a number between 1 and 12");
                    } else {
                        if(cMan.addContact(fName.getText(),lName.getText(),hPhone.getText(),wPhone.getText(),new Address(aSt1.getText(),aSt2.getText(),aCity.getText(),aPostCode.getText(),aProvince.getText(),aCountry.getText()),email.getText(),notes.getText(),new MyDate(Integer.parseInt(day.getText()),Integer.parseInt(month.getText()),Integer.parseInt(year.getText())))){
                            confirmText.setText(fName.getText()+" "+lName.getText()+" Has Been added succesfully");
                        } else {
                            confirmText.setText("Your Address Book is Full, please Contact Technical Support to increase the size of the Address Book");
                        }
                    }
                } else {
                    confirmText.setText("You must enter a birthday");
                }
            }
        });
        v.getChildren().addAll(confirmText,fNameBox,lNameBox,hPhoneBox,wPhoneBox,aSt1Box,aSt2Box,aCityBox,aPostCodeBox,aProvinceBox,aCountryBox,emailBox,birthday,notesBox,btnAddContact);
        
        return v;
    }
   
   
    public VBox viewAllContacts(){
        VBox v = new VBox();
        table = new TableView();
        
        final Label label = new Label("Contacts List:");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);
        
        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn phoneCol = new TableColumn("Phone");
        TableColumn homePhoneCol = new TableColumn("Home");
        homePhoneCol.setCellValueFactory(new PropertyValueFactory<>("homePhone"));
        TableColumn workPhoneCol = new TableColumn("Work");
        workPhoneCol.setCellValueFactory(new PropertyValueFactory<>("workPhone"));
        phoneCol.getColumns().addAll(homePhoneCol, workPhoneCol);

        TableColumn homeAddressCol = new TableColumn("Home Address");
        homeAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn emailCol = new TableColumn("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn birthdayCol = new TableColumn("Birthday");
        birthdayCol.setCellValueFactory(new PropertyValueFactory<>("birthday"));

        TableColumn notesCol = new TableColumn("Notes");
        notesCol.setCellValueFactory(new PropertyValueFactory<>("notes"));

        table.getColumns().addAll(firstNameCol, lastNameCol, phoneCol, homeAddressCol, emailCol, birthdayCol, notesCol);

        Contact[] contacts = cMan.allContacts();

        for (Contact c : contacts) {
            table.getItems().add(c);
        }
        v.getChildren().addAll(table);
        
        return v;
    }
  public VBox viewDeleteContact(){       
        VBox v = new VBox();
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
        Button btndeleteContact = new Button("Delete");
        Text confirmText = new Text("Please enter first and last name below to delete a contact");
        btndeleteContact.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String f = fName.getText();
                String l = lName.getText();
               
                if(cMan.findContact(f,l)!=null){
                    confirmText.setText(cMan.deleteContact(f,l));
                } else {
                    confirmText.setText(f+" "+l+" contact does not exist");
                }
               
                  
            } 
        });
        v.getChildren().addAll(confirmText,fNameBox,lNameBox,btndeleteContact);
        
        return v;
  }
         
    
 public VBox viewFindContact(){
        VBox v = new VBox();
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
        Button btnFindContact = new Button("Find Contact");
        Text confirmText = new Text("Please enter first and last name to find a contact");
        btnFindContact.setOnAction(new EventHandler<ActionEvent>() {
            
           @Override
            public void handle(ActionEvent event) {
                String f = fName.getText();
                String l = lName.getText();
             
                if(cMan.findContact(f,l)!=null){
                Contact c = cMan.findContact(f,l);
        
                    final Label label = new Label("Contacts List:");
                    label.setFont(new Font("Arial", 20));

                    table.setEditable(true);
                    
                    table.getItems().clear();
                    table.getColumns().clear();
                    
                    TableColumn firstNameCol = new TableColumn("First Name");
                    firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

                    TableColumn lastNameCol = new TableColumn("Last Name");
                    lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

                    TableColumn phoneCol = new TableColumn("Phone");
                    TableColumn homePhoneCol = new TableColumn("Home");
                    homePhoneCol.setCellValueFactory(new PropertyValueFactory<>("homePhone"));
                    TableColumn workPhoneCol = new TableColumn("Work");
                    workPhoneCol.setCellValueFactory(new PropertyValueFactory<>("workPhone"));
                    phoneCol.getColumns().addAll(homePhoneCol, workPhoneCol);

                    TableColumn homeAddressCol = new TableColumn("Home Address");
                    homeAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));

                    TableColumn emailCol = new TableColumn("Email");
                    emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

                    TableColumn birthdayCol = new TableColumn("Birthday");
                    birthdayCol.setCellValueFactory(new PropertyValueFactory<>("birthday"));

                    TableColumn notesCol = new TableColumn("Notes");
                    notesCol.setCellValueFactory(new PropertyValueFactory<>("notes"));

                    table.getColumns().addAll(firstNameCol, lastNameCol, phoneCol, homeAddressCol, emailCol, birthdayCol, notesCol);

                    
                    table.getItems().add(c);
                    

                    v.getChildren().addAll(table);
                } else {
                    confirmText.setText(f+" "+l+" could not be found.");
                }
            }
        });
        v.getChildren().addAll(confirmText,fNameBox,lNameBox,btnFindContact);
        return v;
        
    }	
    public VBox viewContactByCity(){
        VBox v = new VBox();
        table = new TableView();
        
        TextField cName=new TextField();
        Label cNameLabel=new Label("City Name: ");
        cNameLabel.setLabelFor(cName);
        HBox cNameBox = new HBox();
        cNameBox.getChildren().addAll(cNameLabel,cName);
        
        Button btnSearchContact = new Button("Submit");
        Text confirmText = new Text("Please Enter the City Name");
        btnSearchContact.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                if(cMan.findCity(cName.getText())){               
        
                    final Label label = new Label("Contacts List:");
                    label.setFont(new Font("Arial", 20));

                    table.setEditable(true);
                    
                    table.getItems().clear();
                    table.getColumns().clear();
                    
                    TableColumn firstNameCol = new TableColumn("First Name");
                    firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

                    TableColumn lastNameCol = new TableColumn("Last Name");
                    lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

                    TableColumn phoneCol = new TableColumn("Phone");
                    TableColumn homePhoneCol = new TableColumn("Home");
                    homePhoneCol.setCellValueFactory(new PropertyValueFactory<>("homePhone"));
                    TableColumn workPhoneCol = new TableColumn("Work");
                    workPhoneCol.setCellValueFactory(new PropertyValueFactory<>("workPhone"));
                    phoneCol.getColumns().addAll(homePhoneCol, workPhoneCol);

                    TableColumn homeAddressCol = new TableColumn("Home Address");
                    homeAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));

                    TableColumn emailCol = new TableColumn("Email");
                    emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

                    TableColumn birthdayCol = new TableColumn("Birthday");
                    birthdayCol.setCellValueFactory(new PropertyValueFactory<>("birthday"));

                    TableColumn notesCol = new TableColumn("Notes");
                    notesCol.setCellValueFactory(new PropertyValueFactory<>("notes"));

                    table.getColumns().addAll(firstNameCol, lastNameCol, phoneCol, homeAddressCol, emailCol, birthdayCol, notesCol);

                    Contact[] contacts = cMan.viewContactsInCity(cName.getText());

                    for (Contact c : contacts) {
                        table.getItems().add(c);
                     }

                    v.getChildren().addAll(table);
                } 
            }
        });
        v.getChildren().addAll(confirmText,cNameBox,btnSearchContact);
        return v;
    }

    public VBox viewEditContact(BorderPane root){
        VBox v = new VBox();
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
        Button btnFindContact = new Button("Find Contact");
        Text confirmText = new Text("Enter a first and last name to find that contact");
        btnFindContact.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String f = fName.getText();
                String l = lName.getText(); 
                if(cMan.findContact(f,l)!=null){
                    root.setCenter(viewEditSpecificContact(f,l));
                } else {
                    confirmText.setText(f+" "+l+" could not be found.");
                }
                  
            } 
        });
        v.getChildren().addAll(confirmText,fNameBox,lNameBox,btnFindContact);
        
        return v;
    }
    
    
    public VBox viewEditSpecificContact(String firstName,String lastName){
        VBox v = new VBox();
        Contact activeC=cMan.findContact(firstName,lastName);
        Address activeA=activeC.getAddress();
        MyDate activeB=activeC.getBirthDay();
        TextField fName=new TextField(firstName);
        Label fNameLabel=new Label("First Name: ");
        fNameLabel.setLabelFor(fName);
        HBox fNameBox = new HBox();
        fNameBox.getChildren().addAll(fNameLabel,fName);
        TextField lName=new TextField(lastName);
        Label lNameLabel=new Label("Last Name: ");
        lNameLabel.setLabelFor(lName);
        HBox lNameBox = new HBox();
        lNameBox.getChildren().addAll(lNameLabel,lName);
        TextField hPhone=new TextField(activeC.getHomePhone());
        Label hPhoneLabel=new Label("Home Phone: ");
        hPhoneLabel.setLabelFor(hPhone);
        HBox hPhoneBox = new HBox();
        hPhoneBox.getChildren().addAll(hPhoneLabel,hPhone);
        TextField wPhone=new TextField(activeC.getWorkPhone());
        Label wPhoneLabel=new Label("Work Phone: ");
        wPhoneLabel.setLabelFor(wPhone);
        HBox wPhoneBox = new HBox();
        wPhoneBox.getChildren().addAll(wPhoneLabel,wPhone);
        TextField aSt1=new TextField(activeA.streetInfo1);
        Label aSt1Label=new Label("Address Street Line 1: ");
        aSt1Label.setLabelFor(aSt1);
        HBox aSt1Box = new HBox();
        aSt1Box.getChildren().addAll(aSt1Label,aSt1);
        TextField aSt2=new TextField(activeA.streetInfo2);
        Label aSt2Label=new Label("Street Line 2: ");
        aSt2Label.setLabelFor(aSt2);
        HBox aSt2Box = new HBox();
        aSt2Box.getChildren().addAll(aSt2Label,aSt2);
        TextField aCity=new TextField(activeA.city);
        Label aCityLabel=new Label("City: ");
        aCityLabel.setLabelFor(aCity);
        HBox aCityBox = new HBox();
        aCityBox.getChildren().addAll(aCityLabel,aCity);
        TextField aPostCode=new TextField(activeA.postalCode);
        Label aPostCodeLabel=new Label("Postal Code: ");
        aPostCodeLabel.setLabelFor(aPostCode);
        HBox aPostCodeBox = new HBox();
        aPostCodeBox.getChildren().addAll(aPostCodeLabel,aPostCode);
        TextField aProvince=new TextField(activeA.province);
        Label aProvinceLabel=new Label("Province: ");
        aProvinceLabel.setLabelFor(aProvince);
        HBox aProvinceBox = new HBox();
        aProvinceBox.getChildren().addAll(aProvinceLabel,aProvince);
        TextField aCountry=new TextField(activeA.country);
        Label aCountryLabel=new Label("Country: ");
        aCountryLabel.setLabelFor(aCountry);
        HBox aCountryBox = new HBox();
        aCountryBox.getChildren().addAll(aCountryLabel,aCountry);
        TextField email=new TextField(activeC.getEmail());
        Label emailLabel=new Label("Email Address: ");
        emailLabel.setLabelFor(email);
        HBox emailBox = new HBox();
        emailBox.getChildren().addAll(emailLabel,email);
        HBox birthday = new HBox();
        // public MyDate(int d, int m ,int y){
        NumberField day = new NumberField();
        day.setText(""+activeB.getDay());
        Label dayLabel = new Label("Birthday Day: ");
        dayLabel.setLabelFor(day);
        NumberField month = new NumberField();
        month.setText(""+activeB.getMonth());
        Label monthLabel = new Label(" Month: ");
        monthLabel.setLabelFor(month);
        NumberField year = new NumberField();
        year.setText(""+activeB.getYear());
        Label yearLabel = new Label(" Year: ");
        yearLabel.setLabelFor(year);
        birthday.getChildren().addAll(dayLabel,day,monthLabel,month,yearLabel,year);
        TextField notes=new TextField(activeC.getNotes());
        Label notesLabel=new Label("Notes: ");
        notesLabel.setLabelFor(notes);
        HBox notesBox = new HBox();
        notesBox.getChildren().addAll(notesLabel,notes);
        Button btnEditContact = new Button("Save Changes");
        Text confirmText = new Text("Changes will only be applied when you hit save");
        btnEditContact.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(!day.getText().equals("")&&!month.getText().equals("")&&!year.getText().equals("")){
                    if(Integer.parseInt(month.getText()) >12){
                        confirmText.setText("Your birth month must be a number between 1 and 12");
                    } else {
                        activeC.setFirstName(fName.getText());
                        activeC.setLastName(lName.getText());
                        activeC.setHomePhone(hPhone.getText());
                        activeC.setWorkPhone(wPhone.getText());
                        activeA.streetInfo1=aSt1.getText();
                        activeA.streetInfo2=aSt2.getText();
                        activeA.city=aCity.getText();
                        activeA.postalCode=aPostCode.getText();
                        activeA.province=aProvince.getText();
                        activeA.country=aCountry.getText();
                        activeC.setAddress(activeA);
                        activeC.setEmail(email.getText());
                        activeC.setNotes(notes.getText());
                        activeB.setDay(Integer.parseInt(day.getText()));
                        activeB.setMonth(Integer.parseInt(month.getText()));
                        activeB.setYear(Integer.parseInt(year.getText()));
                        activeC.setBirthDay(activeB);
                        confirmText.setText(fName.getText()+" "+lName.getText()+" has been updated succesfully");
                    }
                } else {
                     confirmText.setText("You must enter a birthday");
                }  
            } 
        });
        v.getChildren().addAll(confirmText,fNameBox,lNameBox,hPhoneBox,wPhoneBox,aSt1Box,aSt2Box,aCityBox,aPostCodeBox,aProvinceBox,aCountryBox,emailBox,birthday,notesBox,btnEditContact);
        
        return v;
    }
    
    public void init(){
        cMan = new ContactManager(100);
        for(int x=0;x<4;x++){
            cMan.addContact("Jeremy"+x,"Buchanan","1234567890","1234567890",new Address("301 Robina Avenue","","Toronto","N0G2V0","ON","Canada"),"100928225@georgebrown.ca","I wanna be the guy",new MyDate(5,10,2007));
        }
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
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                root.setCenter(viewEditContact(root));
            }
        }); 
        
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                root.setCenter(viewDeleteContact());
            }
        });
        
        
		 btn4.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                root.setCenter(viewAllContacts());
            }
        });
         btn5.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                root.setCenter(viewFindContact());
            }
        });
        
         btn6.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                root.setCenter(viewContactByCity());
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