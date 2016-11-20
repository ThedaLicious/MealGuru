package gui;

import javafx.scene.layout.BorderPane;
import foodobjects.Food;

public class FoodEditor extends BorderPane {

    Food food;

    public FoodEditor(Food food) {

        this.food = null;

    }


    public Food getFood() {

        food.setLastEdit();
        return food;

    }

}
