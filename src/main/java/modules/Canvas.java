package modules;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Canvas implements ICanvas {
    static int CANVAS_BORDER = 2;
    private ArrayList<ArrayList<Point>> canvas;
    String spaceCharacter = " ";
    String horizontalCharacter = "-";
    String verticalCharacter = "|";
    String lineCharacter = "x";

    @Override
    public ArrayList<ArrayList<Point>> buildCanvas(int w, int h) {
        canvas = new ArrayList<>();
        for (int i = 0; i < h + CANVAS_BORDER; i++) {
            ArrayList<Point> row = new ArrayList<>();
            for (int j = 0; j < w + CANVAS_BORDER; j++) {
                if (i == 0 || i == h + CANVAS_BORDER - 1) row.add(new Point(i, j, horizontalCharacter));
                else if (j == 0 || j == w + CANVAS_BORDER - 1) row.add(new Point(i, j, verticalCharacter));
                else row.add(new Point(i, j, spaceCharacter));
            }
            canvas.add(row);
        }
        return canvas;
    }

    public void add(@NotNull IShape shape) {
        ArrayList<Point> shapeDrawer = shape.draw();
        Point startPoint = shape.getStartPoint();
        Point endPoint = shape.getEndPoint();
        if (isPointOverCanvas(startPoint) && isPointOverCanvas(endPoint)) {
            shapeDrawer.forEach(point -> canvas.get(point.getX()).set(point.getY(), point));
        }
    }

    public void add(@NotNull Color color) {
        Point fillPoint = color.getFillPoint();
        ArrayList<Point> arr = getPointNotEmpty();
        if (isPointOverCanvas(fillPoint)) {
            ArrayList<Point> shapeDrawer = color.fillColor(arr);
            shapeDrawer.forEach(point -> canvas.get(point.getX()).set(point.getY(), point));
        }
    }

    ArrayList<Point> getPointNotEmpty(){
        ArrayList<Point> arr = new ArrayList<>();
        canvas.forEach(row-> row.forEach(col-> {
            if(col.getCharacter().equals(horizontalCharacter)||col.getCharacter().equals(verticalCharacter)||col.getCharacter().equals(lineCharacter)){
                arr.add(new Point(col.getX(), col.getY()));
            }
        }));
        return arr;
    }


    @Override
    public void printCanvas() {
        canvas.forEach(row -> {
            row.forEach(col -> System.out.print(col.getCharacter()));
            System.out.println();
        });
    }

    @Override
    public boolean checkCanvasEmpty() {
        return canvas.size() == 0;
    }

    boolean isPointOverCanvas(Point point) {
        int maxCol = canvas.get(0).size();
        int maxRow = canvas.size();
        int x = point.getX();
        int y = point.getY();
        return y < maxRow - 1 && y > 0 && x < maxCol && x > 0;
    }
}
