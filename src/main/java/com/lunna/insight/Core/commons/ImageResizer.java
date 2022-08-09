
package com.lunna.insight.Core.commons;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageResizer {

    public static void resize(String inputImagePath, String outputImagePath, int scaledWidth, int scaledHeight)
        throws IOException {
        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);

        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
            scaledHeight, inputImage.getType());

        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
            .lastIndexOf(".") + 1);

        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
    }

    public static void resize(String inputImagePath,
                              String outputImagePath, double percent) throws IOException {
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        int scaledWidth = (int) (inputImage.getWidth() * percent);
        int scaledHeight = (int) (inputImage.getHeight() * percent);
        resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
    }

    public static void main(String[] args) {
        String inputImagePath = "/home/java30/Pictures/11222342_859824020768662_5274573309619174773_n.jpg";
        String outputImagePath1 = "/home/java30/Pictures/Fixed100*100.jpg";

        try {
            // resize to a fixed width (not proportional)
            int scaledWidth = 100;
            int scaledHeight = 100;
            ImageResizer.resize(inputImagePath, outputImagePath1, scaledWidth, scaledHeight);

            // resize smaller by 50%
            /*double percent = 0.5;
            ImageResizer.resize(inputImagePath, outputImagePath2, percent);*/

            // resize bigger by 50%
            /*percent = 1.5;
            ImageResizer.resize(inputImagePath, outputImagePath3, percent);*/

        } catch (IOException ex) {
            //System.out.println("Error resizing the image.");
            ex.printStackTrace();
        }
    }

}
