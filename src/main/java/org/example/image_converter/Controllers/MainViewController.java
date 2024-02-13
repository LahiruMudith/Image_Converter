package org.example.image_converter.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.ImageTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.w3c.dom.Document;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static javafx.scene.image.Image.*;


public class MainViewController     {
    @FXML
    ImageView image;

    @FXML
    private ImageView image2;

    @FXML
    void upload(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png"));

        File selectedFile = fileChooser.showOpenDialog(null);


        if (selectedFile != null) {
            Image newImage = new Image(selectedFile.toURI().toString());
            image.setImage(newImage);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Image Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select an image file.");
            alert.showAndWait();
        }
    }

    @FXML
    void SVGButton(ActionEvent event) {
        Image newImage = image.getImage();
        image2.setImage(newImage);

        File file = new File("C:/Users/Lahiru Mudith/Downloads/SaleHubLogo.png");

//        if (file==null) {
//            System.out.println("file is null");
//        }else {
//            System.out.println(file);
//        }

        try {
            BufferedImage BufImage = ImageIO.read(file);
            ImageIO.write(BufImage, "svg", new File("./NewImages/new.svg"));
            System.out.println("Done");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//
//    public static void main(String[] args) {
//        convertImageToSVG("C:/Users/Lahiru Mudith/Downloads/SaleHubLogo.png", "./NewImages/new.svg");
//    }
//
//    public static void convertImageToSVG(String inputImagePath, String outputSVGPath) {
//        try {
//            BufferedImage bufferedImage = ImageIO.read(new File(inputImagePath));
//            BufferedImageTranscoder transcoder = new BufferedImageTranscoder(bufferedImage);
//
//            TranscoderInput transcoderInput = new TranscoderInput(new File(inputImagePath).toURI().toString());
//            TranscoderOutput transcoderOutput = new TranscoderOutput(new FileOutputStream(outputSVGPath));
//
//            transcoder.transcode(transcoderInput, transcoderOutput);
//            System.out.println("Done");
//        } catch (IOException | TranscoderException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    static class BufferedImageTranscoder extends ImageTranscoder {
//        private BufferedImage bufferedImage;
//
//        BufferedImageTranscoder(BufferedImage bufferedImage) {
//            this.bufferedImage = bufferedImage;
//        }
//
//        @Override
//        protected void transcode(Document document, String uri, TranscoderOutput transcoderOutput) throws TranscoderException {
//            try {
//                ImageIO.write(bufferedImage, "png", transcoderOutput.getOutputStream());
//            } catch (IOException e) {
//                throw new TranscoderException(e);
//            }
//        }
//
//        @Override
//        public BufferedImage createImage(int i, int i1) {
//            return null;
//        }
//
//        @Override
//        public void writeImage(BufferedImage bufferedImage, TranscoderOutput transcoderOutput) throws TranscoderException {
//
//        }
//    }
}
