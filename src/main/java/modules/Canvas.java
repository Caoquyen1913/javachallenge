package modules;

public class Canvas implements ICanvas{
    static int CANVAS_BORDER = 2;

    @Override
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

    @Override
    public void printCanvas(String[][] canvasArr) {
        for (String[] row : canvasArr) {
            for (String col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    @Override
    public boolean checkCanvasEmpty(String[][] canvasArr) {
        return canvasArr.length == 0;
    }
}
