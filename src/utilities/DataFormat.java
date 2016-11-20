package utilities;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class DataFormat {

	public static Date transformStringToDate(String dataStr) {
		
		SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy");
		
		Date date = null;
		
		try {
			date = format.parse(dataStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
		
	}
	
	public static String transformDateToString(Date date) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return format.format(date);
		
	}

	public static byte[] transformImageToByteArray(BufferedImage bufferedImage) {
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		try {
			ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		return byteArrayOutputStream.toByteArray();		
		
	}
	
	public static Image transformByteArrayToImage(byte [] bytes) {
		
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new ByteArrayInputStream(bytes));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SwingFXUtils.toFXImage(img, null);
				
	}
	
}
