package smartgui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import utilities.ResourceManager;
import foodobjects.DailyIntake;
import foodobjects.Meal;
import gui.SecondaryStage;

public class DailyIntakeLabel extends VBox {

    ImageView dayImage;

    DailyIntake dailyIntake;

    VBox mealsVBox;
    ScrollPane scrollPane;

    Button removeAll;

    boolean showAddMealButton = true;
    Button addMeal;

    public DailyIntakeLabel(DailyIntake dailyIntake) {

        this.dailyIntake = dailyIntake;

        dayImage = new ImageView(ResourceManager.getResourceImage(dailyIntake.getPictureExtension()));
        dayImage.setPreserveRatio(true);
        dayImage.setFitWidth(100);
        dayImage.setOnMouseClicked(e -> {

            System.out.print(this.dailyIntake.getName() + " - ");

            for(int i = 0; i < this.dailyIntake.getMeals().size(); i++)
                System.out.print(this.dailyIntake.getMeals().get(i).getName() + " + ");

            System.out.print("...\n");

        });

        this.getChildren().addAll(dayImage, new Label(dailyIntake.getName()));

        refreshMealList();

        setStyle();

    }

    private void refreshMealList() {

        this.getChildren().removeAll(scrollPane, removeAll, addMeal);

        mealsVBox = new VBox();
        scrollPane = new ScrollPane(mealsVBox);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setStyle("-fx-background-color:transparent;");

        if(dailyIntake.getMeals() != null && dailyIntake.getMeals().size() > 0) {

            for(int i = 0; i < dailyIntake.getMeals().size(); i++)
                addMealLabel(dailyIntake.getMeals().get(i));

        }

        this.getChildren().add(scrollPane);

        removeAll = new Button("Remove All Meals");
        removeAll.setOnAction(e -> {

            dailyIntake.removeAllMeals();
            refreshMealList();

        });
        this.getChildren().add(removeAll);

        addMeal = new Button("Add Meals");
        addMeal.setOnAction(e -> {

            SecondaryStage.showDailyIntakeEditor(this.dailyIntake);

        });

        if(showAddMealButton)
            this.getChildren().add(addMeal);

        setStyle();

    }

    public void addMeal(Meal meal) {

        this.addMealLabel(meal);

        this.dailyIntake.addMeal(meal);

    }

    public void addMealLabel(Meal meal) {

        EdibleLabel edibleLabel = new EdibleLabel(meal);

        ContextMenu contextMenu = new ContextMenu();
        MenuItem removeItem = new MenuItem("Remove Meal");
        removeItem.setOnAction(e -> {
            dailyIntake.removeMeal(meal);
            this.refreshMealList();
        });
        MenuItem editItem = new MenuItem("Edit Meal");
        editItem.setOnAction(e -> {
            SecondaryStage.showMealEditor(meal);
        });
        MenuItem close = new MenuItem("Close");
        contextMenu.getItems().addAll(removeItem, editItem, close);
        edibleLabel.setContextMenu(contextMenu);

        this.mealsVBox.getChildren().add(edibleLabel);

    }

    public void setStyle() {

        this.setAlignment(Pos.CENTER);

        scrollPane.setMinWidth(168);

        mealsVBox.setAlignment(Pos.CENTER);

        mealsVBox.setMinWidth(160);
        mealsVBox.setPadding(new Insets(5));
        mealsVBox.setSpacing(5);


        dayImage.setStyle(
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);" +
                        "-fx-background-radius: 5;"
        );

        this.setStyle(
                ""
        );

    }

    public void setAddMealButtonVisible(boolean addMealButtonVisible) {
        this.showAddMealButton = false;
        if(this.addMeal.isVisible())
            this.addMeal.setVisible(false);
    }
}
