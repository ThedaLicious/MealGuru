package foodobjects;

import utilities.Amount;
import utilities.DataFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DailyIntake extends Edible {

    //VARIABLES

    ArrayList<Meal> meals = new ArrayList<Meal>();

    Date date;
    Date lastEditDate;

    //CONSTRUCTORS

    public DailyIntake(Date date) {

        this.date = date;

    }

    //GETTERS

    @Override
	public String getName() {

        return DataFormat.transformDateToString(this.date);

    }

    public ArrayList<Meal> getMeals() {

        return meals;

    }

    @Override
	public Date getLastEdit() {
        return null;
    }

    @Override
	public String getPictureExtension() {

        SimpleDateFormat format = new SimpleDateFormat("EEEE");

        return format.format(date) + ".PNG";

    }

    @Override
	public double getCalories() {

        double calories = 0;

        for (Meal m : getMeals())
            calories += m.getCalories();

        return calories;

    }

    @Override
	public Amount getTotalFat() {
        return null;
    }

    @Override
	public Amount getSaturatedFat() {
        return null;
    }

    @Override
	public Amount getTransFat() {
        return null;
    }

    @Override
	public Amount getCholesterol() {
        return null;
    }

    @Override
	public Amount getSodium() {
        return null;
    }

    @Override
	public Amount getCarbohydrates() {
        return null;
    }

    @Override
	public Amount getDietaryFiber() {
        return null;
    }

    @Override
	public Amount getSugar() {
        return null;
    }

    @Override
	public Amount getProtein() {
        return null;
    }

    @Override
	public double getVitaminA() {
        return 0;
    }

    @Override
	public double getVitaminC() {
        return 0;
    }

    @Override
	public double getCalcium() {
        return 0;
    }

    @Override
	public double getIron() {
        return 0;
    }

    @Override
	public boolean is(String check) {
        return false;
    }

    //METHODS

    public void addMeal(Meal meal) {

        if(this.meals == null)
            this.meals = new ArrayList<Meal>();

        this.meals.add(meal);

    }

    public void removeMeal(Meal meal) {

        if(this.meals == null)
            return;

        this.meals.remove(meal);

    }

    public void removeAllMeals() {

        this.meals = new ArrayList<>();

    }

    @Override
	public String toString() {
        return String.valueOf(meals);
    }

    public boolean isThisDate(Date date) {

        SimpleDateFormat format = new SimpleDateFormat("EEEEEEEEEE, MMMMMMMMM dd, yyyy");

        return format.format(date).equalsIgnoreCase(format.format(this.date));

    }

    /**
     * @param dailyIntake
     * @return
     */
    public boolean equalsTo(DailyIntake dailyIntake) {

        System.out.println(this.getName());
        System.out.println(dailyIntake.getName());

        System.out.println("IN CLASS: " + dailyIntake.getName().equalsIgnoreCase(this.getName()));

        return dailyIntake.getName().equalsIgnoreCase(this.getName());

    }

}
