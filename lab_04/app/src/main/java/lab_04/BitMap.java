package lab_04;

import javax.imageio.ImageIO;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class BitMap {
    private int[][] imageArray;

    public BitMap(){
    }

    public BufferedImage readImage(String fileName){
        BufferedImage imageReader = null;
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream("./"+fileName);
            imageReader = ImageIO.read(fileInputStream);
        }catch (IOException | IllegalArgumentException e){
            System.out.println("\033[0;31m" + "Could not find the file, make sure your file is within the folder of the project");
            System.out.println("\033[0m");

        }finally {
            try{
                fileInputStream.close();

            }catch (NullPointerException|IOException e){
                e.printStackTrace();
            }
        }
        return imageReader;
    }

    public void writeImage(BufferedImage sourceFile, String destination){
        String path = System.getProperty("user.dir");
        File newImage = new File(path+"/" + destination);
        BufferedImage bufferedImage = null;
        try{
            ImageIO.write(sourceFile, "BMP", newImage);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public BufferedImage invert(BufferedImage image){
        int color;
        for(int x = 0; x<image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                    image.setRGB(x, y, ~image.getRGB(x,y));
            }
        }
        return image;
    }

    public BufferedImage addWaterMark(BufferedImage sourceImage, String text){
        Graphics2D w = (Graphics2D) sourceImage.getGraphics();
        w.drawImage(sourceImage, 0, 0, null);
        AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f);
        w.setComposite(alphaChannel);
        w.setColor(Color.GRAY);
        w.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));
        FontMetrics fontMetrics = w.getFontMetrics();
        Rectangle2D rect = fontMetrics.getStringBounds(text, w);

        int centerX = (sourceImage.getWidth() - (int) rect.getWidth()) / 2;
        int centerY = sourceImage.getHeight() / 2;

        w.drawString(text, centerX, centerY);
        w.dispose();
        return sourceImage;

    }

    public BufferedImage mirror(BufferedImage image){

        for(int x = 0; x<image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                image.setRGB(x,y,image.getRGB(image.getWidth()-1 - x,image.getHeight()-1 -y));
            }
        }
        return image;
    }

}
