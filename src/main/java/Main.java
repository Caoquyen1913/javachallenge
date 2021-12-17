import modules.Executor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Executor executor = new Executor();
        executor.exec(input);
    }
}
