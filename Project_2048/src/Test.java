//import javax.sound.midi.Soundbank;
//import java.sql.SQLOutput;
//import java.util.ArrayList;
//
//public class Test {
//    public static void main(String[] args) {
//        int cell=11;
//        int row=cell/4;
//        int column=cell-(row*4);
//        System.out.println(row+" "+column);
//    }
//    public void moveDown(){
//        int i,j;
//        boolean isPossible=false;
//        for(i=0;i<4;i++){
//            int[] col={b.board[0][i],b.board[1][i],b.board[2][i],b.board[3][i]};
//            if(col[3]==0){
//                if(col[1]>0||col[2]>0||col[0]>0){
//                    isPossible=true;
//                    break;
//                }
//            }
//            int currNonZero=col[3],nonZeroInterval=0;
//            for(j=2;j>=0;j--){
//                if(col[j]>0){
//                    if(currNonZero==col[j]){
//                        isPossible=true;
//                        break;
//                    }
//                    else{
//                        if(nonZeroInterval>0){
//                            isPossible=true;
//                            break;
//                        }
//                        else{
//                            nonZeroInterval=0;
//                        }
//                    }
//                }
//                else{
//                    nonZeroInterval++;
//                }
//            }
//        }
//        if(!isPossible){
//            System.out.println("Cannot move down");
//            return;
//        }
//        int currRow,row,column;
//        for(row=2;row>=0;row--){
//            for(column=0;column<4;column++){
//                boolean[] isColVisited={false,false,false,false};
//                if(b.board[row][column]==0){
//                    continue;
//                }
//                currRow=row+1;
//                while(currRow<4){
//                    if(b.board[currRow][column]>0){
//                        break;
//                    }
//                    currRow++;
//                }
//                if(currRow>3){
//                    b.board[3][column]=b.board[row][column];
//                    b.removeEmptyCell(3,column);
//                    b.board[row][column]=0;
//                    b.addEmptyCell(row,column);
//                }
//                else{
//                    if(b.board[currRow][column]==b.board[row][column]){
//                        if(isColVisited[currRow]){
//                            b.board[currRow-1][column]=b.board[row][column];
//                            b.removeEmptyCell(currRow-1,column);
//                            if(currRow-1!=row){
//                                b.board[row][column]=0;
//                                b.addEmptyCell(row,column);
//                            }
//                        }
//                        else{
//                            b.board[currRow][column]*=2;
//                            b.board[row][column]=0;
//                            b.addEmptyCell(row,column);
//                        }
//                    }
//                    else{
//                        b.board[currRow-1][column]=b.board[row][column];
//                        b.removeEmptyCell(currRow-1,column);
//                        if(currRow-1!=row){
//                            b.board[row][column]=0;
//                            b.addEmptyCell(row,column);
//                        }
//                    }
//                }
//            }
//        }
//        b.addNewNumber();
//        b.printBoard();
//    }
//
//}
