/*A shape object of circle,
set the center position and radius of the circle,
also set the pen color and filled color*/
package sample.shape;

import javafx.scene.shape.Circle;
import sample.Pen;
import sample.impl.PenShape;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class CircleShape implements PenShape {
    @Override
    public javafx.scene.shape.Shape setDraw(Pen p) {
        // create the circles
        Circle circle = new Circle();
        circle.setFill(p.fillColor);
        circle.setStroke(p.penColor);
        circle.setCenterX(p.startX - (p.startX - p.endX) / 2);
        circle.setCenterY(p.startY - (p.startY - p.endY) / 2);
        circle.setRadius(sqrt(pow((p.endX - p.startX), 2) + pow((p.endY - p.startY), 2)) / 2);
        return circle;

    }
}
