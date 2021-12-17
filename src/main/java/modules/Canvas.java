package modules;

public class Canvas {
    static int CANVAS_BORDER = 2;

    public String[][] buildCanvas(int w, int h) {
        String[][] canvasArr = new String[h + CANVAS_BORDER][w + CANVAS_BORDER];
//        for (int j = 1; j <= h; j++) {
//            canvasArr[j][0] = "|";
//            canvasArr[j][w + CANVAS_BORDER - 1] = "|";
//        }
//        for (int i = 0; i < w + CANVAS_BORDER; i++) {
//            canvasArr[0][i] = "-";
//            canvasArr[h + CANVAS_BORDER - 1][i] = "-";
//        }
        for (int i = 0; i <= h; i++) {
            for (int j = 0; j <= w + CANVAS_BORDER; j++) {
                if (j == 0 || j == w + CANVAS_BORDER - 1) {
                    canvasArr[i][j] = "|";
                } else if (i == 0 || i == h + CANVAS_BORDER - 1) {
                    canvasArr[i][j] = "-";
                } else
                    canvasArr[i][j] = " ";
            }
        }
        return canvasArr;
    }

    public boolean checkCanvasEmpty(String[][] canvasArr) {
        return canvasArr.length == 0;
    }
}
