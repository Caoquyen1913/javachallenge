package modules;

public interface ICanvas {
    String[][] buildCanvas(int w, int h);
    void printCanvas();
    boolean checkCanvasEmpty(String[][] canvasArr);
}
