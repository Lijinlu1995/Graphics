/*A shape object of line in order to achieve the pencil function,
line of pencil will get the mouse position in time
set the start position and end position of the line,
also set the pen color and filled color*/
package sample.shape;

import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import sample.Pen;
import sample.impl.PenShape;

public class PencilShape implements PenShape {
    @Override
    public Shape setDraw(Pen p) {
        //create the pencil lines
        Line line = new Line();
        line.setFill(p.fillColor);
        line.setStroke(p.penColor);
        line.setStartX(p.getStartX());
        line.setStartY(p.getStartY());
        line.setEndX(p.getEndX());
        line.setEndY(p.getEndY());
        return line;
    }
}
