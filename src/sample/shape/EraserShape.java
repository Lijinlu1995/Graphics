/*A shape object of Line in order to achieve the eraser function,
which the width of 40 of the eraser size,
set the start point and end point of this line,
also set the pen color and filled color*/
package sample.shape;

import javafx.scene.shape.Line;
import sample.Pen;
import sample.impl.PenShape;

public class EraserShape implements PenShape {


    @Override
    public javafx.scene.shape.Shape setDraw(Pen p) {
        //create the eraser lines
        Line eraser = new Line();
        eraser.setStrokeWidth(40);
        eraser.setFill(p.fillColor);
        eraser.setStroke(p.penColor);
        eraser.setStartX(p.getStartX());
        eraser.setStartY(p.getStartY());
        eraser.setEndX(p.getEndX());
        eraser.setEndY(p.getEndY());

        return eraser;
    }

}
