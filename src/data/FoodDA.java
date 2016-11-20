package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import foodobjects.Food;
import utilities.Amount;
import utilities.DataFormat;


public class FoodDA extends JDBC {

	/**
	 * findFood: Search food by food_name
	 * 
	 * @param food_name
	 * @return food List
	 */
	public ArrayList<foodobjects.Food> findFood(String food_name) {
		ArrayList<Food> foodList = new ArrayList<Food>();
		try {
			Connection databaseConnection = super.getMysqlConnection();
			Statement sqlStatement = databaseConnection.createStatement();
			StringBuilder sqlString = new StringBuilder("SELECT * FROM Food where ");
			if (food_name != null && !food_name.equals("")) {
				sqlString.append("food_name like '%" + food_name + "%' and ");
				// } else if (isVegetarian != null && !isVegetarian.equals(""))
				// {
				// sqlString.append("isVegetarian = '" + isVegetarian + "' and ");
				// } else if (calories_begin != 0 && calories_end != 0) {
				// sqlString.append("calories between " + calories_begin + " and "
				// + calories_end + " and ");
			}
			sqlString.append("1=1");
			if (BasicData.SQL_OUT_PRINT) {
				System.out.println("FoodDA class, the method is findFood, SQL: " + sqlString);
			}
			ResultSet res = sqlStatement.executeQuery(sqlString.toString());
			Food food;
			while (res.next()) {
				
				food = new Food();
				
				food.setFoodID(res.getInt("food_id"));
				food.setName(res.getString("food_name"));
				food.setPictureExtension(res.getString("pictureExtension"));
				food.setPictureExtension(res.getString("picturePath"));

				food.setCategories(Tool.transformToArrayList(res.getString("categories")));
				food.setLastEdit(DataFormat.transformStringToDate(res.getString("lastEdit")));

				food.setServingSize(new Amount(res.getString("unitsPerServingSize")));
				food.setServingSize(new Amount(res.getString("weightPerServingSize")));
				food.setServingSize(new Amount(res.getString("liquidVolumePerServingSize")));
				food.setCalories(res.getDouble("calories"));
				food.setTotalFat(new Amount(res.getString("totalFat")));
				food.setSaturatedFat(new Amount(res.getString("saturatedFat")));
				food.setTransFat(new Amount(res.getString("transFat")));
				food.setCholesterol(new Amount(res.getString("cholesterol")));
				food.setSodium(new Amount(res.getString("sodium")));
				food.setCarbohydrates(new Amount(res.getString("carbohydrates")));
				food.setDietaryFiber(new Amount(res.getString("dietaryFiber")));
				food.setSugar(new Amount(res.getString("sugar")));
				food.setProtein(new Amount(res.getString("protein")));
				food.setVitaminA(res.getDouble("vitaminA"));
				food.setVitaminC(res.getDouble("vitaminC"));
				food.setCalcium(res.getDouble("calcium"));
				food.setIron(res.getDouble("iron"));
				
				foodList.add(food);
				
			}
			sqlStatement.close();
			databaseConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foodList;
	}

	/**
	 * findFood: Get food based on food_id
	 * 
	 * @param food_id
	 * @return Food class
	 */
	public Food findFoodById(int food_id) {
		Food food = new Food();
		try {
			
			Connection databaseConnection = super.getMysqlConnection();
			Statement sqlStatement = databaseConnection.createStatement();
			
			if (food_id == 0)
				return null;
			
			StringBuilder sqlString = new StringBuilder("SELECT * FROM Food where food_id = " + food_id);
			
			if (BasicData.SQL_OUT_PRINT)
				System.out.println("FoodDA class, the method is findFood, SQL: " + sqlString);
			
			ResultSet res = sqlStatement.executeQuery(sqlString.toString());
			
			while (res.next()) {

				food = new Food();
				
				food.setFoodID(res.getInt("food_id"));
				food.setName(res.getString("food_name"));
				food.setPictureExtension(res.getString("pictureExtension"));
				food.setPictureExtension(res.getString("picturePath"));

				food.setCategories(Tool.transformToArrayList(res.getString("categories")));
				food.setLastEdit(DataFormat.transformStringToDate(res.getString("lastEdit")));

				food.setServingSize(new Amount(res.getString("unitsPerServingSize")));
				food.setServingSize(new Amount(res.getString("weightPerServingSize")));
				food.setServingSize(new Amount(res.getString("liquidVolumePerServingSize")));
				food.setCalories(res.getDouble("calories"));
				food.setTotalFat(new Amount(res.getString("totalFat")));
				food.setSaturatedFat(new Amount(res.getString("saturatedFat")));
				food.setTransFat(new Amount(res.getString("transFat")));
				food.setCholesterol(new Amount(res.getString("cholesterol")));
				food.setSodium(new Amount(res.getString("sodium")));
				food.setCarbohydrates(new Amount(res.getString("carbohydrates")));
				food.setDietaryFiber(new Amount(res.getString("dietaryFiber")));
				food.setSugar(new Amount(res.getString("sugar")));
				food.setProtein(new Amount(res.getString("protein")));
				food.setVitaminA(res.getDouble("vitaminA"));
				food.setVitaminC(res.getDouble("vitaminC"));
				food.setCalcium(res.getDouble("calcium"));
				food.setIron(res.getDouble("iron"));
				
			}

			sqlStatement.close();
			databaseConnection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return food;
		
	}

	/**
	 * addFood: add food
	 * 
	 * @param a
	 *            Food object
	 * @return food_id
	 */
	public int saveFood(Food food) {
		
		int food_id = 0;
		
		try {
			
			Connection conn = super.getMysqlConnection();
			Statement sqlStatement = conn.createStatement();

			String sqlString = "INSERT INTO Food (food_name, pictureExtension, picturePath, categories, lastEdit, unitsPerServingSize, weightPerServingSize, liquidVolumePerServingSize, calories, totalFat, saturatedFat, transFat, cholesterol, sodium, carbohydrates, dietaryFiber, sugar, protein, vitaminA, vitaminC, calcium, iron) "
					+ "VALUES ('" + food.getName() + "','" + food.getPictureExtension() + "','" + food.getPictureExtension()
					+ "','" + Tool.transformToString(food.getCategories()) + "','" + food.getLastEdit() + "','"
					+ food.getUnitsPerServingSize() + "','" + food.getWeightPerServingSize() + "','"
					+ food.getLiquidVolumePerServingSize() + "'," + food.getCalories() + ",'" + food.getTotalFat()
					+ "','" + food.getSaturatedFat() + "','" + food.getTransFat() + "','" + food.getCholesterol()
					+ "','" + food.getSodium() + "','" + food.getCarbohydrates() + "','" + food.getDietaryFiber()
					+ "','" + food.getSugar() + "','" + food.getProtein() + "'," + food.getVitaminA() + ","
					+ food.getVitaminC() + "," + food.getCalcium() + "," + food.getIron() + ")";
			
			if (BasicData.SQL_OUT_PRINT)
				System.out.println("FoodDA class, the method is addFood, SQL: " + sqlString);

			sqlStatement.executeUpdate(sqlString);
			ResultSet res = sqlStatement.executeQuery("select last_insert_rowid() newid;");
			
			if (res.next())
				food_id = res.getInt(1);
			
			sqlStatement.close();
			conn.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return food_id;

	}

	/**
	 * deleteFood: delete food
	 * 
	 * @param food_id
	 * 
	 */
	public void deleteFood(int food_id) {
		if (food_id != 0) {
			try {
				
				Connection databaseConnection = super.getMysqlConnection();
				Statement sqlStatement = databaseConnection.createStatement();
				
				String sqlString = "delete from food where food_id = " + food_id;
				
				if (BasicData.SQL_OUT_PRINT)
					System.out.println("FoodDA class, the method is deleteFood, SQL: " + sqlString);
				
				sqlStatement.executeUpdate(sqlString);
				
				sqlStatement.close();
				databaseConnection.close();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		} else {
			
			System.out.println("food_id is 0 or null.");
			
		}

	}

}
