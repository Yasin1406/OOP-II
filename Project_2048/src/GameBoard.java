import java.util.ArrayList;
import java.util.Random;

public class GameBoard{
    public int[][] board=new int[4][4];
    public ArrayList<Integer[]> emptyCells=new ArrayList<Integer[]>();
    public GameBoard(){
        this.initializeBoard();
    }
    public void addNewNumber(){
        int row,column;
        Random rand=new Random();
        int coOrdinateNum=rand.nextInt(emptyCells.size());
        int value=rand.nextInt(10);
        row=emptyCells.get(coOrdinateNum)[0];
        column=emptyCells.get(coOrdinateNum)[1];
        System.out.println("Adding number to ("+row+","+column+")");
        if(value>0){
            board[row][column]=2;
        }
        else{
            board[row][column]=4;
        }
        int[] cell=new int[2];
        cell[0]=row;
        cell[1]=column;
        emptyCells.remove(cell);
    }
    public void initializeBoard(){
        for(int row=0;row<4;row++) {
            for (int column=0;column<4;column++) {
                Integer[] cell=new Integer[2];
                cell[0]=row;
                cell[1]=column;
                emptyCells.add(cell);
            }
        }
        addNewNumber();
        addNewNumber();
    }
    public void printBoard(){
        for(int[] r:board){
            for(int col:r){
                System.out.printf("%6d",col);
            }
            System.out.println();
        }
        System.out.println();
    }
}
