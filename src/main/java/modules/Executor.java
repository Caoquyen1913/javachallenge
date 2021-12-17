package modules;

import java.util.Scanner;

public class Executor {
    public void exec(Scanner input){
        Canvas canvas = new Canvas();
        String[] str;
        String[][] canvasArr = new String[][]{};
        boolean hasQuit = false;
        while (!hasQuit) {
            System.out.print("enter: ");
            str = input.nextLine().trim().split(" ");
            String control;
            control = str[0];
            switch (control) {
                case "C", "c":
                    int w = Integer.parseInt(str[1]);
                    int h = Integer.parseInt(str[2]);
                    canvasArr = canvas.buildCanvas(w, h);
                    canvas.printCanvas(canvasArr);
                    break;
                case "L", "l":
                    if (str.length == 5 && !canvas.checkCanvasEmpty(canvasArr)) {
                        int x1 = Integer.parseInt(str[1]);
                        int y1 = Integer.parseInt(str[2]);
                        int x2 = Integer.parseInt(str[3]);
                        int y2 = Integer.parseInt(str[4]);
                        Line line = new Line(canvasArr, x1, y1, x2, y2);
                        canvas.printCanvas(line.draw());
                    }
                    break;
                case "R", "r":
                    if (str.length == 5 && !canvas.checkCanvasEmpty(canvasArr)) {
                        int x1 = Integer.parseInt(str[1]);
                        int y1 = Integer.parseInt(str[2]);
                        int x2 = Integer.parseInt(str[3]);
                        int y2 = Integer.parseInt(str[4]);
                        Rectangle rectangle = new Rectangle(canvasArr, x1, y1, x2, y2);
                        canvas.printCanvas(rectangle.draw());
                    }
                    break;
                case "B", "b":
                    if (str.length == 4 && !canvas.checkCanvasEmpty(canvasArr)) {
                        int x = Integer.parseInt(str[1]);
                        int y = Integer.parseInt(str[2]);
                        String c = str[3];
                        Color color = new Color(canvasArr, x, y, c);
                        canvas.printCanvas(color.fillColor());
                    }
                    break;
                case "Q", "q":
                    hasQuit = true;
                    break;
            }
        }
    }
}
