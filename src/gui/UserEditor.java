package gui;


import data.UserDA;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import smartgui.IntegerTextField;
import smartgui.PhoneTextField;
import sun.security.util.Password;
import userobjects.User;

public class UserEditor extends BorderPane {
	
	
	TextField username;
	PasswordField passwordField;
	
	TextField email;
	PhoneTextField phoneNumber;
	
	Button male;
	Button female;
	
    ComboBox<String> month;
    ComboBox<String> day;
    ComboBox<String> year;
	
    IntegerTextField height;
    IntegerTextField weight;
	
	
	Button cancelChanges;
    Button submitChanges;

    
    public UserEditor() {

    	username = new TextField(PrimaryWindow.getActiveUser().getUsername());
    	passwordField = new PasswordField();
    	
    	email = new TextField(PrimaryWindow.getActiveUser().getEmail());
    	phoneNumber = new PhoneTextField();
    	
    	male = new Button("Male");
    	female = new Button("Female");
    	
    	ObservableList<String> monthOptions =
                FXCollections.observableArrayList(
                        "January",
                        "February",
                        "March",
                        "April",
                        "May",
                        "June",
                        "July",
                        "August",
                        "September",
                        "October",
                        "November",
                        "December"
                );

        ObservableList<String> dayOptions = FXCollections.observableArrayList();
        for(int i = 1; i < 32; i++)
            dayOptions.add(Integer.toString(i));

        ObservableList<String> yearOptions = FXCollections.observableArrayList();
        for(int i = 2016; i > 1916; i--)
            yearOptions.add(Integer.toString(i));

        month = new ComboBox<>(monthOptions);
        day = new ComboBox<>(dayOptions);
        year = new ComboBox<>(yearOptions);

        HBox comboBoxHBox = new HBox(5, month, day, year);

        comboBoxHBox.setAlignment(Pos.CENTER);
    	
    	height = new IntegerTextField(PrimaryWindow.getActiveUser().getHeight());
    	weight = new IntegerTextField(PrimaryWindow.getActiveUser().getWeight());
    	
    	
    	this.setRight(new VBox(20, 
    			username, passwordField, 
    			email, phoneNumber, 
    			new HBox(male, female), 
    			height, weight));
    	
    	
    	cancelChanges = new Button("Cancel");
    	
        submitChanges = new Button("Save and Finish");
        submitChanges.setOnAction(e -> {
        	
        	User user = PrimaryWindow.getActiveUser();
        	
        	if(email.getText() != null && !email.getText().equals(""))
        		user.setEmail(email.getText());
        	if(phoneNumber.getText() != null && !phoneNumber.getText().equals(""))
        		user.setPhoneNumber(phoneNumber.getText());
        	
        	if(month.getValue() != null && day.getValue() != null && year.getValue() != null)
        		user.setDateOfBirth(month.getValue(), Integer.parseInt(day.getValue()), Integer.parseInt(year.getValue()));
        	
        	if(weight.getText() != null && !weight.getText().equals(""))
        		user.setWeight(Integer.parseInt(weight.getText()));
        	if(height.getText() != null && !height.getText().equals(""))
        		user.setHeight(Integer.parseInt(height.getText()));
        	
        	new UserDA().updateUser(PrimaryWindow.getActiveUser());
        	
            PrimaryWindow.displayMainGUI();
            
        });
        
        this.setBottom(new HBox(5, cancelChanges, submitChanges));

    }

}
