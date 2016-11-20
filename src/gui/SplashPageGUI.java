package gui;


import data.UserDA;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import userobjects.User;
import utilities.ResourceManager;

class SplashPageGUI extends BorderPane {

    TextField username;
    TextField password;
    Button submit;
    Button newUser;

    public SplashPageGUI() {

        //GRAPHICS    	
    	
        ImageView genie = new ImageView(ResourceManager.getResourceImage("logo.png"));
        genie.setPreserveRatio(true);
        genie.setFitHeight(200);

        //ACCOUNT INFORMATION

        username = new TextField();
        username.setPromptText("Username");
        username.setOnMouseClicked(e -> {
            username.selectAll();
        });
        username.setPadding(new Insets(5));
        username.setMaxWidth(150);

        password = new PasswordField();
        password.setPromptText("Password");
        password.setOnMouseClicked(e -> {
            password.selectAll();
        });
        password.setPadding(new Insets(5));
        password.setMaxWidth(150);

        submit = new Button("Submit");
        submit.setMaxWidth(150);

        //SUBMIT INFORMATION

        username.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER) {
                password.requestFocus();
            }
        });
        password.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER) {
                submit();
            }
        });
        submit.setOnAction(e -> {
            submit();
        });

        //CREATE A NEW USER

        newUser = new Button("New User");
        newUser.setMaxWidth(150);
        newUser.setOnAction(e -> {

            PrimaryWindow.displayNewUserGUI();

        });

        VBox center = new VBox(genie, username, password, submit, newUser);
        center.setSpacing(5);
        center.setAlignment(Pos.CENTER);
        this.setCenter(center);

    }

    public void submit() {

    	username.getStyleClass().remove("blankTextField");
    	password.getStyleClass().remove("blankTextField");

        if(username.getText().equalsIgnoreCase("") && password.getText().equalsIgnoreCase("")) {
        	
        	username.getStyleClass().add("blankTextField");
        	password.getStyleClass().add("blankTextField");
        	
        } else if (username.getText().equalsIgnoreCase("")) {
        	
        	username.getStyleClass().add("blankTextField");
        	
        } else if (password.getText().equalsIgnoreCase("")) {
        	
        	password.getStyleClass().add("blankTextField");
        	
        } else {
        	
            UserDA userDA = new UserDA();
            User account = userDA.getUserByUsername(username.getText());
                        
            if(account != null && account.isPasswordCorrect(password.getText())) {
                PrimaryWindow.setActiveUser(account);
            	PrimaryWindow.displayMainGUI();
            }

        }

    }

}