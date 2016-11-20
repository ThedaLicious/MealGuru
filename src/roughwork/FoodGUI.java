package roughwork;

import gui.NutritionLabel;
import foodobjects.Food;
import utilities.*;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FoodGUI {
	
	//Nutritional Label
	static NutritionLabel nutritionLabel;
	
	//The food we're editing or returning
	static Food food;	
	
	//Text-fields to gather information
	static VBox left;
	
	static FlowPane namePane;
	static TextField foodName;
	
	static GridPane servingSizeGridPane;
	static SmartTextField servingTextField1;
	static SmartChoiceBox servingChoiceBox1;	
	static SmartTextField servingTextField2;
	static SmartChoiceBox servingChoiceBox2;
	static SmartTextField servingTextField3;
	static SmartChoiceBox servingChoiceBox3;
	
	static GridPane nutritionalInformationGridPane;
	static SmartTextField caloriesTextField;
	static SmartTextField totalFatTextField;
	static SmartTextField saturatedFatTextField;
	static SmartTextField transFatTextField;
	static SmartTextField cholesterolTextField;
	static SmartTextField sodiumTextField;
	static SmartTextField carbohydrateTextField;
	static SmartTextField dietaryFiberTextField;
	static SmartTextField sugarTextField;
	static SmartTextField proteinTextField;
	static SmartTextField vitaminATextField;
	static SmartTextField vitaminCTextField;
	static SmartTextField calciumTextField;
	static SmartTextField ironTextField;
	
	static TagAddingGUI tagAddingGUI;
	
	static HBox processInformation;
	static Button submit;
	static Button cancel;
		
	public static Food getNewFoodFromUser() {
		
		food = new Food();
				
		return displayFoodEditor();
		
	}
	
	public static void editFood(Food toEdit) {
		
		food = toEdit;
		
		displayFoodEditor();
		
	}
	
	public static Food displayFoodEditor() {
						
		Stage window = new Stage();
		
		BorderPane layout = new BorderPane();
		
		Scene scene = new Scene(layout);
		scene.getStylesheets().add("EdibleGUI/FoodGUIStyle.css");
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle("Food Editor");
		window.setWidth(600);
		window.setHeight(650);
		
		//LEFT
		left = new VBox();
		left.setPrefWidth(500);
		
		
		namePane = new FlowPane();
		namePane.setId("inputPane");
		
		foodName = new TextField("Unitled");
		namePane.getChildren().addAll(new Label("Food Name"), foodName);
		
		
		servingSizeGridPane = new GridPane();
		servingSizeGridPane.setId("inputPane");
	
		servingTextField1 = new SmartTextField();
		servingChoiceBox1 = new SmartChoiceBox();
		servingSizeGridPane.addRow(0, servingTextField1, servingChoiceBox1);
		
		servingTextField2 = new SmartTextField();
		servingChoiceBox2 = new SmartChoiceBox();
		servingSizeGridPane.addRow(1, servingTextField2, servingChoiceBox2);
		
		servingTextField3 = new SmartTextField();
		servingChoiceBox3 = new SmartChoiceBox();
		servingSizeGridPane.addRow(2, servingTextField3, servingChoiceBox3);
				
		
		nutritionalInformationGridPane = new GridPane();
		nutritionalInformationGridPane.setId("inputPane");
		
		caloriesTextField = new SmartTextField(food.getCalories());
		nutritionalInformationGridPane.addRow(0, new Label("Calories"), caloriesTextField, new Label("cal"));
		
		totalFatTextField = new SmartTextField(food.getTotalFat().getMeasure());
		nutritionalInformationGridPane.addRow(1, new Label("Total Fat"), totalFatTextField, new Label("g"));
		
		saturatedFatTextField = new SmartTextField(food.getSaturatedFat().getMeasure());
		nutritionalInformationGridPane.addRow(2, new Label("Saturated Fat"), saturatedFatTextField, new Label("g"));
		
		transFatTextField = new SmartTextField(food.getTransFat().getMeasure());
		nutritionalInformationGridPane.addRow(3, new Label("Trans Fat"), transFatTextField, new Label("g"));
		
		cholesterolTextField = new SmartTextField(food.getCholesterol().getMeasure());
		nutritionalInformationGridPane.addRow(4, new Label("Cholesterol"), cholesterolTextField, new Label("mg"));
		
		sodiumTextField = new SmartTextField(food.getSodium().getMeasure());
		nutritionalInformationGridPane.addRow(5, new Label("Sodium"), sodiumTextField, new Label("mg"));
		
		carbohydrateTextField = new SmartTextField(food.getCarbohydrates().getMeasure());
		nutritionalInformationGridPane.addRow(6, new Label("Carbohydrate"), carbohydrateTextField, new Label("g"));
		
		dietaryFiberTextField = new SmartTextField(food.getDietaryFiber().getMeasure());
		nutritionalInformationGridPane.addRow(7, new Label("Dietary Fiber"), dietaryFiberTextField, new Label("g"));
		
		sugarTextField = new SmartTextField(food.getSugar().getMeasure());
		nutritionalInformationGridPane.addRow(8, new Label("Sugar"), sugarTextField, new Label("g"));
		
		proteinTextField = new SmartTextField(food.getProtein().getMeasure());
		nutritionalInformationGridPane.addRow(9, new Label("Protein"), proteinTextField, new Label("g"));
		
		vitaminATextField = new SmartTextField(food.getVitaminA());
		nutritionalInformationGridPane.addRow(10, new Label("Vitamin A"), vitaminATextField, new Label("%"));
		
		vitaminCTextField = new SmartTextField(food.getVitaminC());
		nutritionalInformationGridPane.addRow(11, new Label("Vitamin C"), vitaminCTextField, new Label("%"));
		
		calciumTextField = new SmartTextField(food.getCalcium());
		nutritionalInformationGridPane.addRow(12, new Label("Calcium"), calciumTextField, new Label("%"));
		
		ironTextField = new SmartTextField(food.getIron());
		nutritionalInformationGridPane.addRow(13, new Label("Iron"), ironTextField, new Label("%"));
		

		tagAddingGUI = new TagAddingGUI();

		
		processInformation = new HBox();
		processInformation.setAlignment(Pos.CENTER_RIGHT);
		submit = new Button("Submit");
		submit.setOnAction(e -> {
			window.close();
		});
		cancel = new Button("Cancel");
		cancel.setOnAction(e -> {
			food = null;
			window.close();
		});
		processInformation.getChildren().addAll(submit, cancel);
		
		
		left.getChildren().addAll(
				namePane, 
				servingSizeGridPane, 
				nutritionalInformationGridPane, 
				tagAddingGUI,
				processInformation
		);
				
		left.setAlignment(Pos.CENTER);
		layout.setCenter(left);
		
		//RIGHT
		
		//nutritionLabel = new NutritionLabel(food);
		layout.setRight(nutritionLabel);
		
		window.setScene(scene);

		window.showAndWait();

		return food;
		
	}
	
	public static void deriveInformationFromGUI() {
		
		food.setName(foodName.getText());
		
		try {
			food.setServingSize(new Amount(Double.parseDouble(servingTextField1.getText()), servingChoiceBox1.getValue()));
		} catch(Exception ex) {
			
		}		
		try {
			food.setServingSize(new Amount(Double.parseDouble(servingTextField2.getText()), servingChoiceBox2.getValue()));
		} catch(Exception ex) {
			
		}		
		try {
			food.setServingSize(new Amount(Double.parseDouble(servingTextField3.getText()), servingChoiceBox3.getValue()));
		} catch(Exception ex) {
			
		}

		food.setCalories(caloriesTextField.getValue());
		food.setTotalFat(new Amount(totalFatTextField.getValue(), Units.GRAM));
		food.setSaturatedFat(new Amount(saturatedFatTextField.getValue(), Units.GRAM));
		food.setTransFat(new Amount(transFatTextField.getValue(), Units.GRAM));
		food.setCholesterol(new Amount(cholesterolTextField.getValue(), Units.MILLIGRAM));
		food.setSodium(new Amount(sodiumTextField.getValue(), Units.MILLIGRAM));
		food.setCarbohydrates(new Amount(carbohydrateTextField.getValue(), Units.GRAM));
		food.setDietaryFiber(new Amount(dietaryFiberTextField.getValue(), Units.GRAM));
		food.setSugar(new Amount(sugarTextField.getValue(), Units.GRAM));
		food.setProtein(new Amount(proteinTextField.getValue(), Units.GRAM));
		food.setVitaminA(vitaminATextField.getValue());
		food.setVitaminC(vitaminCTextField.getValue());
		food.setCalcium(calciumTextField.getValue());
		food.setIron(ironTextField.getValue());
		
		food.setLastEdit();
		
		redrawNutritionLabel();
		
	}
	
	public static void redrawNutritionLabel() {
		
		nutritionLabel.redrawLabel(food);
		
	}
	
	static class SmartChoiceBox extends ChoiceBox<Units>{
						
		public SmartChoiceBox() {
								
			this.getItems().addAll(Units.UNIT, Units.CONTAINER);
			this.getItems().addAll(Units.MILLIGRAM, Units.GRAM, Units.OUNCE, Units.POUND);
			this.getItems().addAll(Units.MILLILITER, Units.LITER, Units.TEA_SPOON, Units.TABLE_SPOON, Units.CUP, Units.FLUID_OUNCE, Units.PINT, Units.QUART, Units.GALLON);
			
			this.valueProperty().addListener(e -> {
					
				deriveInformationFromGUI();
				
			});
					
		}
		
		
	}
	
	static class TagAddingGUI extends GridPane {
		
		public static TagComboBox tagComboBox;
		public static Button action;
		public static Label tagLabel;
		
		public TagAddingGUI() {
			
			this.setId("inputPane");
			
			tagComboBox = new TagComboBox();
			
			action = new Button("add tag");
			action.setVisible(false);
			
			if(food.getCategories() != null)
				tagLabel = new Label(food.getCategories().toString());
			else tagLabel = new Label("");
			tagLabel.setWrapText(true);
			tagLabel.setPrefWidth(120);
			tagLabel.setTextAlignment(TextAlignment.LEFT);
			
			action.setOnAction(e -> {
				
				if(food.is(tagComboBox.getValue().toLowerCase())) {
					food.removeTag(tagComboBox.getValue().toLowerCase());
					tagComboBox.setValue("");
					action.setVisible(false);
					tagLabel.setText(food.getCategories().toString());
				} else {
					food.addTag(tagComboBox.getValue().toLowerCase());
					tagComboBox.setValue("");
					action.setVisible(false);
					tagLabel.setText(food.getCategories().toString());
				}
				
			});		
			
			this.addRow(0, tagComboBox, action);
			this.addRow(1, tagLabel);
			
		}
		
		static class TagComboBox extends ComboBox<String> {
			
			public TagComboBox() {
				
				this.setEditable(true);
				
				this.getItems().addAll("Vegetarian", "Paleo", "Vegan");
				
				this.getEditor().textProperty().addListener((obs, oldText, newText) -> {
					
					this.setValue(newText);
					
					if(this.getValue() != null && !this.getValue().equals("")) {
						action.setVisible(true);
						action.setText("add tag");
						
						if(tagComboBox.getValue() != null && food.is(tagComboBox.getValue().toLowerCase())) {
							action.setText("remove tag");
						} else {
							action.setText("add tag");
						}
					}
									
				});
								
			}
			
		}
		
	}
	
	
	
	static class SmartTextField extends TextField {
		
		double value = 0.0;
		
		public SmartTextField() {
			
			this(0.0);
			
		}
		
		public SmartTextField(double startValue) {
			
			this.setPrefWidth(50);
			
			this.value = startValue;
			
			this.setText(value + "");
			
			this.setOnMouseClicked(e -> {
				
				this.selectAll();
				
			});
			
			this.setOnKeyReleased(e -> {
				
				try {
					
					value = Double.parseDouble(this.getText());
					
					if(value < 0)						
						this.setText(Math.abs(value) + "");	
					
					deriveInformationFromGUI();
					
					
					
				} catch (Exception ex) {

					this.setText(Math.abs(value) + "");
					
				}
				
			});
			
		}
		
		public double getValue() {
			
			return Math.abs(value);
			
		}		
		
	}
	
}


