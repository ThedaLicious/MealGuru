package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import foodobjects.Meal;
import foodobjects.MealComponent;
import utilities.DataFormat;



public class MealDA extends JDBC {

	private MealComponentDA mealComponentDA = new MealComponentDA();

	/**
	 * add a meal
	 * 
	 * @param a
	 *            meal object
	 * @return new meal_id
	 */
	public int addMeal(Meal meal) {
		int ret_id = 0;
		try {
			
			Connection conn = super.getMysqlConnection();
			Statement stmt = conn.createStatement();
			
			String SQLStr = "INSERT INTO Meal (meal_name, pictureExtension, lastEdit) VALUES ('" + meal.getName()
					+ "','" + meal.getPictureExtension() + "','" + meal.getLastEdit() + "')";

			stmt.executeUpdate(SQLStr);
			ResultSet res = stmt.executeQuery("select last_insert_rowid() newid;");
			
			if (res.next()) {
				ret_id = res.getInt(1);
			}
			
			if (ret_id != 0) {
				
				ArrayList<MealComponent> mealComponentList = meal.getMealComponents();
				MealComponent mealComponent;
				
				for (int i = 0; i < mealComponentList.size(); i++) {
					mealComponent = mealComponentList.get(i);
					mealComponent.setID(ret_id);
					mealComponentDA.addMealComponent(mealComponent);
				}
				
			} else {
				
				System.out.println("Add Meal error!");
				
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret_id;
		
	}

	/**
	 * Get meal based on meal_id
	 * 
	 * @param meal_id
	 * @return Meal class
	 */
	public Meal findMealById(int meal_id) {
		Meal meal = new Meal();
		try {
			if (meal_id == 0) {
				return null;
			}
			Connection conn = super.getMysqlConnection();
			Statement stmt = conn.createStatement();
			StringBuilder SQLStr = new StringBuilder("SELECT * FROM Meal where meal_id = " + meal_id);
			if (BasicData.SQL_OUT_PRINT) {
				System.out.println("MealDA class, the method is findPlateById, SQL: " + SQLStr);
			}
			ResultSet res = stmt.executeQuery(SQLStr.toString());
			while (res.next()) {
				meal.setID(meal_id);
				meal.setName(res.getString("meal_name"));
				meal.setLastEdit(DataFormat.transformStringToDate(res.getString("lastEdit")));
				meal.setPictureExtension(res.getString("pictureExtension"));
				meal.setMealComponents(mealComponentDA.findMealComponentByMeal_id(meal_id));
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return meal;
	}

	/**
	 * findMeal: Search Meal by meal_name
	 * 
	 * @param meal_name
	 * @return Meal List
	 */
	public ArrayList<Meal> findMeal(String meal_name) {
		ArrayList<Meal> mealList = new ArrayList<Meal>();
		try {
			Connection conn = super.getMysqlConnection();
			Statement stmt = conn.createStatement();
			StringBuilder SQLStr = new StringBuilder("SELECT * FROM Meal where ");
			if (meal_name != null && !meal_name.equals("")) {
				SQLStr.append("meal_name like '%" + meal_name + "%' and ");
			}
			SQLStr.append("1=1");
			if (BasicData.SQL_OUT_PRINT) {
				System.out.println("MealDA class, the method is findMeal, SQL: " + SQLStr);
			}
			ResultSet res = stmt.executeQuery(SQLStr.toString());
			Meal meal;
			while (res.next()) {
				meal = new Meal();
				meal.setID(res.getInt("meal_id"));
				meal.setName(res.getString("meal_name"));
				meal.setLastEdit(DataFormat.transformStringToDate(res.getString("lastEdit")));
				meal.setPictureExtension(res.getString("pictureExtension"));
				meal.setMealComponents(mealComponentDA.findMealComponentByMeal_id(meal.getID()));
				mealList.add(meal);
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mealList;
	}

	/**
	 * deleteMealById: delete meal based on meal_id
	 * 
	 * @param meal_id
	 * 
	 */
	public void deleteMealById(int meal_id) {
		if (meal_id != 0) {
			try {
				Connection conn = super.getMysqlConnection();
				Statement stmt = conn.createStatement();
				String SQLStr = "delete from Meal where meal_id = " + meal_id;
				if (BasicData.SQL_OUT_PRINT) {
					System.out.println("MealDA class, the method is deleteMealById, SQL: " + SQLStr);
				}
				stmt.executeUpdate(SQLStr);
				mealComponentDA.deleteMealComponentByMealId(meal_id);
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("meal_id is 0 or null.");
		}
	}

}
