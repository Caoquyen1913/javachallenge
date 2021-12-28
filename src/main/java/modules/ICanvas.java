package modules;

import java.util.ArrayList;

public interface ICanvas {
    ArrayList<ArrayList<Point>> buildCanvas(int w, int h);
    void printCanvas();
    boolean checkCanvasEmpty();
}
