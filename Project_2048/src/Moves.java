public class Moves {
    GameBoard b;
    public Moves(GameBoard b){
        this.b=b;
    }
    public void moveUp(){
        int i,j,k;
        Integer[] cell= new Integer[2];
        boolean isPossible=false;
        for(i=0;i<4;i++){
            int[] col={b.board[0][i],b.board[1][i],b.board[2][i],b.board[3][i]};
            if(col[0]==0){
                if(col[1]>0||col[2]>0||col[3]>0){
                    isPossible=true;
                    break;
                }
                else{
                    continue;
                }
            }
            int currNonZero=col[0],nonZeroInterval=0;
            for(j=1;j<4;j++){
                if(col[j]>0){
                    if(currNonZero==col[j]){
                        isPossible=true;
                        break;
                    }
                    else{
                        if(nonZeroInterval>0){
                            isPossible=true;
                            break;
                        }
                        else{
                            nonZeroInterval=0;
                        }
                    }
                }
                else{
                    nonZeroInterval++;
                }
            }
        }
        if(!isPossible){
            System.out.println("Cannot move up");
            return;
        }
        int currRow,row,column;
        for(row=1;row<4;row++){
            for(column=0;column<4;column++){
                boolean[] isColVisited={false,false,false,false};
                if(b.board[row][column]==0){
                    continue;
                }
                currRow=row-1;
                while(currRow>-1){
                    if(b.board[currRow][column]>0){
                        break;
                    }
                    currRow--;
                }
                if(currRow<0){
                    b.board[0][column]=b.board[row][column];
                    cell= new Integer[2];
                    cell[0]=0;
                    cell[1]=column;
                    b.emptyCells.remove(cell);
                    b.board[row][column]=0;
                    cell= new Integer[2];
                    cell[0]=row;
                    cell[1]=column;
                    b.emptyCells.add(cell);
                }
                else{
                    if(b.board[currRow][column]==b.board[row][column]){
                        if(isColVisited[currRow]){
                            b.board[currRow+1][column]=b.board[row][column];
                            cell= new Integer[2];
                            cell[0]=currRow+1;
                            cell[1]=column;
                            b.emptyCells.remove(cell);
                            if(currRow+1!=row){
                                b.board[row][column]=0;
                                cell= new Integer[2];
                                cell[0]=row;
                                cell[1]=column;
                                b.emptyCells.add(cell);
                            }
                        }
                        else{
                            b.board[currRow][column]*=2;
                            b.board[row][column]=0;
                            cell= new Integer[2];
                            cell[0]=row;
                            cell[1]=column;
                            b.emptyCells.add(cell);
                        }
                    }
                    else{
                        b.board[currRow+1][column]=b.board[row][column];
                        cell= new Integer[2];
                        cell[0]=currRow+1;
                        cell[1]=column;
                        b.emptyCells.remove(cell);
                        if(currRow+1!=row){
                            b.board[row][column]=0;
                            cell= new Integer[2];
                            cell[0]=row;
                            cell[1]=column;
                            b.emptyCells.add(cell);
                        }
                    }
                }
            }
        }

        b.addNewNumber();
        b.printBoard();
    }
}
