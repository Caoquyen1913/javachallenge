package modules;

import java.util.Scanner;

public class Executor {
    final String CANVAS = "c";
    final String LINE = "l";
    final String RECTANGLE = "r";
    final String BUCKET_FILL = "b";
    final String QUIT = "q";
    final String lineCharacter = "x";
    final String rectangleCharacter = "x";

    public void exec(Scanner input) {
        Canvas canvas = new Canvas();
        String[] str;
        boolean hasQuit = false;
        while (!hasQuit) {
            System.out.print("enter: ");
            str = input.nextLine().trim().split(" ");
            String control = str[0].toLowerCase();
            switch (control) {
                case CANVAS:
                    if (str.length == 3) {
                        int w = Integer.parseInt(str[1]);
                        int h = Integer.parseInt(str[2]);
                        canvas.buildCanvas(w, h);
                        canvas.printCanvas();
                    }
                    break;
                case LINE, RECTANGLE:
                    if (str.length == 5 && !canvas.checkCanvasEmpty()) {
                        int x1 = Integer.parseInt(str[1]);
                        int y1 = Integer.parseInt(str[2]);
                        int x2 = Integer.parseInt(str[3]);
                        int y2 = Integer.parseInt(str[4]);
                        Point startPoint = new Point(x1, y1, lineCharacter);
                        Point endPoint = new Point(x2, y2, lineCharacter);

                        canvas.add(control.equals(LINE) ? (new Line(startPoint, endPoint)) : (new Rectangle(startPoint, endPoint)));
                        canvas.printCanvas();
                    }
                    break;
                case BUCKET_FILL:
                    if (str.length == 4 && !canvas.checkCanvasEmpty()) {
                        int x = Integer.parseInt(str[1]);
                        int y = Integer.parseInt(str[2]);
                        String c = str[3];
                        Point point = new Point(x, y, c);
                        canvas.add(new Color(point,c));
                        canvas.printCanvas();
                    }
                    break;
                case QUIT:
                    hasQuit = true;
                    break;
            }
        }
    }
}
