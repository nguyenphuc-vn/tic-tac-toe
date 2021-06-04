package personal;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class Engine {
    private static final Logger logger = Logger.getLogger(Engine.class.getName());
    private char[][] cells = new char[4][4];
    private Set<Integer> set = new HashSet<>();

    public char[][] setup(char move,int r, int c) {
        printDash();
        for (int row = 1; row <= 3; row++) {
            System.out.print("| ");
            for (int col = 1; col <= 3; col++) {
                if(move !=' '){
                    cells[r][c] = move;
                }
                else
                    cells[row][col] = ' ';
                System.out.print(cells[row][col] + " ");
            }
            System.out.println("| ");
        }
        printDash();
        return cells;
    }
    private void printDash() {
        System.out.println("---------");
    }
     private int count() {
        int sum = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                    sum += cells[row][col];
            }
        }
        return sum;
    }
    public boolean findWinner() {
        int totalX = 264;
        int totalO = 237;
        int totalMin = 774;
        int totalMax = 884;
        int sum = count();
        if (set.contains(totalO)) {
            System.out.println("O wins");
            return true;
        }else if (set.contains(totalX)) {
            System.out.println("X wins");
            return true;
        }else if(sum <=totalMax && sum>=totalMin){
            System.out.println("Draw");
            return true;
        }
        return false;
    }
    public void checkState() {
        for (int row = 1; row <= 3; row++) {
            int totalRow = 0;
            int totalCol = 0;
            int leftDiagonal = 0;
            int rightDiagonal = 0;
            for (int col = 1; col <= 3; col++) {
                totalRow += cells[row][col];
            }
            set.add(totalRow);
            logger.info("the total of round  " + row + " is " + totalRow);
            for (int col = 1; col <= 3; col++) {
                totalCol += cells[col][row];
            }
            set.add(totalCol);
            logger.info("the total of round  " + row + " is " + totalCol);
            int hor = 1;
            int ver = 3;
            for (int col = 1; col <= 3; col++) {
                leftDiagonal += cells[hor++][col];
            }
            set.add(leftDiagonal);
            for (int col = 1; col <= 3; col++) {
                rightDiagonal += cells[col][ver--];
            }
            set.add(rightDiagonal);
        }
    }
}
