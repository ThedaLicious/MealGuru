package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import userobjects.User;
import utilities.ResourceManager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PrimaryWindow extends Application {

    //CLASS MEMBERS

    private static Scene primaryScene;

    private static User activeUser;

    //MAIN METHOD
    public static void main(String [] args) {
    	
        launch(args);

    }

    @Override
	public void start(Stage primaryStage) throws Exception {

        Pane pane = new Pane();
        PrimaryWindow.primaryScene = new Scene(pane, 1366, 768);
        PrimaryWindow.primaryScene.getStylesheets().add(ResourceManager.getCSS("style.css"));

        primaryStage.setWidth(1366 );
        primaryStage.setMinWidth(1366);

        primaryStage.setHeight(768);
        primaryStage.setMinHeight(768);

        primaryStage.setScene(PrimaryWindow.primaryScene);
        primaryStage.setTitle("PrimaryWindow");

        PrimaryWindow.displayWelcomeGUI();

        primaryStage.show();

    }

    //GETTERS/SETTERS

    public static User getActiveUser() {
        return activeUser;
    }

    public static void setActiveUser(User user) {
        activeUser = user;
    }

    //METHODS

    public static void displayWelcomeGUI() {

    	PrimaryWindow.setActiveUser(null  );
        primaryScene.setRoot(new SplashPageGUI());

    }

    public static void displayNewUserGUI() {

        primaryScene.setRoot(new NewUser());

    }

    public static void editUserGUI() {

        primaryScene.setRoot(new UserEditor());

    }

    public static void displayMainGUI() {

        primaryScene.setRoot(new MainGUI());

    }

    //PHOTOGRABBER

    public static BufferedImage grabImage() {

        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(primaryScene.getWindow());
        
        if(file != null && file.exists()) {

        	//SAVE IMAGE TO USER!!!
        	
        	try {
				return ImageIO.read(file);
			} catch (IOException e) {
				e.printStackTrace();
			}

        }
        
        return null;

    }

}