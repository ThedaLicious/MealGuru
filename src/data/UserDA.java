package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import foodobjects.Meal;
import userobjects.User;



public class UserDA extends JDBC {

	/**
	 * create a User
	 * 
	 * @param user
	 * @return new User id
	 */
	public int addUser(User user) {
		
		int ret_id = 0;
		
		try {
			
			Connection conn = super.getMysqlConnection();
			Statement stmt = conn.createStatement();
			
			String SQLStr = "INSERT INTO User (user_name, password, email, phone_number, gender, weight, height, picture, birth) VALUES ('" 
					+ user.getUsername() + "','" 
					+ user.getEncryptedPassword() + "','" 
					+ user.getEmail() + "','"
					+ user.getPhoneNumber() + "','" 
					+ user.getGender() + "'," 
					+ user.getWeight() + "," 
					+ user.getHeight() + ",'" 
					+ user.getPictureExtension() + "','"
					+ user.getDateOfBirth() + "')";
			
			stmt.executeUpdate(SQLStr);
						
			ResultSet res = stmt.executeQuery("SELECT last_insert_rowid() newid;");
			
			if (res.next())
				ret_id = res.getInt(1);

			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return ret_id;
		
	}
	
	public void updateUser(User user) {
		
		try {
			
			Connection conn = super.getMysqlConnection();
			Statement stmt = conn.createStatement();
			
			String SQLStr = "UPDATE User SET "
					+ "user_name = '" + user.getUsername() + "', "
					+ "password = '" + user.getEncryptedPassword() + "', "
					+ "email = '" + user.getEmail() + "', "
					+ "phone_number = '" + user.getPhoneNumber() + "', "
					+ "gender = '" + user.getGender() + "', "
					+ "weight = " + user.getWeight() + ", "
					+ "height = " + user.getHeight() + ", "
					+ "picture = '" + user.getPictureExtension() + "', "
					+ "birth = '" + user.getDateOfBirth() + "' "
					+ "WHERE user_id = '" + user.getID() + "';";
			
			stmt.executeUpdate(SQLStr);
						
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public User getUserByUsername(String username) {
		
		User user = null;
		
		try {
		
			if (username == null || username.equals(""))
				return null;

			Connection conn = super.getMysqlConnection();
			
			Statement statement = conn.createStatement();
			StringBuilder SQLStr = new StringBuilder("SELECT * FROM User where user_name = ('" + username + "');");
			
			ResultSet res = statement.executeQuery(SQLStr.toString());
						
			while (res.next()) {
				
				user = new User();
				
				user.setID(res.getInt("user_id"));
				user.setUsername(res.getString("user_name"));
				user.setPassword(res.getString("password"));
				
				user.setPictureExtension(res.getString("picture"));	
				
				user.setEmail(res.getString("email"));
				user.setPhoneNumber(res.getString("phone_number"));
				
				user.setGender(res.getString("gender"));
				
				if(res.getString("weight") != null)
					user.setWeight(Integer.parseInt(res.getString("weight")));
				if(res.getString("height") != null)
					user.setHeight(Integer.parseInt(res.getString("height")));
				
				user.setDateOfBirth(res.getString("birth"));				
				
			}
			
			statement.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
}
