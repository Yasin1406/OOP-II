import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Test {

    public static void main(String[] args) {
        LocalDate currentDate;
        currentDate=LocalDate.now();
        String dateTime=currentDate.toString();
        LocalTime currentTime=LocalTime.now();
        dateTime=dateTime+" "+currentTime;
        System.out.println(dateTime);
    }

}