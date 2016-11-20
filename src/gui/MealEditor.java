package gui;

import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import smartgui.EdibleLabel;
import foodobjects.Food;
import foodobjects.Meal;
import foodobjects.MealComponent;
import utilities.Amount;
import utilities.Units;

import java.util.ArrayList;

public class MealEditor extends BorderPane {

    Meal meal;

    HBox nameHBox;
    Label nameLabel;
    TextField name;

    private TextArea howToMake;

    ArrayList<MealComponent> listOfComponents;
    VBox componentsOfMeal;

    Button submit;

    Button getNewMealComponent;

    public MealEditor(Meal mealToEdit) {

        this.meal = mealToEdit;

        //TOP

        nameLabel = new Label("Name your meal: ");
        name = new TextField(this.meal.getName());
        nameHBox = new HBox(5, nameLabel, name);
        this.setTop(nameHBox);

        //CENTER

        howToMake = new TextArea();

        Food testFood1 = new Food("Banana", "resources/images/uploaded/banana.jpg", new ArrayList<String>(), new Amount(33, Units.GRAM), 1,2,3,4,5,6,7,8,9,10,11,12,13,14);
        Food testFood2 = new Food("Apple", "resources/images/uploaded/apple.jpg", new ArrayList<String>(), new Amount(33, Units.GRAM), 1,2,3,4,5,6,7,8,9,10,11,12,13,14);

        MealComponent mealComponent1 = new MealComponent(testFood1, 33, Units.GRAM);
        MealComponent mealComponent2 = new MealComponent(testFood2, 33, Units.GRAM);

        listOfComponents = new ArrayList<MealComponent>();
        listOfComponents.add(mealComponent1);
        listOfComponents.add(mealComponent2);

        componentsOfMeal = new VBox();
        populateResults(listOfComponents);

        submit = new Button("submit");
        submit.setOnAction(e -> {

        });

        getNewMealComponent = new Button("Create new MealComponent");
        getNewMealComponent.setOnAction(e -> {

        });

        this.setCenter(new VBox(howToMake, componentsOfMeal));

        this.setBottom(new HBox(submit, getNewMealComponent));

    }

    public void populateResults(ArrayList<MealComponent> mealComponents) {

        for(int i = 0; i < mealComponents.size(); i++) {

            MealComponent mealComponent = mealComponents.get(i);
            EdibleLabel temp = new EdibleLabel(mealComponent);

            temp.setOnMouseClicked(e -> {
                System.out.println(mealComponent.getName());
            });

            this.componentsOfMeal.getChildren().add(temp);

        }

    }

    public Meal getMeal() {

        //meal.setLastEdit();
        return meal;

    }
}
