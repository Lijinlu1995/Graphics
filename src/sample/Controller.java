/*Controller class to get the ask action from fxml interface
* call the relative method to achieve the function
* the connection between the fxml and java*/
package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import sample.factory.*;
import sample.impl.Draw;
import sample.impl.Factory;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static javafx.scene.paint.Color.WHITE;

public class Controller {
    @FXML
    private ColorPicker penColorPicker;
    @FXML
    private ColorPicker fillColorPicker;
    @FXML
    private AnchorPane drawAnchorPane;
    @FXML
    private Group drawGroup;
    @FXML
    private MainStage mainStage;

    Pen p = new Pen();
    static boolean flag = true;
    Group group = new Group();

    public void setGroup(Group group) {
        this.group = group;
    }

    //set the image num for different imag name
    static int imgNum = 0;

    @FXML
    public void setOpenFile() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(mainStage);
        if (file != null) {
            try {
                Image image = new Image(new FileInputStream(file));
                ImageView iv = new ImageView();
                iv.setImage(image);
                drawAnchorPane.getChildren().add(iv);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @FXML
    public void setSaveFile() {
        imgNum++;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save images");//save the image as .png
        fileChooser.setInitialFileName("IMG_" + imgNum + ".png");
        File file = fileChooser.showSaveDialog(mainStage);
        save(file);
    }

    private void save(File file) {
        String extension = "";
        String name = file.getName();
        if (name.contains(".")) {
            int start = name.lastIndexOf(".");
            extension = file.getName().substring(start + 1);

        } else {
            extension = "jpg";
        }
        WritableImage image = drawAnchorPane.snapshot(new SnapshotParameters(), null);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            JOptionPane.showMessageDialog(null, "Save Success",
                    "Success", JOptionPane.NO_OPTION);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Save Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    public void setPenColor(ActionEvent t) throws Exception {
        p.setPenColor(penColorPicker.getValue());
    }

    @FXML
    public void setFillColor(ActionEvent t) throws Exception {
        p.setFillColor(fillColorPicker.getValue());
    }

    @FXML
    public void setPencilDraw() {

        p.setDrawShape("pencil");
    }

    @FXML
    public void setLineDraw() {
        p.setDrawShape("line");
    }

    @FXML
    public void setCicleDraw() {
        p.setDrawShape("cicle");
    }

    @FXML
    public void setRectangleDraw() {
        p.setDrawShape("rectangle");
    }

    @FXML
    public void setEraserDraw() {
        p.setFillColor(WHITE);
        p.setPenColor(WHITE);
        p.setDrawShape("eraser");
    }

    @FXML
    public void drawMousePressed() {
        drawAnchorPane.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Group dGroup = new Group();
                setGroup(dGroup);
                p.setStartX(event.getX());
                p.setStartY(event.getY());
            }
        });
    }


    @FXML
    public void drawMouseDragReleased() {
        drawAnchorPane.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                p.setEndX(event.getX());
                p.setEndY(event.getY());
            }
        });
    }

    @FXML
    public void drawMouseDragged() {

        drawAnchorPane.setOnMouseDragged(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (flag) {
                    p.setStartX(event.getX());
                    p.setStartY(event.getY());
                    flag = false;

                } else {

                    p.setEndX(event.getX());
                    p.setEndY(event.getY());
                    drawOperation();

                }
            }
        });
    }

    public void draw(Factory operFactory, Group group) {
        Draw draw = operFactory.createPen(p);
        draw.creatDraw(group, p, drawAnchorPane);
    }

    public void drawOperation() {
        switch (p.getDrawShape()) {

            case "pencil":
                Factory operFactoryPencil = new PencilFactory();
                draw(operFactoryPencil, drawGroup);
                break;

            case "line":
                Factory operFactoryLine = new LineFactory();
                draw(operFactoryLine, group);
                break;
            case "rectangle":
                Factory operFactoryRectangle = new RectangleFactory();
                draw(operFactoryRectangle, group);
                break;
            case "cicle":
                Factory operFactoryCicle = new CircleFactory();
                draw(operFactoryCicle, group);
                break;
            case "eraser":
                Factory operFactoryEraser = new EraserFactory();
                draw(operFactoryEraser, group);
                break;
        }
    }
}
