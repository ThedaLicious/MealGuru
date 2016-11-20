package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import smartgui.DailyIntakeLabel;
import smartgui.EdibleLabel;
import foodobjects.DailyIntake;
import foodobjects.Food;
import foodobjects.Meal;
import foodobjects.MealComponent;
import utilities.Amount;
import utilities.Units;

import java.util.ArrayList;

public class DailyIntakeEditor extends BorderPane {

    //DAILY INTAKE BUTTON
    DailyIntakeLabel dailyIntakeLabel;

    //SEARCH BAR OBJECTS
    HBox searchBar;
    TextField searchExistingMeals;
    Button search;

    //SEARCH RESULTS BUTTONS
    VBox results;
    ScrollPane resultsScrollPane;

    //CREATE A NEW MEAL FOR dailyIntake
    Button addNewMeal;

    //FINISHED
    Button finishedAndSave;

    //CANCEL
    Button cancel;

    public DailyIntakeEditor(DailyIntake dailyIntake) {

        this.dailyIntakeLabel = new DailyIntakeLabel(dailyIntake);
        this.dailyIntakeLabel.setAddMealButtonVisible(false);

        MealComponent mealComponent1 = new MealComponent(new Food("Banana", "resources/images/uploaded/banana.jpg", new ArrayList<String>(), new Amount(33, Units.GRAM), 1,2,3,4,5,6,7,8,9,10,11,12,13,14), 33, Units.GRAM);
        MealComponent mealComponent2 = new MealComponent(new Food("Apple", "resources/images/uploaded/apple.jpg", new ArrayList<String>(), new Amount(33, Units.GRAM), 1,2,3,4,5,6,7,8,9,10,11,12,13,14), 33, Units.GRAM);

        Meal testMeal = new Meal("Fruit Salad", "resources/images/uploaded/banana.jpg", mealComponent1, mealComponent2);
        Meal testMeal1 = new Meal("Pineapple", "resources/images/uploaded/pineapple.jpg", mealComponent1);
        Meal testMeal2 = new Meal("Spaghetti And maple Tartar Sauce", "resources/images/uploaded/spaghetti.jpg", mealComponent2);

        ArrayList<Meal> meals = new ArrayList<Meal>();
        meals.add(testMeal);
        meals.add(testMeal1);
        meals.add(testMeal2);

        //SEARCH FOR AN EXISTING MEAL
        searchExistingMeals = new TextField();
        search = new Button("Search");

        //RESULTS OF A SEARCH
        this.results = new VBox();
        this.populateResults(meals);

        //CREATE A NEW MEAL
        addNewMeal = new Button("New Meal");
        addNewMeal.setOnAction(event -> {

            Meal temporary = new Meal();
            SecondaryStage.showMealEditor(temporary);
            dailyIntake.addMeal(temporary);

        });

        //FINISHED EDITs
        finishedAndSave = new Button("Finish and Save");
        finishedAndSave.setOnAction(e -> {



        });

        //CANCEL EDITs
        cancel = new Button("Cancel");
        cancel.setOnAction(e -> {



        });


        //BUIDING THE GUI

        searchBar = new HBox(5, new Label("Search for Existing Meals"), searchExistingMeals, search);
        searchBar.setPadding(new Insets(10));
        searchBar.setAlignment(Pos.CENTER);
        this.setTop(searchBar);

        results.setPadding(new Insets(5));
        results.setSpacing(5);
        results.setAlignment(Pos.CENTER);

        resultsScrollPane = new ScrollPane(results);
        this.setCenter(resultsScrollPane);
        this.setRight(dailyIntakeLabel);
        this.setBottom(new HBox(addNewMeal, finishedAndSave, cancel));

    }

    public void populateResults(ArrayList<Meal> mealsToPopulateSearch) {

        for(int i = 0; i < mealsToPopulateSearch.size(); i++) {

            Meal meal = mealsToPopulateSearch.get(i);
            EdibleLabel temp = new EdibleLabel(meal);

            temp.setOnMouseClicked(e -> {

                dailyIntakeLabel.addMeal(meal);

            });

            this.results.getChildren().add(temp);

        }

    }

}
