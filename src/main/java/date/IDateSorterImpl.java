package date;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IDateSorterImpl implements IDateSorter {
    @Override
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> monthWithR = unsortedDates.stream()
                .filter(date -> date.getMonthValue() <= 4 || date.getMonthValue() >= 9)
                .sorted()
                .toList();
        List<LocalDate> monthWithoutR = unsortedDates.stream()
                .filter(date -> date.getMonthValue() > 4 && date.getMonthValue() < 9)
                .sorted(Comparator.reverseOrder())
                .toList();
        return Stream.of(monthWithR, monthWithoutR)
                .flatMap(List::stream)
                .toList();
    }
}
