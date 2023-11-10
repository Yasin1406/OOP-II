public class Moves {
    GameBoard b;
    boolean[] move=new boolean[4];
    public Moves(GameBoard b){
        this.b=b;
        for(int i=0;i<4;i++){
            this.move[i]=true;
        }
    }
    public void moveUp(){
        int currRow,row,column;
        for(row=1;row<4;row++){
            boolean[] isColVisited={false,false,false,false};
            for(column=0;column<4;column++){
//                boolean[] isColVisited={false,false,false,false};
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
                            b.score+=b.board[currRow][column];
                            b.board[row][column]=0;
                            b.addEmptyCell(row,column);
                            isColVisited[currRow]=true;
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
        if(b.score>RunGame.highestScore){
            RunGame.highestScore=b.score;
        }
        b.printBoard();
    }

    public void moveDown(){
        int currRow,row,column;
        for(row=2;row>=0;row--){
            boolean[] isColVisited={false,false,false,false};
            for(column=0;column<4;column++){
//                boolean[] isColVisited={false,false,false,false};
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
                            b.score+=b.board[currRow][column];
                            b.board[row][column]=0;
                            b.addEmptyCell(row,column);
                            isColVisited[currRow]=true;
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
        if(b.score>RunGame.highestScore){
            RunGame.highestScore=b.score;
        }
        b.printBoard();
    }

    public void moveLeft(){
        int currCol,row,column;
        for(column=1;column<4;column++){
            boolean[] isRowVisited={false,false,false,false};
            for(row=0;row<4;row++){
//                boolean[] isRowVisited={false,false,false,false};
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
                            b.score+=b.board[row][currCol];
                            b.board[row][column]=0;
                            b.addEmptyCell(row,column);
                            isRowVisited[currCol]=true;
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
        if(b.score>RunGame.highestScore){
            RunGame.highestScore=b.score;
        }
        b.printBoard();
    }

    public void moveRight(){
        int currCol,row,column;
        for(column=2;column>=0;column--){
            boolean[] isRowVisited={false,false,false,false};
            for(row=0;row<4;row++){
//                boolean[] isRowVisited={false,false,false,false};
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
                            b.score+=b.board[row][currCol];
                            b.board[row][column]=0;
                            b.addEmptyCell(row,column);
                            isRowVisited[currCol]=true;
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
        if(b.score>RunGame.highestScore){
            RunGame.highestScore=b.score;
        }
        b.printBoard();
    }

    void possibleMoves(){
        int i,j;
        for(i=0;i<4;i++){
            move[i]=false;
        }

        for(i=0;i<4;i++){                       // Up
            int[] col={b.board[0][i],b.board[1][i],b.board[2][i],b.board[3][i]};
            for(j=3;j>0;j--){
                if(col[j]!=0){
                    if(col[j-1]==0||col[j-1]==col[j]){
                        move[0]=true;
                        break;
                    }
                }
            }
            if(move[0]){
                break;
            }
        }

        for(i=0;i<4;i++){                       // Down
            int[] col={b.board[0][i],b.board[1][i],b.board[2][i],b.board[3][i]};
            for(j=0;j<3;j++){
                if(col[j]!=0){
                    if(col[j+1]==0||col[j+1]==col[j]){
                        move[1]=true;
                        break;
                    }
                }
            }
            if(move[1]){
                break;
            }
        }

        for(i=0;i<4;i++){                       // Left
            int[] rw={b.board[i][0],b.board[i][1],b.board[i][2],b.board[i][3]};
            for(j=3;j>0;j--){
                if(rw[j]!=0){
                    if(rw[j-1]==0||rw[j-1]==rw[j]){
                        move[2]=true;
                        break;
                    }
                }
            }
            if(move[2]){
                break;
            }
        }

        for(i=0;i<4;i++){                       // Right
            int[] rw={b.board[i][0],b.board[i][1],b.board[i][2],b.board[i][3]};
            for(j=0;j<3;j++){
                if(rw[j]!=0){
                    if(rw[j+1]==0||rw[j+1]==rw[j]){
                        move[3]=true;
                        break;
                    }
                }
            }
            if(move[3]){
                break;
            }
        }
    }

}