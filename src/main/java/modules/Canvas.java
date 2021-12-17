package modules;

public class Canvas {
    static int CANVAS_BORDER = 2;

    public String[][] buildCanvas(int w, int h) {
        String[][] canvasArr = new String[h + CANVAS_BORDER][w + CANVAS_BORDER];

        for (int i = 0; i < h + CANVAS_BORDER; i++) {
            for (int j = 0; j < w + CANVAS_BORDER; j++) {
                if (i == 0 || i == h + CANVAS_BORDER - 1) canvasArr[i][j] = "-";
                else if (j == 0 || j == w + CANVAS_BORDER - 1) canvasArr[i][j] = "|";
                else canvasArr[i][j] = " ";
            }
        }
        return canvasArr;
    }

    public boolean checkCanvasEmpty(String[][] canvasArr) {
        return canvasArr.length == 0;
    }
}
