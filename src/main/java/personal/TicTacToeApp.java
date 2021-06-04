package personal;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TicTacToeApp {
    private static final Scanner in = new Scanner(System.in).useDelimiter("\n");
    private static Engine engine;
    public static void main(String[] args) {
        engine = new Engine();
        char [][] cells = engine.setup(' ',1,1);
        int count =1;
        do {
            move(cells, count++);
            engine.checkState();
        } while (!engine.findWinner());
    }

    private static char switchXO(int count){
        return count%2 ==0 ?'O':'X';
    }

    private static void move(char [][] cells,int count){
        String coor ;
        while(true){
            coor = enterCoordinates();
            int row= Integer.parseInt(String.valueOf(coor.charAt(0)));
            int col= Integer.parseInt(String.valueOf(coor.charAt(2)));
            if(isOccupied(cells,row,col)){
               char move = switchXO(count);
               engine.setup(move,row,col);
               break;
           }
            else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        }
    }

    private static boolean isOccupied(char [][] cells,int r,int c){
        return cells[r][c] != 'X'&&cells[r][c] != 'O';
    }
    private static String enterCoordinates(){
        Pattern pattern = Pattern.compile("[1-3]\\s[1-3]");
        Pattern notNumber = Pattern.compile("[a-zA-z]\\s[a-zA-z]");
        Pattern outOfRange= Pattern.compile("[4-9^1-3]\\s[4-9^1-3]");
        System.out.println("Enter the coordinates: ");
        String str = in.next();
        while(!pattern.matcher(str).matches()){
            if(notNumber.matcher(str).matches()){
                System.out.println("You should enter numbers!");
            }else if(outOfRange.matcher(str).matches()){
                System.out.println("Coordinates should be from 1 to 3!");
            }
            System.out.println("Enter the coordinates: ");
            str = in.next();
        }
        return str;
    }

}
