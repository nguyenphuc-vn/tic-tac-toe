package personal;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class Engine {
    private static final Logger logger = Logger.getLogger(Engine.class.getName());
    private Character[][] cells = new Character[4][4];
    private Set<Integer> set = new HashSet<>();

    public Character[][] setup(String cell,boolean fromCoor,int r, int c) {
        int k = 0;
        printDash();
        for (int row = 1; row <= 3; row++) {
            System.out.print("| ");
            for (int col = 1; col <= 3; col++) {
                if(fromCoor){
                    cells[r][c] = 'X';
                }
                else
                cells[row][col] = cell.charAt(k++);
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


 /*   private boolean isImpossible(String input){
        int len = input.length();
        int countX =0;
        int countO =0;
        for(int i=0; i<len;i++){
            if(input.charAt(i)=='X'){
                countX++;
            }
            else if(input.charAt(i)=='O'){
                countO++;
            }
        }
        return countX - countO >= 2 || countO - countX >= 2;
    }
    private boolean isFinished(String input){
        return input.contains(" ");
    }
    public String checkStates(String input) {
        if (isImpossible(input)) {
            return "Impossible";
        }
        else if (isFinished(input)) {
            return "Game not finished";
        } else
            return findWinner(input);
    }

    public String findWinner(String input) {
        int totalX = 264;
        int totalO = 237;
        if (set.contains(totalO)) {
            return "O wins";
        } else if (set.contains(totalX)) {
            return "X wins";
        }else if(input.contains("_")){
            return "Game not finished";
        }
        return "Draw";
    }

    public void addTotalValue() {
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
    }*/
}
 /* private int count() {
        int sum = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                    sum += cells[row][col];
            }
        }
        return sum;
    }

    public boolean checkFinished() {
        int total = 747;
        int sum = count();

        return sum >= total;
    }

    public boolean impossible() {
        int total = count();
        return (total < 747 || total > 884);
    }*/