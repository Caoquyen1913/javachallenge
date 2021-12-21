package modules;

public class Canvas implements ICanvas{
    static int CANVAS_BORDER = 2;
    static private String[][] canvas;
    @Override
    public String[][] buildCanvas(int w, int h) {
        canvas = new String[h + CANVAS_BORDER][w + CANVAS_BORDER];

        for (int i = 0; i < h + CANVAS_BORDER; i++) {
            for (int j = 0; j < w + CANVAS_BORDER; j++) {
                if (i == 0 || i == h + CANVAS_BORDER - 1) canvas[i][j] = "-";
                else if (j == 0 || j == w + CANVAS_BORDER - 1) canvas[i][j] = "|";
                else canvas[i][j] = " ";
            }
        }
        return canvas;
    }

    public void setCanvas(String[][] canvas){
        this.canvas = canvas;
    }

    public String[][] getCanvas(){
        return canvas;
    }
    @Override
    public void printCanvas() {
        for (String[] row : canvas) {
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
