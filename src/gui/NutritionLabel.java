package gui;
import foodobjects.Edible;

import javafx.scene.image.*;
import utilities.ResourceManager;

public class NutritionLabel extends ImageView {

    WritableImage foodLabel;

    public NutritionLabel(Edible edible) {

        this.redrawLabel(edible);

    }

    public void redrawLabel(Edible edible) {

        Image template = ResourceManager.getResourceImage("nutritionlabeltemplate.jpg");

        foodLabel = new WritableImage((int)template.getWidth(), (int)template.getHeight());

        PixelReader reader = template.getPixelReader();
        PixelWriter writer = foodLabel.getPixelWriter();

        for(int y = 0; y < foodLabel.getHeight(); y++) {
            for(int x = 0; x < foodLabel.getWidth(); x++) {

                writer.setColor(x, y, reader.getColor(x, y));

            }

        }

        /*if(food.getLiquidVolumePerServingSize() != null && food.getWeightPerServingSize() != null) {
            drawTextToImage(
                    food.getWeightPerServingSize().getMeasure() + food.getWeightPerServingSize().getUnitMeasurement().getAbbreviation() + " " +
                    food.getLiquidVolumePerServingSize().getMeasure() + food.getLiquidVolumePerServingSize().getUnitMeasurement().getAbbreviation(),
                    120, 50
            );
        } else if(food.getLiquidVolumePerServingSize() == null && food.getWeightPerServingSize() != null) {
            drawTextToImage(
                    food.getWeightPerServingSize().getMeasure() + food.getWeightPerServingSize().getUnitMeasurement().getAbbreviation(),
                    120, 50
            );
        } else if(food.getLiquidVolumePerServingSize() != null && food.getWeightPerServingSize() == null) {
            drawTextToImage(
                    food.getLiquidVolumePerServingSize().getMeasure() + food.getLiquidVolumePerServingSize().getUnitMeasurement().getAbbreviation(),
                    120, 50
            );
        }

        if(food.getUnitsPerServingSize() != null) {
            drawTextToImage(
                    (1/food.getUnitsPerServingSize().getMeasure()) + "",
                    195, 70
            );
        }*/

        drawTextToImage(
                edible.getCalories() + "",
                78, 135
        );

        drawTextToImage(
                edible.getTotalFat() + "",
                81, 188
        );

        drawTextToImage(
                edible.getSaturatedFat() + "",
                138, 213
        );

        drawTextToImage(
                edible.getTransFat() + "",
                113, 235
        );

        drawTextToImage(
                edible.getCholesterol() + "",
                107, 259
        );

        drawTextToImage(
                edible.getSodium() + "",
                75, 282
        );

        drawTextToImage(
                edible.getCarbohydrates() + "",
                158, 308
        );

        drawTextToImage(
                edible.getDietaryFiber() + "",
                137, 333
        );

        drawTextToImage(
                edible.getSugar() + "",
                97, 358
        );

        drawTextToImage(
                edible.getProtein() + "",
                76, 383
        );

        drawTextToImage(
                edible.getVitaminA() + "%",
                95, 423
        );

        drawTextToImage(
                edible.getVitaminC() + "%",
                95, 447
        );

        drawTextToImage(
                edible.getCalcium() + "%",
                81, 472
        );

        drawTextToImage(
                edible.getIron() + "%",
                47, 498
        );

        this.setImage(foodLabel);

    }

    public void drawTextToImage(String s, int xX, int yY) {

        TextOverlay text = null;

        try {

            text = new TextOverlay(s);

        } catch (Exception e) {}


        PixelReader reader = text.textImage.getPixelReader();
        PixelWriter writer = foodLabel.getPixelWriter();

        for(int y = 0; y < text.getHeight(); y++) {
            for(int x = 0; x < text.getWidth(); x++) {

                if(x + xX < foodLabel.getWidth() && x + xX > 0 && y + yY > 0 && y + yY < foodLabel.getHeight()) {
                    writer.setColor(x + xX, y + yY, reader.getColor(x, y));
                }

            }
        }


    }

}
