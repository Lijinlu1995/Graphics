/*Factory class override the createPen method
for return draw circle*/
package sample.factory;

import sample.Pen;
import sample.draw.Circle;
import sample.impl.Draw;
import sample.impl.Factory;

public class CircleFactory implements Factory {
    @Override
    public Draw createPen(Pen p) {
        return new Circle();
    }
}
