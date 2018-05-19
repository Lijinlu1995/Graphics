/*This class including the getter and setter groups
* in order to get properties of each value*/
package sample;

import javafx.scene.paint.Color;

public class Pen {

    public Color penColor;
    public String drawShape;
    public Color fillColor;
    public Double startX;
    public Double startY;
    public Double endX;
    public Double endY;

    public Color getPenColor() {
        return penColor;
    }

    public void setPenColor(Color color) {
        this.penColor = color;
    }

    public String getDrawShape() {
        return drawShape;
    }

    public void setDrawShape(String drawShape) {
        this.drawShape = drawShape;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Double getStartX() {
        return startX;
    }

    public void setStartX(Double startX) {
        this.startX = startX;
    }

    public Double getStartY() {
        return startY;
    }

    public void setStartY(Double startY) {
        this.startY = startY;
    }

    public Double getEndX() {
        return endX;
    }

    public void setEndX(Double endX) {
        this.endX = endX;
    }

    public Double getEndY() {
        return endY;
    }

    public void setEndY(Double endY) {
        this.endY = endY;
    }

}
