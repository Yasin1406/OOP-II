public class RunGame {
    public static void main(String[] args) {
        GameBoard b=new GameBoard();
        Moves m=new Moves(b);
        b.printBoard();
        m.moveUp();
        m.moveUp();
        m.moveUp();
        m.moveUp();
        m.moveUp();
        m.moveUp();
        m.moveUp();
    }

}
