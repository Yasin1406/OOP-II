import java.util.ArrayList;
import java.util.Random;

public class GameBoard{
    public int score;
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
        int value=rand.nextInt(10);
        row=cell/4;
        column=cell-(row*4);
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
        System.out.println("Score: "+score+"\t\t"+"High score: "+RunGame.highestScore);
        char ch='-';
        for(int[] r:board){
            for(int col:r){
                if(col==0){
                    System.out.printf("%6c",ch);
                }
                else{
                    System.out.printf("%6d",col);
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------");
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
