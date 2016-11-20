package smartgui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class IntegerTextField extends TextField {

	int value = 0;
	
	public IntegerTextField() {
		
		this(0);
		
	}
	
	public IntegerTextField(int startValue) {
		
		this.setPrefWidth(50);
		
		this.value = startValue;
		
		this.setText(value + "");
		
		this.setOnMouseClicked(e -> {
			
			this.selectAll();
			
		});
		
		this.textProperty().addListener(e -> {
			
			char [] text = this.getText().toCharArray();
			String toReplace = "";
			
			for(char c : text)
				toReplace += c;
			
			if(!this.getText().equalsIgnoreCase(toReplace))
				this.setText(toReplace);
			
		});
		
		this.setOnKeyReleased(e -> {
			
			try {
				
				value = Integer.parseInt(this.getText());
				
				if(value < 0)		
					
					this.setText(Math.abs(value) + "");				
				
			} catch (Exception ex) {

				this.setText(Math.abs(value) + "");
				
			}
			
		});
		
	}
	
	public int getValue() {
		
		return Math.abs(value);
		
	}		
	
}

