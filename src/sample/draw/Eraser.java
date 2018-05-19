/*Circle class override the createDraw
 * to achieve the eraser function*/
package sample.draw;

import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import sample.Pen;
import sample.impl.Draw;
import sample.impl.PenShape;
import sample.shape.EraserShape;

public class Eraser extends Draw {
    @Override
    public Group creatDraw(Group group, Pen p, AnchorPane drawAnchorPane) {
        PenShape penShapeEraser = new EraserShape();
        javafx.scene.shape.Shape shape = penShapeEraser.setDraw(p);
        p.setStartX(p.endX);
        p.setStartY(p.endY);
        group.getChildren().add(shape);
        drawAnchorPane.getChildren().remove(group);
        drawAnchorPane.getChildren().add(group);
        return group;
    }
}
