package utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

import javafx.scene.image.Image;

public class ResourceManager {
	
	public static Image getResourceImage(String pictureExtension) {

		URL url = ResourceManager.class.getResource("/" + pictureExtension);
				
		if(url == null)
			return getResourceImage("no-image-found.jpg");
		else
			return new Image(url.toExternalForm());
		
	}
	
	public static Image getImage(String extension) {
						
		new File("usercontent").mkdir();
		
		if(new File("usercontent/" + extension).exists())		
			return new Image("file:usercontent/" + extension);
		else
			return ResourceManager.getResourceImage("no-image-found.jpg");
		
	}
	
	public static String saveImage(BufferedImage image) {
						
		new File("usercontent").mkdir();
		
		File outputfile = null;
		
		int number = (int) (Math.random() * 100000);
		
		while((outputfile = new File("usercontent/photo" + number + ".png")).exists()) {
			outputfile = new File("usercontent/photo" + number + ".png");
			number++;
		}
	    
	    try {
	    	
			ImageIO.write(image , "png", outputfile);
			return outputfile.getName();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	    
		return null;
	    
	}
				
	public static String getCSS(String extension) {
		
		URL url = ResourceManager.class.getResource("/" + extension);
		
		return url.toExternalForm();
		
	}


}
