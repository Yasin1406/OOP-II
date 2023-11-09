import java.util.ArrayList;
import java.util.Random;

public class GameBoard{
    public int[][] board=new int[4][4];
    public ArrayList<Integer> emptyCells=new ArrayList<Integer>();
    public GameBoard(){
        this.initializeBoard();
    }
    public void addNewNumber(){
        int row,column;
        Random rand=new Random();
        int coOrdinateNum=rand.nextInt(emptyCells.size());
        int cell=emptyCells.get(coOrdinateNum);
//        System.out.println("Cell: "+cell);
        int value=rand.nextInt(10);
        row=cell/4;
        column=cell-(row*4);
        System.out.println("Adding number to ("+row+","+column+")");
        if(value>0){
            board[row][column]=2;
        }
        else{
            board[row][column]=4;
        }
        emptyCells.remove(coOrdinateNum);
    }
    public void initializeBoard(){
        for(Integer cell=0;cell<16;cell++){
            emptyCells.add(cell);
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

    void removeEmptyCell(int row,int col){
        Integer cellToRemove=(row*4)+col;
        emptyCells.remove(cellToRemove);
    }

    void addEmptyCell(int row,int col){
        Integer cellToAdd=(row*4)+col;
        emptyCells.add(cellToAdd);
    }
}
