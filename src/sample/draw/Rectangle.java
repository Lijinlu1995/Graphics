/*Circle class override the createDraw
 * to achieve the draw rectangle function*/
package sample.draw;

import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import sample.Pen;
import sample.impl.Draw;
import sample.impl.PenShape;
import sample.shape.RectangleShape;

public class Rectangle extends Draw{
    @Override
    public Group creatDraw(Group group, Pen p, AnchorPane drawAnchorPane) {
        PenShape penShapeRectangle = new RectangleShape();
        javafx.scene.shape.Shape shape = penShapeRectangle.setDraw(p);

        group.getChildren().clear();
        group.getChildren().add(shape);
        drawAnchorPane.getChildren().remove(group);
        drawAnchorPane.getChildren().add(group);
        return group;
    }
}
