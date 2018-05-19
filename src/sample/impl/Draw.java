/*Basic function draw class group the functions for other use*/
package sample.impl;

import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import sample.Pen;

public abstract class Draw {
    public abstract Group creatDraw(Group group, Pen p, AnchorPane drawAnchorPane);
}
