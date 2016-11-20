package foodobjects;

import java.util.ArrayList;
import java.util.Date;

import utilities.*;

public class Meal extends Edible {

	//VARIABLES

	private int mealID;
	private int pictureID;
	
	private String name;

	private String pictureExtension;

	private ArrayList<MealComponent> mealComponents;

	private ArrayList<String> categories;

	private Date lastEdit;

	//CONSTRUCTORS

	public Meal() {

		this.setName("Untitled");

		this.pictureExtension = "resources/images/GUI/defaultmeal.png";

	}

	public Meal(String mealName, MealComponent... foods) {

		this();

		this.setName(mealName);

		for(int i = 0; i < foods.length; i++) {
			this.addMealComponent(foods[i]);
		}

	}

	public Meal(String mealName, String pictureExtension, MealComponent... foods) {

		this.setName(mealName);

		this.pictureExtension = pictureExtension;
		
		for(int i = 0; i < foods.length; i++) {
			this.addMealComponent(foods[i]);
		}

	}

	//GETTERS

	public int getID() {
		return this.mealID;
	}
	@Override
	public String getName() {
		
		return this.name;
		
	}
	@Override
	public Date getLastEdit() {
		return lastEdit;
	}
	public ArrayList<String> getCategories() {
		return categories;
	}
	@Override
	public String getPictureExtension() {

		return pictureExtension;

	}
	public ArrayList<MealComponent> getMealComponents() {
		return mealComponents;
	}
	@Override
	public double getCalories() {

		double toReturn = 0;

		if(this.mealComponents == null)
			return toReturn;
		
		
		for(MealComponent mealComponent : this.mealComponents) {
				
			toReturn += mealComponent.getCalories();
				
		}

		return toReturn;

	}
	@Override
	public Amount getTotalFat() {

		Amount toReturn = new Amount(0, Units.GRAM);

		if(this.mealComponents == null)
			return toReturn;
		
		
		for(MealComponent mealComponent : this.mealComponents)	
			toReturn.add(mealComponent.getTotalFat());

		return toReturn;

	}
	@Override
	public Amount getSaturatedFat() {

		Amount toReturn = new Amount(0, Units.GRAM);

		if(this.mealComponents == null)
			return toReturn;
		
		
		for(MealComponent mealComponent : this.mealComponents)	
			toReturn.add(mealComponent.getSaturatedFat());

		return toReturn;

	}
	@Override
	public Amount getTransFat() {

		Amount toReturn = new Amount(0, Units.GRAM);

		if(this.mealComponents == null)
			return toReturn;
		
		
		for(MealComponent mealComponent : this.mealComponents)	
			toReturn.add(mealComponent.getTransFat());

		return toReturn;

	}
	@Override
	public Amount getCholesterol() {

		Amount toReturn = new Amount(0, Units.MILLIGRAM);

		if(this.mealComponents == null)
			return toReturn;
		
		
		for(MealComponent mealComponent : this.mealComponents)	
			toReturn.add(mealComponent.getCholesterol());

		return toReturn;

	}
	@Override
	public Amount getSodium() {

		Amount toReturn = new Amount(0, Units.MILLIGRAM);

		if(this.mealComponents == null)
			return toReturn;
		
		
		for(MealComponent mealComponent : this.mealComponents)	
			toReturn.add(mealComponent.getSodium());

		return toReturn;
	}
	@Override
	public Amount getCarbohydrates() {

		Amount toReturn = new Amount(0, Units.GRAM);

		if(this.mealComponents == null)
			return toReturn;
		
		
		for(MealComponent mealComponent : this.mealComponents)	
			toReturn.add(mealComponent.getCarbohydrates());

		return toReturn;

	}
	@Override
	public Amount getDietaryFiber() {

		Amount toReturn = new Amount(0, Units.GRAM);

		if(this.mealComponents == null)
			return toReturn;
		
		
		for(MealComponent mealComponent : this.mealComponents)	
			toReturn.add(mealComponent.getDietaryFiber());

		return toReturn;

	}
	@Override
	public Amount getSugar() {

		Amount toReturn = new Amount(0, Units.GRAM);

		if(this.mealComponents == null)
			return toReturn;
		
		
		for(MealComponent mealComponent : this.mealComponents)	
			toReturn.add(mealComponent.getSugar());

		return toReturn;

	}
	@Override
	public Amount getProtein() {

		Amount toReturn = new Amount(0, Units.GRAM);

		if(this.mealComponents == null)
			return toReturn;
		
		
		for(MealComponent mealComponent : this.mealComponents)	
			toReturn.add(mealComponent.getProtein());

		return toReturn;

	}
	@Override
	public double getVitaminA() {

		double toReturn = 0;

		if(this.mealComponents == null)
			return toReturn;
		
		
		for(MealComponent mealComponent : this.mealComponents) {
				
			toReturn += mealComponent.getVitaminA();
				
		}

		return toReturn;

	}
	@Override
	public double getVitaminC() {

		double toReturn = 0;

		if(this.mealComponents == null)
			return toReturn;
		
		
		for(MealComponent mealComponent : this.mealComponents) {
				
			toReturn += mealComponent.getVitaminC();
				
		}

		return toReturn;

	}
	@Override
	public double getCalcium() {

		double toReturn = 0;

		if(this.mealComponents == null)
			return toReturn;
		
		
		for(MealComponent mealComponent : this.mealComponents) {
				
			toReturn += mealComponent.getCalcium();
				
		}

		return toReturn;

	}
	@Override
	public double getIron() {

		double toReturn = 0;

		if(this.mealComponents == null)
			return toReturn;
		
		
		for(MealComponent mealComponent : this.mealComponents) {
				
			toReturn += mealComponent.getIron();
				
		}

		return toReturn;

	}

	//SETTERS
	
	public void setID(int mealID) {
		this.mealID = mealID;
	}
	public void setName(String mealName) {
		this.name = mealName;
	}
	public void setMealComponents(ArrayList<MealComponent> findMealComponentByMeal_id) {
		// TODO Auto-generated method stub
		
	}	
	public void setCategories(ArrayList<String> categories) {
		this.categories = categories;
	}
	public void setPictureExtension(String pictureExtension) { this.pictureExtension = pictureExtension; }
	public void setLastEdit(Date date) {
		this.lastEdit = date;
	}
	public void setLastEdit() { this.lastEdit = new Date(); }
	
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

	//METHODS

	public void addMealComponent(MealComponent toAdd) {

		if(this.mealComponents == null)
			this.mealComponents = new ArrayList<>();

		this.mealComponents.add(toAdd);

	}
	public void addMealComponent(MealComponent... mealComponentArray) {

		if(this.mealComponents == null)
			this.mealComponents = new ArrayList<>();

		for(MealComponent toAdd : mealComponentArray) {

			this.addMealComponent(toAdd);

		}

	}
	
	
	@Override
	public String toString() {
		
		String toReturn;

		toReturn = "(MEAL) \"" + name + "\" - last edit: " + lastEdit +"\n[";

		if(this.mealComponents != null)
			for(int i = 0; i < this.mealComponents.size(); i++)
				toReturn = toReturn + this.mealComponents.get(i).getAmount() + " " + this.mealComponents.get(i).getName() + ", ";
		
		toReturn = toReturn + "]\n"+
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