package data;


import java.util.ArrayList;

public class Tool {

	public static ArrayList<String> transformToArrayList(String array) {
		
		String[] categories = array.split("#");
		
		for (int i = 0; i < categories.length; i++) {
		}
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		for (int i = 0; i < categories.length; i++) {
			arrayList.add(categories[i]);
		}
		
		return arrayList;
		
	}

	public static String transformToString(ArrayList<String> arrayList) {
		
		StringBuffer str = new StringBuffer();
		
		for (int i = 0; i < arrayList.size(); i++) {
			str.append(arrayList.get(i));
			if(i != arrayList.size()-1){
				str.append("#");
			}
		}
		
		return str.toString();
	}

}
