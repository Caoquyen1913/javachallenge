package modules;

public interface ICanvas {
    String[][] buildCanvas(int w, int h);
    void printCanvas(String[][] canvasArr);
    boolean checkCanvasEmpty(String[][] canvasArr);
}
