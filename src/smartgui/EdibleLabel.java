package smartgui;


import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utilities.ResourceManager;
import foodobjects.*;
import gui.NutritionLabel;

public class EdibleLabel extends Button {

    ImageView edibleImage;

    public EdibleLabel(Food food) {

        edibleImage = new ImageView(ResourceManager.getImage(food.getPictureExtension()));

        this.setGraphic(edibleImage);
        this.setText(food.getName());

        Tooltip tooltip = new Tooltip();
        tooltip.setGraphic(new NutritionLabel(food));
        tooltip.setAutoHide(false);
        this.setTooltip(tooltip);

        this.setOnMouseEntered(e -> {
            this.edibleImage.setFitHeight(70);
        });

        this.setOnMouseExited(e -> {
            this.edibleImage.setFitHeight(50);
        });

        setStyle();

    }

    public EdibleLabel(MealComponent mealComponent) {

        edibleImage = new ImageView(ResourceManager.getImage(mealComponent.getPictureExtension()));

        this.setGraphic(edibleImage);
        this.setText(mealComponent.getName() + ", " + mealComponent.getAmount());

        Tooltip tooltip = new Tooltip();
        tooltip.setGraphic(new NutritionLabel(mealComponent));
        tooltip.setAutoHide(false);
        this.setTooltip(tooltip);

        this.setOnMouseEntered(e -> {
            this.edibleImage.setFitHeight(70);
        });

        this.setOnMouseExited(e -> {
            this.edibleImage.setFitHeight(50);
        });

        setStyle();

    }

    public EdibleLabel(Meal meal) {

        edibleImage = new ImageView(ResourceManager.getImage(meal.getPictureExtension()));

        this.setGraphic(edibleImage);
        this.setText(meal.getName());

        Tooltip tooltip = new Tooltip();
        tooltip.setGraphic(new NutritionLabel(meal));
        tooltip.setAutoHide(false);
        this.setTooltip(tooltip);

        this.setOnMouseEntered(e -> {
            this.edibleImage.setFitHeight(70);
        });

        this.setOnMouseExited(e -> {
            this.edibleImage.setFitHeight(50);
        });

        setStyle();

    }

    //METHODS

    public void setStyle() {

        edibleImage.setPreserveRatio(true);
        this.edibleImage.setFitHeight(50);

        this.setMaxWidth(140);

        this.setAlignment(Pos.CENTER);

        edibleImage.setStyle(
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);" +
                        "-fx-background-radius: 5;");

        this.setStyle(
                "-fx-border-style: none;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);" +
                        "-fx-background-radius: 5;" +
                        "-fx-background-color: white;" +
                        "-fx-font-size: 10;" +
                        "-fx-font-family: sans-serif;");

    }

}
