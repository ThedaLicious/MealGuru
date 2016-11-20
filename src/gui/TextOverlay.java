package gui;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class TextOverlay {

    WritableImage textImage;

    //CONSTRUCTORS

    public TextOverlay(String s) throws IOException {
        this.setText(s);
    }

    //METHODS

    public void setText(String string) throws IOException {

        Font font = new Font("Arial", Font.PLAIN, 16);

        BufferedImage bufferedImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bufferedImage.getGraphics();

        graphics.setFont(font);
        FontMetrics fm = graphics.getFontMetrics();

        bufferedImage = new BufferedImage(fm.stringWidth(string), fm.getHeight(), BufferedImage.TYPE_INT_ARGB);
        graphics = bufferedImage.getGraphics();

        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());

        graphics.setColor(Color.BLACK);
        graphics.setFont(font);

        graphics.drawString(string, 0, fm.getHeight() - fm.getDescent());
        graphics.dispose();

        textImage = new WritableImage(bufferedImage.getWidth(), bufferedImage.getHeight());

        PixelWriter pw = this.textImage.getPixelWriter();

        for (int y = 0; y < bufferedImage.getHeight(); y++) {
            for (int x = 0; x < bufferedImage.getWidth(); x++) {
                pw.setArgb(x, y, bufferedImage.getRGB(x, y));
            }
        }

    }

    public int getWidth() {
        return (int)this.textImage.getWidth();
    }

    public int getHeight() {
        return (int)this.textImage.getHeight();
    }
    
}


