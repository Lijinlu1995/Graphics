/*Circle class override the createDraw
* to achieve the draw circle function*/
package sample.draw;

import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import sample.Pen;
import sample.impl.Draw;
import sample.impl.PenShape;
import sample.shape.CircleShape;

public class Circle extends Draw{
    @Override
    public Group creatDraw(Group group, Pen p, AnchorPane drawAnchorPane) {
        PenShape penShapeCicle = new CircleShape();
        javafx.scene.shape.Shape shape = penShapeCicle.setDraw(p);
        //Removes all of the elements in group children
        group.getChildren().clear();
        group.getChildren().add(shape);
        drawAnchorPane.getChildren().remove(group);
        drawAnchorPane.getChildren().add(group);
        return group;
    }
}
