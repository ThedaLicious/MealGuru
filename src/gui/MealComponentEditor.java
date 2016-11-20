package gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import smartgui.EdibleLabel;
import foodobjects.Food;
import foodobjects.MealComponent;
import utilities.Amount;
import utilities.Units;

import java.util.ArrayList;

public class MealComponentEditor extends BorderPane {

    ArrayList<MealComponent> mealComponents;
    Button createNewFood;

    HBox searchBar;
    TextField searchExistingFoods;
    Button search;

    VBox results;

    Button addComponents;

    public MealComponentEditor(MealComponent mealComponent) {

        this.mealComponents = new ArrayList<MealComponent>();

        searchExistingFoods = new TextField("search");
        search = new Button("Search");

        Food testFood1 = new Food("Banana", "resources/images/uploaded/banana.jpg", new ArrayList<String>(), new Amount(33, Units.GRAM), 1,2,3,4,5,6,7,8,9,10,11,12,13,14);
        Food testFood2 = new Food("Apple", "resources/images/uploaded/apple.jpg", new ArrayList<String>(), new Amount(33, Units.GRAM), 1,2,3,4,5,6,7,8,9,10,11,12,13,14);

        ArrayList<Food> foodsFromDatabase = new ArrayList<Food>();
        foodsFromDatabase.add(testFood1);
        foodsFromDatabase.add(testFood2);

        this.results = new VBox();
        this.populateResults(foodsFromDatabase);

        createNewFood = new Button("Create New Food");

        addComponents = new Button("Add Components");
        addComponents.setOnAction(event -> {
            this.getScene().getWindow().hide();
        });

        searchBar = new HBox(new Label("Search for Existing Foods"), searchExistingFoods, search);

        this.setTop(searchBar);
        this.setCenter(new ScrollPane(results));
        this.setBottom(new HBox(createNewFood, addComponents));

    }

    public void populateResults(ArrayList<Food> mealsToPopulateSearch) {

        for(int i = 0; i < mealsToPopulateSearch.size(); i++) {

            Food food = mealsToPopulateSearch.get(i);
            EdibleLabel temp = new EdibleLabel(food);

            temp.setOnMouseClicked(e -> {
                System.out.println(food.getName());
                this.selectFood(food);
            });

            temp.setOnMouseDragged(e -> {
                temp.setLayoutX(e.getSceneX() - this.getWidth()/2);
                temp.setLayoutY(e.getSceneY() - this.getHeight()/2);
            });


            this.results.getChildren().add(temp);

        }

    }

    public void selectFood(Food food) {}

    public void addMealComponent(MealComponent mealComponentToAdd) {

        this.mealComponents.add(mealComponentToAdd);

    }

    public ArrayList<MealComponent> getMealComponents() {
        return mealComponents;
    }

}
