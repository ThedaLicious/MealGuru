/**
 * This class is to indicate the user's gender info.
 * There are 4 types, male, female, other, and unknown.
 * The constructor is private.
 * 
 * @author hou_jiacheng
 */

package userobjects;

public enum Gender {
	
//1st CLASSIFICATION
	MALE("Male"), FEMALE("Female"), OTHER("Other"), UNKNOWN("Unknown");
	
//2nd CLASSIFICATION
	private String gender;
	
//CONSTRUCTORS
	private Gender(String gender){
		this.gender = gender;
	}
	
	
//METHODS
	public String getGender(){
		return gender;
	}
	
	@Override
	public String toString(){
		return gender;
	}
	
};