import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class RunGame {
    public static int highestScore;
    public static ArrayList<Scores> highScore=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Scores.getHighScores(highScore);
        if(highScore.isEmpty()){
            highestScore=0;
        }
        else{
            highestScore=highScore.get(0).getScore();
        }
        playGame();
    }
    public static void playGame() throws IOException {
        System.out.println("\n\n1 to start game.");
        System.out.println("2 to see high scores.");
        System.out.println("3 to exit game.");
        Scanner scanner=new Scanner(System.in);
        int c;
        System.out.print("Enter choice: ");
        c=scanner.nextInt();
        if(c==1){
            newBoard();
        }
        else if(c==2){
            Scores.printHighScores();
            playGame();
        }
        else if(c==3){
            return;
        }
        else{
            System.out.println("Invalid input!");
            playGame();
        }
    }
    public static void newBoard() throws IOException {
        System.out.println("\n\n8 to move up");
        System.out.println("2 to move down");
        System.out.println("4 to move left");
        System.out.println("6 to move right");
        System.out.println("5 to pause game");
        System.out.println("Starting new board.....\n\n");
        GameBoard b=new GameBoard();
        Moves m=new Moves(b);
        Scanner scanner=new Scanner(System.in);
        int c;
        b.printBoard();
        while(true){
            System.out.print("Enter move: ");
            c= scanner.nextInt();
            System.out.println();
            if(c==8){
                if(m.move[0]){
                    m.moveUp();
                }
                else{
                    System.out.println("Cannot move up!\n");
                }
            }
            else if(c==2){
                if(m.move[1]){
                    m.moveDown();
                }
                else{
                    System.out.println("Cannot move down!\n");
                }
            }
            else if(c==4){
                if(m.move[2]){
                    m.moveLeft();
                }
                else{
                    System.out.println("Cannot move left!\n");
                }
            }
            else if(c==6){
                if(m.move[3]){
                    m.moveRight();
                }
                else{
                    System.out.println("Cannot move right!\n");
                }
            }
            else if(c==5){
                String ch;
                System.out.println("\n'e' to end game.");
                System.out.println("'r' to restart game.");
                System.out.println("'h' to see high scores\n");
                System.out.print("Your choice: ");
                scanner.nextLine();
                ch=scanner.nextLine();
                if(Objects.equals(ch, "e")){
                    System.out.println("Score: "+m.b.score);
                    String name;
//                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    name= scanner.nextLine();
                    Scores sc=new Scores(m.b.score,name);
                    Scores.putHighScores(highScore,sc);
                    playGame();
                    break;
                }
                else if(Objects.equals(ch, "r")){
                    System.out.println("Score: "+m.b.score);
                    String name;
//                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    name= scanner.nextLine();
                    Scores sc=new Scores(m.b.score,name);
                    Scores.putHighScores(highScore,sc);
                    newBoard();
                    break;
                }
                else if(Objects.equals(ch, "h")){
                    Scores.printHighScores();
                    System.out.println("\n");
                    b.printBoard();
                    continue;
                }
                else{
                    b.printBoard();
                    continue;
                }
            }
            else {
                System.out.println("Invalid input!");
                continue;
            }
            m.possibleMoves();
            if(!m.move[0]&&!m.move[1]&&!m.move[2]&&!m.move[3]){
                System.out.println("Game over!");
                System.out.println("Score: "+m.b.score);
                String name;
                scanner.nextLine();
                System.out.print("Enter name: ");
                name= scanner.nextLine();
                Scores sc=new Scores(m.b.score,name);
                Scores.putHighScores(highScore,sc);
                Scores.printHighScores();
                break;
            }
        }
    }
}
