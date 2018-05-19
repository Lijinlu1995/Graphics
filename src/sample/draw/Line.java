/*Circle class override the createDraw
 * to achieve the draw line function*/
package sample.draw;

import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import sample.Pen;
import sample.impl.Draw;
import sample.impl.PenShape;
import sample.shape.LineShape;

public class Line extends Draw {
    @Override
    public Group creatDraw(Group group, Pen p, AnchorPane drawAnchorPane) {
        PenShape penShapeLine = new LineShape();
        javafx.scene.shape.Shape shape = penShapeLine.setDraw(p);

        group.getChildren().clear();
        group.getChildren().add(shape);
        drawAnchorPane.getChildren().remove(group);
        drawAnchorPane.getChildren().add(group);
        return group;
    }
}
