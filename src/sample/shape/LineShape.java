/*A shape object of line,
set the start position and end position of the line,
also set the pen color and filled color*/
package sample.shape;

import javafx.scene.shape.Line;
import sample.Pen;
import sample.impl.PenShape;

public class LineShape implements PenShape {

    @Override
    public javafx.scene.shape.Shape setDraw(Pen p) {
        //create the lines
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
