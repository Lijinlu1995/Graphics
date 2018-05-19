/*Factory class override the createPen method
for return draw rectangle*/
package sample.factory;

import sample.Pen;
import sample.draw.Rectangle;
import sample.impl.Draw;
import sample.impl.Factory;

public class RectangleFactory implements Factory {
    @Override
    public Draw createPen(Pen p) {
        return new Rectangle();
    }
}
