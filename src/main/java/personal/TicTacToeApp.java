package personal;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TicTacToeApp {
    private static final Scanner in = new Scanner(System.in).useDelimiter("\n");
    private static Engine engine;
    public static void main(String[] args) {
        String cell = enterCells();
        engine = new Engine();
        Character [][] cells = engine.setup(cell,false,0,0);
       /* engine.addTotalValue();
        System.out.println(engine.checkStates(cell));*/
        move(cells);

    }

    private static String enterCells(){
        System.out.print("Enter cells: ");
        return in.next();
    }
    private static void move(Character [][] cells){
        String coor;
        while(true){
            coor =  enterCoordinates();
            int row= Integer.parseInt(String.valueOf(coor.charAt(0)));
            int col= Integer.parseInt(String.valueOf(coor.charAt(2)));
            if(isOccupied(cells,row,col)){
               engine.setup(null,true,row,col);
               break;
           }
            else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        }
    }

    private static boolean isOccupied(Character [][] cells,int r,int c){
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
