import java.util.Scanner;

public class RunGame {
    public static void main(String[] args) {
        GameBoard b=new GameBoard();
        Moves m=new Moves(b);
        boolean move[]={true,true,true,true};
        b.printBoard();
        Scanner sc=new Scanner(System.in);
        int c=sc.nextInt();
        while(c!=5){
            if(c==8){
                if(!move[0]){
                    System.out.println("Cannot move up!");
                }
                else{
                    m.moveUp();
                }
            }
            else if(c==2){
                if(!move[1]){
                    System.out.println("Cannot move down!");
                }
                else{
                    m.moveDown();
                }
            }
            else if(c==4){
                if(!move[2]){
                    System.out.println("Cannot move left!");
                }
                else{
                    m.moveLeft();
                }
            }
            else if(c==6){
                if(!move[3]){
                    System.out.println("Cannot move right!");
                }
                else{
                    m.moveRight();
                }
            }
            m.possibleMoves(move);
            if(!move[0]&&!move[1]&&!move[2]&&!move[3]){
                System.out.println("Game Over!");
                break;
            }
            c=sc.nextInt();

        }

    }

}
