package foodobjects;



import java.util.ArrayList;
import java.util.Date;

import utilities.Amount;
import utilities.UnitClassification;
import utilities.Units;

public class Food extends Edible {

	//VARIABLES

	int foodID;
	int pictureID;
	
	String name;

	private ArrayList<String> categories;

	String pictureExtension;

	Date lastEdit;

	//SERVINGS PER CONTAINER
	
	private Amount unitsPerServingSize;
	private Amount weightPerServingSize;
	private Amount liquidVolumePerServingSize;

	double calories;

	Amount totalFat;
	Amount saturatedFat;
	Amount transFat;

	Amount cholesterol;

	Amount sodium;

	Amount carbohydrates;
	Amount dietaryFiber;
	Amount sugar;

	Amount protein;

	double vitaminA;
	double vitaminC;

	double calcium;
	double iron;

	//CONSTRUCTORS

	public Food() {
		this.setName(null);
		this.setPictureExtension(null);
		this.setCategories(new ArrayList<String>());
		this.setCalories(0);
		this.setTotalFat(new Amount(0, Units.GRAM));
		this.setSaturatedFat(new Amount(0, Units.GRAM));
		this.setTransFat(new Amount(0, Units.GRAM));
		this.setCholesterol(new Amount(0, Units.MILLIGRAM));
		this.setSodium(new Amount(0, Units.MILLIGRAM));
		this.setCarbohydrates(new Amount(0, Units.GRAM));
		this.setDietaryFiber(new Amount(0, Units.GRAM));
		this.setSugar(new Amount(0, Units.GRAM));
		this.setProtein(new Amount(0, Units.GRAM));
		this.setVitaminA(0);
		this.setVitaminC(0);
		this.setCalcium(0);
		this.setIron(0);
	}

	public Food(String name,
				String pictureExtension,
				ArrayList<String> categories,
				Amount servingSizeOne,
				Amount servingSizeTwo,
				Amount servingSizeThree,
				double... information) {

		this(name, categories, pictureExtension, information);

		this.setServingSize(servingSizeOne);
		this.setServingSize(servingSizeTwo);
		this.setServingSize(servingSizeThree);

	}

	public Food(String name,
				String pictureExtension,
				ArrayList<String> categories,
				Amount servingSizeOne,
				Amount servingSizeTwo,
				double... information) {

		this(name, categories, pictureExtension, information);

		this.setServingSize(servingSizeOne);
		this.setServingSize(servingSizeTwo);

	}

	public Food(String name,
				String pictureExtension,
				ArrayList<String> categories,
				Amount servingSizeOne,
				double... information) {

		this(name, categories, pictureExtension, information);

		this.setServingSize(servingSizeOne);

	}

	public Food(String name, ArrayList<String> categories, String pictureExtension, double... information) {

		this.setName(name);

		this.setPictureExtension(pictureExtension);

		this.setCategories(new ArrayList<String>());

		if(information.length != 14) {
			System.out.println("Error: insufficient information");
			return;
		}
		
		this.setCalories(information[0]);
		this.setTotalFat(new Amount(information[1], Units.GRAM));
		this.setSaturatedFat(new Amount(information[2], Units.GRAM));
		this.setTransFat(new Amount(information[3], Units.GRAM));
		this.setCholesterol(new Amount(information[4], Units.MILLIGRAM));
		this.setSodium(new Amount(information[5], Units.MILLIGRAM));
		this.setCarbohydrates(new Amount(information[6], Units.GRAM));
		this.setDietaryFiber(new Amount(information[7], Units.GRAM));
		this.setSugar(new Amount(information[8], Units.GRAM));
		this.setProtein(new Amount(information[9], Units.GRAM));
		this.setVitaminA(information[10]);
		this.setVitaminC(information[11]);
		this.setCalcium(information[12]);
		this.setIron(information[13]);
		
	}

	//GETTERS
	public int getID() {
		return this.foodID;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public String getPictureExtension() { return pictureExtension; }
	@Override
	public Date getLastEdit() {
		return lastEdit;
	}
	public Amount getWeightPerServingSize() {
		return weightPerServingSize;
	}
	public Amount getLiquidVolumePerServingSize() {
		return liquidVolumePerServingSize;
	}
	public Amount getUnitsPerServingSize() {
		return unitsPerServingSize;
	}
	@Override
	public double getCalories() {
		return this.calories;
	}
	@Override
	public Amount getTotalFat() {
		return this.totalFat;
	}
	@Override
	public Amount getSaturatedFat() {
		return this.saturatedFat;
	}
	@Override
	public Amount getTransFat() {
		return this.transFat;
	}
	@Override
	public Amount getCholesterol() {
		return this.cholesterol;
	}
	@Override
	public Amount getSodium() {
		return this.sodium;
	}
	@Override
	public Amount getCarbohydrates() {
		return this.carbohydrates;
	}
	@Override
	public Amount getDietaryFiber() {
		return this.dietaryFiber;
	}
	@Override
	public Amount getSugar() {
		return this.sugar;
	}
	@Override
	public Amount getProtein() {
		return this.protein;
	}
	@Override
	public double getVitaminA() {
		return this.vitaminA;
	}
	@Override
	public double getVitaminC() {
		return this.vitaminC;
	}
	@Override
	public double getCalcium() {
		return this.calcium;
	}
	@Override
	public double getIron() {
		return this.iron;
	}
	public ArrayList<String> getCategories() {
		return categories;
	}

	//SETTERS
	public void setFoodID(int int1) {
		// TODO Auto-generated method stub
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPictureExtension(String pictureExtension) { this.pictureExtension = pictureExtension; }
	public void setLastEdit(Date date) {
		this.lastEdit = date;
	}
	public void setLastEdit() { this.lastEdit = new Date(); }
	public void setServingSize(Amount amount) {

		if(amount.getUnits().getClassification() == UnitClassification.UNIT) {

			if(amount.getUnits() == Units.CONTAINER) {
				this.unitsPerServingSize = new Amount(amount.getMeasure(), Units.UNIT);
			} else
				this.unitsPerServingSize = new Amount(1 / amount.getMeasure(), Units.UNIT);

		} else if(amount.getUnits().getClassification() == UnitClassification.WEIGHTED) {

			this.weightPerServingSize = amount;

		} else if(amount.getUnits().getClassification() == UnitClassification.LIQUID_VOLUME) {

			this.liquidVolumePerServingSize = amount;

		}

	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	public void setTotalFat(Amount totalFat) {
		this.totalFat = totalFat;
	}
	public void setSaturatedFat(Amount saturatedFat) {
		this.saturatedFat = saturatedFat;
	}
	public void setTransFat(Amount transFat) {
		this.transFat = transFat;
	}
	public void setCholesterol(Amount cholesterol) {
		this.cholesterol = cholesterol;
	}
	public void setSodium(Amount sodium) {
		this.sodium = sodium;
	}
	public void setCarbohydrates(Amount carbohydrates) {
		this.carbohydrates = carbohydrates;
	}
	public void setDietaryFiber(Amount dietaryFiber) {
		this.dietaryFiber = dietaryFiber;
	}
	public void setSugar(Amount sugar) {
		this.sugar = sugar;
	}
	public void setProtein(Amount protein) {
		this.protein = protein;
	}
	public void setVitaminA(double vitaminA) {
		this.vitaminA = vitaminA;
	}
	public void setVitaminC(double vitaminC) {
		this.vitaminC = vitaminC;
	}
	public void setCalcium(double calcium) {
		this.calcium = calcium;
	}
	public void setIron(double iron) {
		this.iron = iron;
	}
	public void setCategories(ArrayList<String> categories) {
		this.categories = categories;
	}

	//METHODS
	
	public void addTag(String tag) {
		
		if(this.getCategories() == null)
			this.setCategories(new ArrayList<>());

		this.getCategories().add(tag.toLowerCase());
		
	}
	
	public void removeTag(String tag) {
		
		this.getCategories().remove(tag.toLowerCase());
		
	}
	
	@Override
	public boolean is(String match) {
		
		if(this.getCategories() != null)
			for(int i = 0; i < this.getCategories().size(); i++)
				if(this.getCategories().get(i).toLowerCase().equals(match.toLowerCase()))
					return true;
		
		return false;
		
	}
	
	@Override
	public String toString() {

		String toReturn;

		toReturn = "(Food) \"" + name + "\" - last edit: " + lastEdit +"\n" +
				this.pictureExtension + "\n" +
				this.getCategories() + "\n" +
				"Serving Size:" +
				"\n\t" + this.getUnitsPerServingSize() + " per serving" +
				"\n\t" + this.getWeightPerServingSize() + " per serving" +
				"\n\t" + this.getLiquidVolumePerServingSize() + " per serving" +
				"\nCalories: " + this.getCalories() +
				"\nTotal Fat: " + this.getTotalFat() +
				"\n\tSaturated Fat: " + this.getSaturatedFat() +
				"\n\tTrans Fat: " + this.getTransFat() +
				"\nCholesterol: " + this.getCholesterol() +
				"\nSodium: " + this.getSodium() +
				"\nCarbohydrates: " + this.getCarbohydrates() +
				"\n\tDietary Fiber: " + this.getDietaryFiber() +
				"\n\tSugar: " + this.getSugar() +
				"\nProtein: " + this.getProtein() +
				"\nVitamin A: " + this.getVitaminA() +
				"\nVitamin C: " + this.getVitaminC() +
				"\nCalcium: " + this.getCalcium() +
				"\nIron: " + this.getIron();

		return toReturn;

	}

}