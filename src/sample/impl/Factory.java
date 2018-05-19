/*Interface for all of the different shape of functions
can use the createPen method*/
package sample.impl;

import sample.Pen;

public interface Factory {
    Draw createPen(Pen p);
}
