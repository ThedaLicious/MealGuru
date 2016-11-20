package smartgui;

import gui.PrimaryWindow;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import utilities.ResourceManager;

public class UserLabel extends Button {

	ImageView imageView;

	public UserLabel() {

		super(PrimaryWindow.getActiveUser().getUsername());
			
		imageView = new ImageView(ResourceManager.getImage(PrimaryWindow.getActiveUser().getPictureExtension()));
		
		imageView.setPreserveRatio(true);
		imageView.setFitHeight(50);
		imageView.setFitWidth(50);
		
		this.setGraphic(imageView);
		
	}
	
}
