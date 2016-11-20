package gui;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import smartgui.DailyIntakeLabel;
import smartgui.UserLabel;
import foodobjects.DailyIntake;
import foodobjects.Food;
import foodobjects.Meal;
import foodobjects.MealComponent;
import utilities.Amount;
import utilities.ResourceManager;
import utilities.Units;

import java.util.ArrayList;
import java.util.Date;



class MainGUI extends BorderPane {

	private UserLabel userLabel;
    private Button changeUser;

    HBox dailyIntakeHBox;                    
    int dayOffset;                        

    DailyIntake threeDaysAgo;
    DailyIntake twoDaysAgo;
    DailyIntake oneDaysAgo;
    DailyIntake centerDay;
    DailyIntake oneDayFromNow;
    DailyIntake twoDaysFromNow;
    DailyIntake threeDaysFromNow;

    DailyIntakeLabel threeDaysAgoLabel;
    DailyIntakeLabel twoDaysAgoLabel;
    DailyIntakeLabel oneDaysAgoLabel;
    DailyIntakeLabel centerDayLabel;
    DailyIntakeLabel oneDayFromNowLabel;
    DailyIntakeLabel twoDaysFromNowLabel;
    DailyIntakeLabel threeDaysFromNowLabel;

    Button future;
    Button past;

    public MainGUI() {

        System.out.println(PrimaryWindow.getActiveUser());

        userLabel = new UserLabel();
        userLabel.setOnAction(e -> {
            PrimaryWindow.setActiveUser(null);
            PrimaryWindow.displayWelcomeGUI();
        });
        this.setTop(userLabel);

        past = new Button();
        ImageView leftImage = new ImageView(ResourceManager.getResourceImage("left.png"));
        leftImage.setPreserveRatio(true);
        leftImage.setFitHeight(50);
        past.setGraphic(leftImage);
        past.setStyle("-fx-background-color:transparent;");
        VBox left = new VBox(past);
        left.setAlignment(Pos.CENTER);
        setLeft(left);

        dayOffset = 0;

        threeDaysAgo  = new DailyIntake(new Date(new Date().getTime() + (86400000 * (-3 + dayOffset))));
        twoDaysAgo  = new DailyIntake(new Date(new Date().getTime() + (86400000 * (-2 + dayOffset))));
        oneDaysAgo  = new DailyIntake(new Date(new Date().getTime() + (86400000 * (-1 + dayOffset))));
        centerDay  = new DailyIntake(new Date(new Date().getTime() + (86400000 * dayOffset)));
        oneDayFromNow  = new DailyIntake(new Date(new Date().getTime() + (86400000 * (1 + dayOffset))));
        twoDaysFromNow  = new DailyIntake(new Date(new Date().getTime() + (86400000 * (2 + dayOffset))));
        threeDaysFromNow  = new DailyIntake(new Date(new Date().getTime() + (86400000 * (3 + dayOffset))));

        MealComponent mealComponent1 = new MealComponent(new Food("Banana", "photo1.png", new ArrayList<String>(), new Amount(33, Units.GRAM), 1,2,3,4,5,6,7,8,9,10,11,12,13,14), 33, Units.GRAM);
        MealComponent mealComponent2 = new MealComponent(new Food("Apple", "photo1.png", new ArrayList<String>(), new Amount(33, Units.GRAM), 1,2,3,4,5,6,7,8,9,10,11,12,13,14), 33, Units.GRAM);

        Meal testMeal = new Meal("Fruit Salad", "photo1.png", mealComponent1, mealComponent2);
        Meal testMeal1 = new Meal("Pineapple", "photo1.png", mealComponent1);
        Meal testMeal2 = new Meal("Spaghetti", "photo1.png", mealComponent2);

        twoDaysAgo.addMeal(testMeal);
        threeDaysAgo.addMeal(testMeal2);
        threeDaysAgo.addMeal(testMeal2);
        oneDaysAgo.addMeal(testMeal);
        centerDay.addMeal(testMeal);
        centerDay.addMeal(testMeal1);
        oneDayFromNow.addMeal(testMeal);
        twoDaysFromNow.addMeal(testMeal2);
        twoDaysFromNow.addMeal(testMeal2);
        threeDaysFromNow.addMeal(testMeal);

        threeDaysAgoLabel = new DailyIntakeLabel(threeDaysAgo);

        twoDaysAgoLabel = new DailyIntakeLabel(twoDaysAgo);
        oneDaysAgoLabel = new DailyIntakeLabel(oneDaysAgo);
        centerDayLabel = new DailyIntakeLabel(centerDay);
        oneDayFromNowLabel = new DailyIntakeLabel(oneDayFromNow);
        twoDaysFromNowLabel = new DailyIntakeLabel(twoDaysFromNow);
        threeDaysFromNowLabel = new DailyIntakeLabel(threeDaysFromNow);

        dailyIntakeHBox = new HBox(
                threeDaysAgoLabel,
                twoDaysAgoLabel,
                oneDaysAgoLabel,
                centerDayLabel,
                oneDayFromNowLabel,
                twoDaysFromNowLabel,
                threeDaysFromNowLabel
        );

        dailyIntakeHBox.setAlignment(Pos.CENTER);

        this.setCenter(dailyIntakeHBox);

        //RIGHT

        future = new Button();
        ImageView rightImage = new ImageView(ResourceManager.getResourceImage("right.png"));
        rightImage.setPreserveRatio(true);
        rightImage.setFitHeight(50);
        future.setGraphic(rightImage);
        future.setStyle("-fx-background-color:transparent;");
        VBox right = new VBox(future);
        right.setAlignment(Pos.CENTER);
        setRight(right);

        //BOTTOM


    }

}