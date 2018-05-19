/*Factory class override the createPen method
for return function pencil*/
package sample.factory;

import sample.Pen;
import sample.draw.Pencil;
import sample.impl.Draw;
import sample.impl.Factory;

public class PencilFactory implements Factory {
    @Override
    public Draw createPen(Pen p) {
        return new Pencil();
    }
}
