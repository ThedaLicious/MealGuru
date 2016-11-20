package foodobjects;

import java.util.Date;

import utilities.*;

public class MealComponent extends Edible {

	//VARIABLES

	private int mealComponentID;
	
	private Food food;
	private Amount foodAmount;

	//CONSTRUCTORS

	public MealComponent() {}
	
	public MealComponent(Food food, Amount amount) {
		
		this(food);
		this.setAmount(amount);
		
	}

	public MealComponent(Food food, double measure, Units units) {

		this(food);
		this.foodAmount = new Amount(measure, units);
		
	}
	
	public MealComponent(Food food, String foodAmount) {

		this(food);
		this.foodAmount = new Amount(foodAmount);
		
	}

	private MealComponent(Food food) {
		
		this.food = food;
		
	}
	
	//GETTERS

	public int getID() {
		return this.mealComponentID;
	}
	public Food getFood() {
		return this.food;
	}
	@Override
	public String getName() {
		return food.name;
	}
	public Amount getAmount() {
		return foodAmount;
	}
	@Override
	public double getCalories() {
		return (food.getCalories() * this.getSizeRatio());
	}
	@Override
	public Amount getTotalFat() {
		return new Amount(food.getTotalFat().getMeasure() * this.getSizeRatio(), Units.GRAM);
	}
	@Override
	public Amount getSaturatedFat() {
		return new Amount(food.getSaturatedFat().getMeasure() * this.getSizeRatio(), Units.GRAM);
	}
	@Override
	public Amount getTransFat() {
		return new Amount(food.getTransFat().getMeasure() * this.getSizeRatio(), Units.GRAM);
	}
	@Override
	public Amount getCholesterol() {
		return new Amount(food.getCholesterol().getMeasure() * this.getSizeRatio(), Units.MILLIGRAM);
	}
	@Override
	public Amount getSodium() {
		return new Amount(food.getSodium().getMeasure() * this.getSizeRatio(), Units.MILLIGRAM);
	}
	@Override
	public Amount getCarbohydrates() {
		return new Amount(food.getCarbohydrates().getMeasure() * this.getSizeRatio(), Units.GRAM);
	}
	@Override
	public Amount getDietaryFiber() {
		return new Amount(food.getDietaryFiber().getMeasure() * this.getSizeRatio(), Units.GRAM);
	}
	@Override
	public Amount getSugar() {
		return new Amount(food.getSugar().getMeasure() * this.getSizeRatio(), Units.GRAM);
	}
	@Override
	public Amount getProtein() {
		return new Amount(food.getProtein().getMeasure() * this.getSizeRatio(), Units.GRAM);
	}
	@Override
	public double getVitaminA() {
		return food.getVitaminA() * this.getSizeRatio();
	}
	@Override
	public double getVitaminC() {
		return food.getVitaminC() * this.getSizeRatio();
	}
	@Override
	public double getCalcium() {
		return food.getCalcium() * this.getSizeRatio();
	}
	@Override
	public double getIron() {
		return food.getIron() * this.getSizeRatio();
	}
	@Override
	public Date getLastEdit() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPictureExtension() {
		return food.pictureExtension;
	}
	
	//SETTERS
	
	public void setID(int mealComponentID) {
		this.mealComponentID = mealComponentID;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public void setAmount(Amount amount) {
		this.foodAmount = amount;
	}

	//METHODS
	
	@Override
	public boolean is(String check) {
		return food.is(check);
	}
	
	private double getSizeRatio() {

		//Returns the relationship between the serving size and the measure of the ingredient to 
		//further calculate the nutrition information of a certain ingredient measure
		
		double ratio = -1;

		if(this.foodAmount.getUnits() == Units.UNIT
				&& food.getUnitsPerServingSize() != null) {

			ratio = this.foodAmount.getMeasure() * food.getUnitsPerServingSize().getMeasure();

		} else if(this.foodAmount.getUnits().getClassification() == UnitClassification.WEIGHTED
				&& food.getWeightPerServingSize() != null) {

			this.foodAmount.convert(food.getWeightPerServingSize().getUnits());
			ratio = this.foodAmount.getMeasure() / food.getWeightPerServingSize().getMeasure();

		} else if(this.foodAmount.getUnits().getClassification() == UnitClassification.LIQUID_VOLUME
				&& food.getLiquidVolumePerServingSize() != null) {

			this.foodAmount.convert(food.getLiquidVolumePerServingSize().getUnits());
			ratio = this.foodAmount.getMeasure() / food.getLiquidVolumePerServingSize().getMeasure();

		}

		return ratio;

	}
	

}