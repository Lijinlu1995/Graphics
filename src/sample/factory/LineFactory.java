/*Factory class override the createPen method
for return draw line*/
package sample.factory;

import sample.Pen;
import sample.draw.Line;
import sample.impl.Draw;
import sample.impl.Factory;

public class LineFactory implements Factory {
    @Override
    public Draw createPen(Pen p) {
        return new Line();
    }
}
