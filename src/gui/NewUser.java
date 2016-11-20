package gui;

import java.awt.image.BufferedImage;

import data.UserDA;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import smartgui.IntegerTextField;
import smartgui.PhoneTextField;
import userobjects.User;
import utilities.ResourceManager;

public class NewUser extends StackPane {

    private User user;

    private CreateUsernamePasswordPane createUsernamePasswordPane;
    TextField username;
    PasswordField password;
    Button submit;

    private SetPersonalInformation setPersonalInformation;
    TextField email;
    PhoneTextField phoneNumber;

    private SetUserGender setUserGender;
    Button male;
    Button female;

    private SetUserBirthday setUserBirthday;
    ComboBox<String> month;
    ComboBox<String> day;
    ComboBox<String> year;

    private SetUserBasicDetails setUserBasicDetails;
    IntegerTextField heightTextField;
    IntegerTextField weightTextField;

    private SetUserAdvancedDetails setUserAdvancedDetails;

    public NewUser() {

        createUsernamePasswordPane = new CreateUsernamePasswordPane();
        createUsernamePasswordPane.setVisible(true);

        setUserGender = new SetUserGender();
        setUserGender.setVisible(false);

        setUserBirthday = new SetUserBirthday();
        setUserBirthday.setVisible(false);

        setUserBasicDetails = new SetUserBasicDetails();
        setUserBasicDetails.setVisible(false);

        setPersonalInformation = new SetPersonalInformation();
        setPersonalInformation.setVisible(false);

        setUserAdvancedDetails = new SetUserAdvancedDetails();
        setUserAdvancedDetails.setVisible(false);

        user = new User();

        this.getChildren().addAll(createUsernamePasswordPane, setPersonalInformation, setUserGender, setUserBirthday, setUserBasicDetails, setUserAdvancedDetails);

    }

    class CreateUsernamePasswordPane extends BorderPane {

        //VARIABLES

    	Button existingUser;
    	
        public CreateUsernamePasswordPane() {

            //NODES

            ImageView genie = new ImageView(ResourceManager.getResourceImage("logo.png"));
            genie.setPreserveRatio(true);
            genie.setFitHeight(200);

            username = new TextField();
            username.setPromptText("New Username");
            username.setMaxWidth(150);

            password = new PasswordField();
            password.setPromptText("Password");
            password.setMaxWidth(150);

            submit = new Button("Submit");
            submit.setMaxWidth(150);

            existingUser = new Button("Back");
            existingUser.setMaxWidth(150);

            //ACTION

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

            existingUser.setOnAction(e -> {

                PrimaryWindow.setActiveUser(null);
                PrimaryWindow.displayWelcomeGUI();

            });

            //ADD THE NODES

            VBox center = new VBox(genie, username, password, submit, existingUser);
            center.setSpacing(5);
            center.setAlignment(Pos.CENTER);
            this.setCenter(center);

        }

        //METHODS

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

                //Does this username already exist?
                if(new UserDA().getUserByUsername(username.getText()) == null) {
                	
                    //We have a new active user! //WE NEED TO 
                    PrimaryWindow.setActiveUser(user);

                    //Our user is this person
                    user.setUsername(username.getText());
                    user.setPassword(password.getText());
                    
                    //Switch panes
                    createUsernamePasswordPane.setVisible(false);
                    setPersonalInformation.setVisible(true);
                    email.requestFocus();
                	
                } else {
                	
                	username.setText("That username already exists!");
                	username.setStyle("-fx-background-color: red;");
                	
                }
                

            }

        }

    }

    class SetPersonalInformation extends BorderPane {

        //VARIABLES

        Button forward;

        public SetPersonalInformation() {

            //INITIALIZING VARIABLES

        	Button getUserProfilePicture = new Button();
        	getUserProfilePicture.setStyle("-fx-background-color: transparent;");
        	ImageView imageView = new ImageView(ResourceManager.getResourceImage("camera-icon.png"));
        	imageView.setPreserveRatio(true);
        	imageView.setFitHeight(200);
        	imageView.setFitWidth(200);
        	getUserProfilePicture.setGraphic(imageView);
        	getUserProfilePicture.setOnAction(e -> {
        		
        		BufferedImage bufferedImage = PrimaryWindow.grabImage();
        		
        		if(bufferedImage != null) {
        			user.setPictureExtension(ResourceManager.saveImage(bufferedImage));
        			imageView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
        		}
        		        		
        	});
        	
        	
            email = new TextField();
            email.setPromptText("Email");
            email.setMaxWidth(160);

            phoneNumber = new PhoneTextField();
            phoneNumber.setPromptText("Phone Number");
            phoneNumber.setMaxWidth(160);

            //FIELD ACTIONS

            email.setOnKeyPressed(e -> {
                if(e.getCode() == KeyCode.ENTER)
                    phoneNumber.requestFocus();
            });

            //FORWARD
            forward = new Button();
            forward.setOnAction(e -> {

            	updateUser();

                setPersonalInformation.setVisible(false);
                setUserGender.setVisible(true);

            });
            ImageView rightImage = new ImageView(ResourceManager.getResourceImage("right.png"));
            rightImage.setPreserveRatio(true);
            rightImage.setFitHeight(50);
            forward.setGraphic(rightImage);
            forward.setStyle("-fx-background-color:transparent;");
            VBox right = new VBox(forward);
            right.setAlignment(Pos.CENTER);
            setRight(right);

            //ADDING NODES

            VBox centerVBox = new VBox(10, getUserProfilePicture, email, phoneNumber);
            centerVBox.setAlignment(Pos.CENTER);

            this.setCenter(centerVBox);

        }


    }

    class SetUserGender extends BorderPane {

        //VARIABLES

        Button forward;
        Button back;

        public SetUserGender() {

            //INITIALIZING VARIABLES

            male = new Button();
            male.setGraphic(new ImageView(ResourceManager.getResourceImage("male.png")));
            male.setStyle("-fx-background-color: transparent;");
            male.setAlignment(Pos.CENTER);
            male.setOnAction(e -> {

                male.setStyle("-fx-background-color: blue;");
                female.setStyle("-fx-background-color: transparent;");

                user.setGender("male");

            });

            female = new Button();
            female.setGraphic(new ImageView(ResourceManager.getResourceImage("female.png")));
            female.setStyle("-fx-background-color: transparent;");
            female.setAlignment(Pos.CENTER);
            female.setOnAction(e -> {

                female.setStyle("-fx-background-color: pink;");
                male.setStyle("-fx-background-color: transparent;");

                user.setGender("female");

            });

            HBox centerHBox = new HBox(60, male, female);
            centerHBox.setAlignment(Pos.CENTER);

            //FORWARD/BACK Button

            back = new Button();
            back.setOnAction(e -> {

                setUserGender.setVisible(false);
                setPersonalInformation.setVisible(true);

                email.requestFocus();

            });
            ImageView leftImage = new ImageView(ResourceManager.getResourceImage("left.png"));
            leftImage.setPreserveRatio(true);
            leftImage.setFitHeight(50);
            back.setGraphic(leftImage);
            back.setStyle("-fx-background-color:transparent;");
            VBox left = new VBox(back);
            left.setAlignment(Pos.CENTER);
            setLeft(left);

            forward = new Button();
            forward.setOnAction(e -> {

                setUserGender.setVisible(false);
                setUserBirthday.setVisible(true);

                month.requestFocus();

            });
            ImageView rightImage = new ImageView(ResourceManager.getResourceImage("right.png"));
            rightImage.setPreserveRatio(true);
            rightImage.setFitHeight(50);
            forward.setGraphic(rightImage);
            forward.setStyle("-fx-background-color:transparent;");
            VBox right = new VBox(forward);
            right.setAlignment(Pos.CENTER);
            setRight(right);

            //ADDING THE NODES

            this.setCenter(centerHBox);

        }

    }

    class SetUserBirthday extends  BorderPane {

        Button forward;
        Button back;

        public SetUserBirthday() {

            Label questionLabel = new Label("When were you born?");

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

            HBox comboBoxHBox = new HBox(5, questionLabel, month, day, year);

            comboBoxHBox.setAlignment(Pos.CENTER);

            setCenter(comboBoxHBox);

            back = new Button();
            back.setOnAction(e -> {

                updateUser();

                setUserBirthday.setVisible(false);
                setUserGender.setVisible(true);

            });
            ImageView leftImage = new ImageView(ResourceManager.getResourceImage("left.png"));
            leftImage.setPreserveRatio(true);
            leftImage.setFitHeight(50);
            back.setGraphic(leftImage);
            back.setStyle("-fx-background-color:transparent;");
            VBox left = new VBox(back);
            left.setAlignment(Pos.CENTER);
            setLeft(left);

            forward = new Button();
            forward.setOnAction(e -> {

                updateUser();

                setUserBirthday.setVisible(false);
                setUserBasicDetails.setVisible(true);

                heightTextField.requestFocus();

            });
            ImageView rightImage = new ImageView(ResourceManager.getResourceImage("right.png"));
            rightImage.setPreserveRatio(true);
            rightImage.setFitHeight(50);
            forward.setGraphic(rightImage);
            forward.setStyle("-fx-background-color:transparent;");
            VBox right = new VBox(forward);
            right.setAlignment(Pos.CENTER);
            setRight(right);

        }


    }

    class SetUserBasicDetails extends BorderPane {

        Button forward;
        Button back;

        public SetUserBasicDetails() {

            Label heightLabel = new Label("Enter your height (feet, inches)");
            Label weightLabel = new Label("Enter your weight (weight in pounds)");

            heightTextField = new IntegerTextField();
            weightTextField = new IntegerTextField();

            VBox heightVBox = new VBox(5, heightLabel, heightTextField);
            VBox weightVBox = new VBox(5, weightLabel, weightTextField);

            heightVBox.setAlignment(Pos.CENTER);
            weightVBox.setAlignment(Pos.CENTER);

            ImageView heightIcon = new ImageView(ResourceManager.getResourceImage("height.png"));
            ImageView weightIcon = new ImageView(ResourceManager.getResourceImage("weight.png"));
            weightIcon.setPreserveRatio(true);
            weightIcon.setFitHeight(200);

            HBox heightHBox = new HBox(10, heightVBox, heightIcon);
            HBox weightHBox = new HBox(10, weightVBox, weightIcon);

            heightHBox.setAlignment(Pos.CENTER);
            weightHBox.setAlignment(Pos.CENTER);

            HBox center = new HBox(70, heightHBox, weightHBox);

            center.setAlignment(Pos.CENTER);

            back = new Button();
            back.setOnAction(e -> {

                updateUser();

                setUserBasicDetails.setVisible(false);
                setUserBirthday.setVisible(true);

                month.requestFocus();

            });
            ImageView leftImage = new ImageView(ResourceManager.getResourceImage("left.png"));
            leftImage.setPreserveRatio(true);
            leftImage.setFitHeight(50);
            back.setGraphic(leftImage);
            back.setStyle("-fx-background-color:transparent;");
            VBox left = new VBox(back);
            left.setAlignment(Pos.CENTER);
            setLeft(left);

            forward = new Button();
            forward.setOnAction(e -> {

                updateUser();

                setUserBasicDetails.setVisible(false);
                setUserAdvancedDetails.setVisible(true);

                setUserAdvancedDetails.requestFocus();

            });
            ImageView rightImage = new ImageView(ResourceManager.getResourceImage("right.png"));
            rightImage.setPreserveRatio(true);
            rightImage.setFitHeight(50);
            forward.setGraphic(rightImage);
            forward.setStyle("-fx-background-color:transparent;");
            VBox right = new VBox(forward);
            right.setAlignment(Pos.CENTER);
            setRight(right);

            this.setCenter(center);

        }


    }

    class SetUserAdvancedDetails extends BorderPane {

        Button back;
        Button forward;

        public SetUserAdvancedDetails() {

            back = new Button();
            back.setOnAction(e -> {

            	updateUser();
            	
                setUserAdvancedDetails.setVisible(false);
                setUserBasicDetails.setVisible(true);

                heightTextField.requestFocus();

            });
            ImageView leftImage = new ImageView(ResourceManager.getResourceImage("left.png"));
            leftImage.setPreserveRatio(true);
            leftImage.setFitHeight(50);
            back.setGraphic(leftImage);
            back.setStyle("-fx-background-color:transparent;");
            VBox left = new VBox(back);
            left.setAlignment(Pos.CENTER);
            setLeft(left);

            forward = new Button();
            forward.setOnAction(e -> {

            	updateUser();
            	
            	saveUser();
            	
                PrimaryWindow.editUserGUI();

            });
            ImageView rightImage = new ImageView(ResourceManager.getResourceImage("right.png"));
            rightImage.setPreserveRatio(true);
            rightImage.setFitHeight(50);
            forward.setGraphic(rightImage);
            forward.setStyle("-fx-background-color:transparent;");
            VBox right = new VBox(forward);
            right.setAlignment(Pos.CENTER);
            setRight(right);

        }

		
    }
    
    public void updateUser() {
    	
    	if(email.getText() != null && !email.getText().equals(""))
    		user.setEmail(email.getText());
    	if(phoneNumber.getText() != null && !phoneNumber.getText().equals(""))
    		user.setPhoneNumber(phoneNumber.getText());
    	
    	if(month.getValue() != null && day.getValue() != null && year.getValue() != null)
    		user.setDateOfBirth(month.getValue(), Integer.parseInt(day.getValue()), Integer.parseInt(year.getValue()));
    	
    	if(weightTextField.getText() != null && !weightTextField.getText().equals(""))
    		user.setWeight(Integer.parseInt(weightTextField.getText()));
    	if(heightTextField.getText() != null && !heightTextField.getText().equals(""))
    		user.setHeight(Integer.parseInt(heightTextField.getText()));
    	
    }
    
    private void saveUser() {
		
    	new UserDA().addUser(user);
		
	}

}



