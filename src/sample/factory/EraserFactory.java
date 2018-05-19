/*Factory class override the createPen method
for return function eraser*/
package sample.factory;

import sample.Pen;
import sample.draw.Eraser;
import sample.impl.Draw;
import sample.impl.Factory;

public class EraserFactory implements Factory {
    @Override
    public Draw createPen(Pen p) {
        return new Eraser();
    }
}
