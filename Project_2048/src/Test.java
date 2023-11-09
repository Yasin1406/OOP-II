import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer[]> test=new ArrayList<Integer[]>();
        Integer[] cell=new Integer[2];
        cell[0]=1;
        cell[1]=22;
        test.add(cell);
        cell=new Integer[2];
        cell[0]=3;
        cell[1]=2;
        test.add(cell);
        cell=new Integer[2];
        cell[0]=21;
        cell[1]=52;
        test.add(cell);
        cell=new Integer[2];
        cell[0]=16;
        cell[1]=20;
        test.add(cell);
        cell=new Integer[2];
        cell[0]=91;
        cell[1]=42;
        test.add(cell);
        for(Integer[] t:test){
            for(int c:t){
                System.out.print(c+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        cell=new Integer[2];
        cell[0]=16;
        cell[1]=20;
        test.remove(cell);
        for(Integer[] t:test){
            for(int c:t){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }

}
