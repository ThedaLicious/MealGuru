package userobjects;

import utilities.Amount;
import utilities.Units;

import java.util.ArrayList;

public class Diet {

	private ArrayList<String> categoryLimits = new ArrayList<>();
	
	private int caloriesLimit;
	private Amount totalFatLimit, saturatedFatLimit, transFatLimit;
	private Amount cholesterolLimit, sodiumLimit;
	private Amount carbohydratesLimit, dietaryFiberLimit, sugarLimit;
	private Amount proteinLimit;
	private double vitaminALimit, vitaminCLimit;
	private double calciumLimit, ironLimit;
	

	public Diet() {
		this.setCaloriesLimit(0);
		this.setTotalFatLimit(null);
		this.setSaturatedFatLimit(new Amount(0, Units.GRAM));
		this.setTransFatLimit(new Amount(0, Units.GRAM));
		this.setCholesterolLimit(new Amount(0, Units.MILLIGRAM));
		this.setSodiumLimit(new Amount(0, Units.MILLIGRAM));
		this.setCarbohydratesLimit(new Amount(0, Units.GRAM));
		this.setDietaryFiberLimit(new Amount(0, Units.GRAM));
		this.setSugarLimit(new Amount(0, Units.GRAM));
		this.setProteinLimit(new Amount(0, Units.GRAM));
		this.setVitaminALimit(0);
		this.setVitaminCLimit(0);
		this.setCalciumLimit(0);
		this.setIronLimit(0);
	}
	
	public Diet(int caloriesLimit,
				Amount totalFatLimit,
				Amount saturatedFatLimit,
				Amount transFatLimit,
				Amount cholesterolLimit,
				Amount sodiumLimit,
				Amount carbohydratesLimit,
				Amount dietaryFiberLimit,
				Amount sugarLimit,
				Amount proteinLimit,
				double vitaminALimit, 
				double vitaminCLimit,
				double calciumLimit, 
				double ironLimit,
				String...CategoryLimits){
		
		this.setCaloriesLimit(caloriesLimit);
		this.setTotalFatLimit(totalFatLimit);
		this.setSaturatedFatLimit(saturatedFatLimit);
		this.setTransFatLimit(transFatLimit);
		this.setCholesterolLimit(cholesterolLimit);
		this.setSodiumLimit(sodiumLimit);
		this.setCarbohydratesLimit(carbohydratesLimit);
		this.setDietaryFiberLimit(dietaryFiberLimit);
		this.setSugarLimit(sugarLimit);
		this.setProteinLimit(proteinLimit);
		this.setVitaminALimit(vitaminALimit);
		this.setVitaminCLimit(vitaminCLimit);
		this.setCalciumLimit(calciumLimit);
		this.setIronLimit(ironLimit);
		
		for (String categoryLimit : CategoryLimits)
			this.addCategoryLimits(categoryLimit);
	}
	
	
	public ArrayList<String> getCategoryLimits() {
		return categoryLimits;
	}
	public void setCategoryLimits(ArrayList<String> categoriesLimit) {
		this.categoryLimits = categoriesLimit;
	}
	

	public int getCaloriesLimit() {
		return caloriesLimit;
	}
	public void setCaloriesLimit(int caloriesLimit) {
		this.caloriesLimit = caloriesLimit;
	}
	

	public Amount getTotalFatLimit() {
		return totalFatLimit;
	}
	public void setTotalFatLimit(Amount totalFatLimit) {
		this.totalFatLimit = totalFatLimit;
	}
	public Amount getSaturatedFatLimit() {
		return saturatedFatLimit;
	}
	public void setSaturatedFatLimit(Amount saturatedFatLimit) {
		this.saturatedFatLimit = saturatedFatLimit;
	}
	public Amount getTransFatLimit() {
		return transFatLimit;
	}
	public void setTransFatLimit(Amount transFatLimit) {
		this.transFatLimit = transFatLimit;
	}
	
	
	public Amount getCholesterolLimit() {
		return cholesterolLimit;
	}
	public void setCholesterolLimit(Amount cholesterolLimit) {
		this.cholesterolLimit = cholesterolLimit;
	}
	public Amount getSodiumLimit() {
		return sodiumLimit;
	}
	public void setSodiumLimit(Amount sodiumLimit) {
		this.sodiumLimit = sodiumLimit;
	}
	
	
	public Amount getCarbohydratesLimit() {
		return carbohydratesLimit;
	}
	public void setCarbohydratesLimit(Amount carbohydratesLimit) {
		this.carbohydratesLimit = carbohydratesLimit;
	}
	public Amount getDietaryFiberLimit() {
		return dietaryFiberLimit;
	}
	public void setDietaryFiberLimit(Amount dietaryFiberLimit) {
		this.dietaryFiberLimit = dietaryFiberLimit;
	}
	public Amount getSugarLimit() {
		return sugarLimit;
	}
	public void setSugarLimit(Amount sugarLimit) {
		this.sugarLimit = sugarLimit;
	}
	
	
	public Amount getProteinLimit() {
		return proteinLimit;
	}
	public void setProteinLimit(Amount proteinLimit) {
		this.proteinLimit = proteinLimit;
	}
	

	public double getVitaminALimit() {
		return vitaminALimit;
	}
	public void setVitaminALimit(double vitaminALimit) {
		this.vitaminALimit = vitaminALimit;
	}
	public double getVitaminCLimit() {
		return vitaminCLimit;
	}
	public void setVitaminCLimit(double vitaminCLimit) {
		this.vitaminCLimit = vitaminCLimit;
	}
	
	
	public double getCalciumLimit() {
		return calciumLimit;
	}
	public void setCalciumLimit(double calciumLimit) {
		this.calciumLimit = calciumLimit;
	}
	public double getIronLimit() {
		return ironLimit;
	}
	public void setIronLimit(double ironLimit) {
		this.ironLimit = ironLimit;
	}

	
//Methods
	public void addCategoryLimits(String tag){
		if(this.getCategoryLimits() == null)
			this.setCategoryLimits(new ArrayList<>());

		this.getCategoryLimits().add(tag.toLowerCase());
	}
	
	public void removeCategoryLimits(String tag) {
		this.getCategoryLimits().remove(tag.toLowerCase());
	}
	
	
	public boolean isWithinCaloriesLimit(int caloriesLimit){
		return this.caloriesLimit == caloriesLimit;
	}
	
	public boolean isWithinTotalFatLimit(Amount totalFatLimit){
		return this.totalFatLimit == totalFatLimit;
	}
	public boolean isWithinSaturatedFatLimit(Amount saturatedFatLimit){
		return this.saturatedFatLimit == saturatedFatLimit;
	}
	public boolean isWithinTransFatLimit(Amount transFatLimit){
		return this.transFatLimit == transFatLimit;
	}
	
	public boolean isWithinCholesterolLimit(Amount cholesterolLimit){
		return this.cholesterolLimit == cholesterolLimit;
	}
	public boolean isWithinSodiumLimit(Amount sodiumLimit){
		return this.sodiumLimit == sodiumLimit;
	}
	
	public boolean isWithinCarbohydratesLimit(Amount carbohydratesLimit){
		return this.carbohydratesLimit == carbohydratesLimit;
	}
	public boolean isWithinDietaryFiberLimit(Amount dietaryFiberLimit){
		return this.dietaryFiberLimit == dietaryFiberLimit;
	}
	public boolean isWithinSugarLimit(Amount sugarLimit){
		return this.sugarLimit == sugarLimit;
	}
	
	public boolean isWithinProteinLimit(Amount proteinLimit){
		return this.proteinLimit == proteinLimit;
	}
	
	public boolean isWithinVitaminALimit(double vitaminALimit){
		return this.vitaminALimit == vitaminALimit;
	}
	public boolean isWithinCalciumLimit(double calciumLimit){
		return this.calciumLimit == calciumLimit;
	}
	
	public boolean isWithinIronLimit(double ironLimit){
		return this.ironLimit == ironLimit;
	}
	
	public boolean isWithinCategoryLimits(String tag){		
		return this.categoryLimits.contains(tag);
	}
	
	public boolean isWithinCategoryLimits(ArrayList<String> tags){

		for (String tag : tags){
			if(isWithinCategoryLimits(tag))
				return true;
		}

		return false;
	}
	
	public ArrayList<String> sameInCategoryLimits(ArrayList<String> tags){		
		if (isWithinCategoryLimits(tags)){
			ArrayList<String> r = new ArrayList<String>();
			for (String tag : tags){
				if (this.categoryLimits.contains(tag))
					r.add(tag);
			}
			return r;
		}
		else
			return null;
	}
	
	@Override
	public String toString() {
		String toReturn =
				"Category Limits: " + this.getCategoryLimits() + "\n" +
				"\nCalories Limit: " + this.getCaloriesLimit() +
				"\nTotal Fat Limit: " + this.getTotalFatLimit() +
				"\n\tSaturated Fat Limit: " + this.getSaturatedFatLimit() +
				"\n\tTrans Fat Limit: " + this.getTransFatLimit() +
				"\nCholesterol Limit: " + this.getCholesterolLimit() +
				"\nSodium Limit: " + this.getSodiumLimit() +
				"\nCarbohydrates Limit: " + this.getCarbohydratesLimit() +
				"\n\tDietary Fiber Limit: " + this.getDietaryFiberLimit() +
				"\n\tSugar Limit: " + this.getSugarLimit() +
				"\nProtein Limit: " + this.getProteinLimit() +
				"\nVitamin A Limit: " + this.getVitaminALimit() +
				"\nVitamin C Limit: " + this.getVitaminCLimit() +
				"\nCalcium Limit: " + this.getCalciumLimit() +
				"\nIron Limit: " + this.getIronLimit();

		return toReturn;
	}	
}
