/*Circle class override the createDraw
 * to achieve the pencil function*/
package sample.draw;

import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Shape;
import sample.Pen;
import sample.impl.Draw;
import sample.impl.PenShape;
import sample.shape.PencilShape;

public class Pencil extends Draw{
    @Override
    public Group creatDraw(Group group, Pen p, AnchorPane drawAnchorPane) {

        PenShape penShapePencil = new PencilShape();
        Shape shape = penShapePencil.setDraw(p);
        p.setStartX(p.endX);
        p.setStartY(p.endY);
        group.getChildren().add(shape);
        return null;
    }
}
