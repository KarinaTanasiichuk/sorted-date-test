package date;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<LocalDate> dateList = List.of(LocalDate.of(2005, 7, 1),
                LocalDate.of(2005, 1,2), LocalDate.of(2005, 1, 1),
                LocalDate.of(2005, 5, 3));
        IDateSorterImpl date = new IDateSorterImpl();
        System.out.println("Result list of dates:");
        System.out.println(System.lineSeparator());
        System.out.println(date.sortDates(dateList));
    }
}
