public class Moves {
    GameBoard b;
    public Moves(GameBoard b){
        this.b=b;
    }
    public void moveUp(){
        int i,j;
        boolean isPossible=false;
        for(i=0;i<4;i++){
            int[] col={b.board[0][i],b.board[1][i],b.board[2][i],b.board[3][i]};
            if(col[0]==0){
                if(col[1]>0||col[2]>0||col[3]>0){
                    isPossible=true;
                    break;
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
                    b.removeEmptyCell(0,column);
                    b.board[row][column]=0;
                    b.addEmptyCell(row,column);
                }
                else{
                    if(b.board[currRow][column]==b.board[row][column]){
                        if(isColVisited[currRow]){
                            b.board[currRow+1][column]=b.board[row][column];
                            b.removeEmptyCell(currRow+1,column);
                            if(currRow+1!=row){
                                b.board[row][column]=0;
                                b.addEmptyCell(row,column);
                            }
                        }
                        else{
                            b.board[currRow][column]*=2;
                            b.board[row][column]=0;
                            b.addEmptyCell(row,column);
                        }
                    }
                    else{
                        b.board[currRow+1][column]=b.board[row][column];
                        b.removeEmptyCell(currRow+1,column);
                        if(currRow+1!=row){
                            b.board[row][column]=0;
                            b.addEmptyCell(row,column);
                        }
                    }
                }
            }
        }
        b.addNewNumber();
        b.printBoard();
    }
    public void moveDown(){
        int i,j;
        boolean isPossible=false;
        for(i=0;i<4;i++){
            int[] col={b.board[0][i],b.board[1][i],b.board[2][i],b.board[3][i]};
            if(col[3]==0){
                if(col[1]>0||col[2]>0||col[0]>0){
                    isPossible=true;
                    break;
                }
            }
            int currNonZero=col[3],nonZeroInterval=0;
            for(j=2;j>=0;j--){
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
            System.out.println("Cannot move down");
            return;
        }
        int currRow,row,column;
        for(row=2;row>=0;row--){
            for(column=0;column<4;column++){
                boolean[] isColVisited={false,false,false,false};
                if(b.board[row][column]==0){
                    continue;
                }
                currRow=row+1;
                while(currRow<4){
                    if(b.board[currRow][column]>0){
                        break;
                    }
                    currRow++;
                }
                if(currRow>3){
                    b.board[3][column]=b.board[row][column];
                    b.removeEmptyCell(3,column);
                    b.board[row][column]=0;
                    b.addEmptyCell(row,column);
                }
                else{
                    if(b.board[currRow][column]==b.board[row][column]){
                        if(isColVisited[currRow]){
                            b.board[currRow-1][column]=b.board[row][column];
                            b.removeEmptyCell(currRow-1,column);
                            if(currRow-1!=row){
                                b.board[row][column]=0;
                                b.addEmptyCell(row,column);
                            }
                        }
                        else{
                            b.board[currRow][column]*=2;
                            b.board[row][column]=0;
                            b.addEmptyCell(row,column);
                        }
                    }
                    else{
                        b.board[currRow-1][column]=b.board[row][column];
                        b.removeEmptyCell(currRow-1,column);
                        if(currRow-1!=row){
                            b.board[row][column]=0;
                            b.addEmptyCell(row,column);
                        }
                    }
                }
            }
        }
        b.addNewNumber();
        b.printBoard();
    }

    public void moveRight(){
        int i,j;
        boolean isPossible=false;
        for(i=0;i<4;i++){
            int[] rw={b.board[i][0],b.board[i][1],b.board[i][2],b.board[i][3]};
            if(rw[0]==0){
                if(rw[1]>0||rw[2]>0||rw[3]>0){
                    isPossible=true;
                    break;
                }
            }
            int currNonZero=rw[0],nonZeroInterval=0;
            for(j=1;j<4;j++){
                if(rw[j]>0){
                    if(currNonZero==rw[j]){
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
            System.out.println("Cannot move right");
            return;
        }
        int currCol,row,column;
        for(column=1;column<4;column++){
            for(row=0;row<4;row++){
                boolean[] isRowVisited={false,false,false,false};
                if(b.board[row][column]==0){
                    continue;
                }
                currCol=column-1;
                while(currCol>-1){
                    if(b.board[row][currCol]>0){
                        break;
                    }
                    currCol--;
                }
                if(currCol<0){
                    b.board[row][0]=b.board[row][column];
                    b.removeEmptyCell(row,0);
                    b.board[row][column]=0;
                    b.addEmptyCell(row,column);
                }
                else{
                    if(b.board[row][currCol]==b.board[row][column]){
                        if(isRowVisited[currCol]){
                            b.board[row][currCol+1]=b.board[row][column];
                            b.removeEmptyCell(row,currCol+1);
                            if(currCol+1!=column){
                                b.board[row][column]=0;
                                b.addEmptyCell(row,column);
                            }
                        }
                        else{
                            b.board[row][currCol]*=2;
                            b.board[row][column]=0;
                            b.addEmptyCell(row,column);
                        }
                    }
                    else{
                        b.board[row][currCol+1]=b.board[row][column];
                        b.removeEmptyCell(row,currCol+1);
                        if(currCol+1!=column){
                            b.board[row][column]=0;
                            b.addEmptyCell(row,column);
                        }
                    }
                }
            }
        }
        b.addNewNumber();
        b.printBoard();
    }

    public void moveLeft(){
        int i,j;
        boolean isPossible=false;
        for(i=0;i<4;i++){
            int[] rw={b.board[i][0],b.board[i][1],b.board[i][2],b.board[i][3]};
            if(rw[3]==0){
                if(rw[1]>0||rw[2]>0||rw[0]>0){
                    isPossible=true;
                    break;
                }
            }
            int currNonZero=rw[3],nonZeroInterval=0;
            for(j=2;j>=0;j--){
                if(rw[j]>0){
                    if(currNonZero==rw[j]){
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
            System.out.println("Cannot move left");
            return;
        }
        int currCol,row,column;
        for(column=2;column>=0;column--){
            for(row=0;row<4;row++){
                boolean[] isRowVisited={false,false,false,false};
                if(b.board[row][column]==0){
                    continue;
                }
                currCol=column+1;
                while(currCol<4){
                    if(b.board[row][currCol]>0){
                        break;
                    }
                    currCol++;
                }
                if(currCol>3){
                    b.board[row][3]=b.board[row][column];
                    b.removeEmptyCell(row,3);
                    b.board[row][column]=0;
                    b.addEmptyCell(row,column);
                }
                else{
                    if(b.board[row][currCol]==b.board[row][column]){
                        if(isRowVisited[currCol]){
                            b.board[row][currCol-1]=b.board[row][column];
                            b.removeEmptyCell(row,currCol-1);
                            if(currCol-1!=column){
                                b.board[row][column]=0;
                                b.addEmptyCell(row,column);
                            }
                        }
                        else{
                            b.board[row][currCol]*=2;
                            b.board[row][column]=0;
                            b.addEmptyCell(row,column);
                        }
                    }
                    else{
                        b.board[row][currCol-1]=b.board[row][column];
                        b.removeEmptyCell(row,currCol-1);
                        if(currCol-1!=column){
                            b.board[row][column]=0;
                            b.addEmptyCell(row,column);
                        }
                    }
                }
            }
        }
        b.addNewNumber();
        b.printBoard();
    }
}


