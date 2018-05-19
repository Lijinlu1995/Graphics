/*A shape object of rectangle,
get the abstract of mouse position to get rectangle width and height
the width and height properties define the size of a rectangle,
also set the pen color and filled color*/
package sample.shape;

import javafx.scene.shape.Rectangle;
import sample.Pen;
import sample.impl.PenShape;

import static java.lang.Math.abs;

public class RectangleShape implements PenShape {

    @Override
    public javafx.scene.shape.Shape setDraw(Pen p) {
        //create the rectangle
        Rectangle r = new Rectangle();
        r.setStroke(p.penColor);
        r.setFill(p.fillColor);

        if(p.getStartX() >= p.getEndX() && p.getStartY() >= p.getEndY()){
            r.setX(p.getEndX());
            r.setY(p.getEndY());
        }
        else if(p.getStartX() <= p.getEndX() && p.getStartY() <= p.getEndY()){
            r.setX(p.getStartX());
            r.setY(p.getStartY());
        }else if(p.getStartX() > p.getEndX() && p.getStartY() < p.getEndY()){
            r.setX(p.getEndX());
            r.setY(p.getStartY());
        }else{
            r.setX(p.getStartX());
            r.setY(p.getEndY());
        }

        r.setWidth(abs(p.getEndX() - p.getStartX()));
        r.setHeight(abs(p.getEndY() - p.getStartY()));
        return r;
    }
}
