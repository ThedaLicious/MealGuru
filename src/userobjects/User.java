/**
 * This is the User class. It has 
 */

package userobjects;

import utilities.DataFormat;

import java.util.GregorianCalendar;

import org.jasypt.util.password.BasicPasswordEncryptor;

public class User {

	
	//VARIABLES
	
	private int userID;
	
	private String username;
	private String encryptedPassword;
	private BasicPasswordEncryptor passwordEncryptor;

	private String pictureExtension;
	
	private String email;
	private String phoneNumber;

	private String gender;

	private String dateOfBirth;

	private int height;
	private int weight;

	private Diet diet;
	
	//CONSTRUCTORS
	
	public User() {
	
	}
	
	public User(String username, String password){

		this.setUsername(username);
		passwordEncryptor = new BasicPasswordEncryptor();
		encryptedPassword = passwordEncryptor.encryptPassword(password);

	}

	public User(String username, String password, String gender, String month, int day, int year, int weight, String pictureExtension, Diet diet){

		this(username, password);

		this.setGender(gender);
		this.setDateOfBirth(month, day, year);
		this.setWeight(weight);
		this.setPictureExtension(pictureExtension);

		this.setDiet(diet);

	}

	
	//GETTERS
	
	public int getID() {
		return this.userID;
	}
	public String getUsername(){
		return username;
	}
	public String getEncryptedPassword(){
		return encryptedPassword;
	}
	public String getGender(){
		return gender;                   
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public String getAge() {
		return null;
	}
	public int getWeight() {
		return weight;
	}
	public int getHeight() {
		return height;
	}
	public Diet getDiet() {
		return diet;
	}
	public String getPictureExtension() {
		
		return this.pictureExtension;
	
	}
	
	//SETTERS
	
	public void setID(int userID) {
		this.userID = userID;		
	}
	public String getEmail() { return this.email; }
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhoneNumber() { return phoneNumber; }
	public void setPassword(String password) {
		passwordEncryptor = new BasicPasswordEncryptor();
		encryptedPassword = passwordEncryptor.encryptPassword(password);
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhoneNumber(String phoneNumber) {

		this.phoneNumber = phoneNumber;

	}
	public void setGender(String gender) {

		gender = gender.toUpperCase();
		
		this.gender = gender;

	}
	public void setDateOfBirth(String string) {
		this.dateOfBirth = string;
	}
	public void setDateOfBirth(String month, int day, int year) {

		if(month.equalsIgnoreCase("january"))
			setDateOfBirth(0, day, year);
		else if(month.equalsIgnoreCase("february"))
			setDateOfBirth(1, day, year);
		else if(month.equalsIgnoreCase("march"))
			setDateOfBirth(2, day, year);
		else if(month.equalsIgnoreCase("april"))
			setDateOfBirth(3, day, year);
		else if(month.equalsIgnoreCase("may"))
			setDateOfBirth(4, day, year);
		else if(month.equalsIgnoreCase("june"))
			setDateOfBirth(5, day, year);
		else if(month.equalsIgnoreCase("july"))
			setDateOfBirth(6, day, year);
		else if(month.equalsIgnoreCase("august"))
			setDateOfBirth(7, day, year);
		else if(month.equalsIgnoreCase("september"))
			setDateOfBirth(8, day, year);
		else if(month.equalsIgnoreCase("october"))
			setDateOfBirth(9, day, year);
		else if(month.equalsIgnoreCase("november"))
			setDateOfBirth(10, day, year);
		else if(month.equalsIgnoreCase("december"))
			setDateOfBirth(11, day, year);

	}
	public void setDateOfBirth(int month, int day, int year) {

		this.dateOfBirth = DataFormat.transformDateToString(new GregorianCalendar(year, month, day).getTime());

	}
	public void setWeight(int weight){
		this.weight = weight;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setPictureExtension(String pictureExtension) {
		this.pictureExtension = pictureExtension;
	}
	public void setDiet(Diet diet) {
		this.diet = diet;
	}
	
	//METHODS
	
	public boolean isPasswordCorrect(String inputPassword){
		//Used to check if the password is correct, I think there is a better way to do that!!!!
		if (passwordEncryptor.checkPassword(inputPassword, encryptedPassword)) 
			return true;
		else 
			return false;
	}
	
	@Override
	public String toString(){

		String nl = "\n";
		
		return  "Username: " + username + nl +
				"Password: " + passwordEncryptor + " (" + getEncryptedPassword() + ")" + nl +
				"Picture: " + getPictureExtension() + nl +
				"Email: " + getEmail() + nl +
				"Phone Number: " + getPhoneNumber() + nl +
				"Gender: " + getGender().toString() + nl + 
				"Date of Birth: " + getDateOfBirth() + nl +
				"Weight: " + weight + nl +
				"Height: " + height;
		
	}


}
