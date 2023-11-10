import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Scores {
    private int score;
    private String name;
    private String dateTime;

    public Scores(int score,String name){
        this.score=score;
        this.name=name;
        LocalDate currentDate=LocalDate.now();
        LocalTime currentTime=LocalTime.now();
        dateTime=currentDate.toString()+" "+currentTime.toString();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score=score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime=dateTime;
    }

    public Scores(int score, String name, String dateTime){
        this.score=score;
        this.name=name;
        this.dateTime=dateTime;
    }

    public static void getHighScores(ArrayList<Scores> highScores) throws FileNotFoundException {
        try(Scanner scanner=new Scanner(new File("highscores.txt"))){
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                String[] fields=line.split(" ");
                int score=Integer.parseInt(fields[0]);
                String name=fields[1];
                String dateTime=fields[2]+" "+fields[3];
                Scores entry=new Scores(score,name,dateTime);
                highScores.add(entry);
            }
        }catch(FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
        }
    }

    public static void putHighScores(ArrayList<Scores> highScores,Scores sc) throws IOException {
        boolean isChanged = false;
        if (highScores.isEmpty()) {
            highScores.add(sc);
            isChanged = true;
        } else {
            int idx = 0;
            for (Scores hs : highScores) {
                if (hs.score <= sc.score) {
                    break;
                }
                idx++;
            }
            if (idx < 5) {
                highScores.add(idx, sc);
                if(highScores.size()>5){
                    highScores.remove(5);
                }
                isChanged = true;
            }
        }
        if (isChanged) {
            try (PrintWriter writer = new PrintWriter(new FileWriter("highscores.txt"))) {
                for (Scores s : highScores) {
                    writer.println(s);
                }
            }catch (IOException ioException){
                ioException.printStackTrace();
            }
        }
    }

    public static void printHighScores() throws FileNotFoundException {
        try(Scanner scanner=new Scanner(new File("highscores.txt"))){
            String line;
            while(scanner.hasNextLine()){
                line=scanner.nextLine();
                System.out.println(line);
            }
        }catch(FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return score+" "+name+" "+dateTime;
    }
}
