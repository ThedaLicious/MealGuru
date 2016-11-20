package gui;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utilities.ResourceManager;
import foodobjects.DailyIntake;
import foodobjects.Food;
import foodobjects.Meal;
import foodobjects.MealComponent;

public class SecondaryStage extends Stage {

    //CLASS MEMBERS

    private static SecondaryStage secondaryStage;

    private static Scene visibleScene;

    private static MealEditor mealEditor;
    private static DailyIntakeEditor dailyIntakeEditor;
    private static MealComponentEditor mealComponentEditor;
    private static FoodEditor foodEditor;

    private SecondaryStage() {

        this.setScene(visibleScene);

        this.setWidth(800);
        this.setMinWidth(800);

        this.setHeight(600);
        this.setMinHeight(600);

        this.initModality(Modality.APPLICATION_MODAL);

        SecondaryStage.visibleScene.getStylesheets().add(ResourceManager.getCSS("style.css"));

    }

    //GETTERS/SETTERS

    //METHODS

    public static void closeCurrentScene() {}

    public static void showDailyIntakeEditor(DailyIntake dailyIntake) {

        dailyIntakeEditor = new DailyIntakeEditor(dailyIntake);

        if(visibleScene == null)
            visibleScene = new Scene(dailyIntakeEditor);
        else
            visibleScene.setRoot(dailyIntakeEditor);

        if(secondaryStage == null)
            secondaryStage = new SecondaryStage();

        secondaryStage.setTitle("Edit Daily Intake for " + dailyIntake.getName());

        if(!secondaryStage.isShowing())
            secondaryStage.showAndWait();

    }

    public static void showMealEditor(Meal meal) {

        mealEditor = new MealEditor(meal);

        if(visibleScene == null)
            visibleScene = new Scene(mealEditor);
        else
            visibleScene.setRoot(mealEditor);

        if(secondaryStage == null)
            secondaryStage = new SecondaryStage();

        secondaryStage.setTitle("Edit Meal");

        if(!secondaryStage.isShowing())
            secondaryStage.showAndWait();

    }

    public static void showMealComponentEditor(MealComponent mealComponent) {

        mealComponentEditor = new MealComponentEditor(mealComponent);

        if(visibleScene == null)
            visibleScene = new Scene(mealComponentEditor);
        else
            visibleScene.setRoot(mealComponentEditor);

        if(secondaryStage == null)
            secondaryStage = new SecondaryStage();

        secondaryStage.setTitle("Edit Meal Component");

        if(!secondaryStage.isShowing())
            secondaryStage.showAndWait();

    }

    public static void showFoodEditor(Food food) {

        foodEditor = new FoodEditor(food);

        if(visibleScene == null)
            visibleScene = new Scene(foodEditor);
        else
            visibleScene.setRoot(foodEditor);

        if(secondaryStage == null)
            secondaryStage = new SecondaryStage();

        secondaryStage.setTitle("Edit Food");

        if(!secondaryStage.isShowing())
            secondaryStage.showAndWait();

    }

}
