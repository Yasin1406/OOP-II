import java.util.Scanner;

public class RunGame {
    public static void main(String[] args) {
        GameBoard b=new GameBoard();
        Moves m=new Moves(b);
        b.printBoard();
//        m.moveUp();
//        m.moveUp();
//        m.moveUp();
//        m.moveUp();
//        m.moveUp();
//        m.moveUp();
//        m.moveUp();
//
//        m.moveDown();
//        m.moveDown();
//        m.moveDown();
//        m.moveDown();
//        m.moveDown();
//        m.moveDown();
//        m.moveDown();
//        m.moveDown();
//        m.moveDown();
//        m.moveDown();
//

//        m.moveRight();
//        m.moveRight();
//        m.moveRight();
//        m.moveRight();
//        m.moveRight();
//        m.moveRight();
//        m.moveRight();
//        m.moveRight();
//        m.moveRight();
//        m.moveRight();
//        m.moveRight();

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter move: ");
        int c=sc.nextInt();
        while(c!=5){
            if(c==8){
                m.moveUp();
            }
            else if(c==2){
                m.moveDown();
            }
            else if(c==4){
                m.moveRight();
            }
            else if(c==6){
                m.moveLeft();
            }
            c=sc.nextInt();
        }

    }

}
