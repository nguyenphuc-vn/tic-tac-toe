package personal;

import java.util.Scanner;

public class TicTacToeApp {
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        String cell = enterCells();

        Engine engine = new Engine();
        engine.setup(cell);
        engine.addTotalValue();
        System.out.println(engine.checkStates(cell));

    }

    private static String enterCells(){
        System.out.print("Enter cells: ");
        return in.next();
    }

}
