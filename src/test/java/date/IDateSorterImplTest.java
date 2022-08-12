package date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class IDateSorterImplTest {
    private static IDateSorterImpl date;

    @Before
    public void before() {
         date = new IDateSorterImpl();
    }

    @Test
    public void sortDates_goodDate_ok() {
        List<LocalDate> dateList = List.of(LocalDate.of(2005, 7, 1),
                LocalDate.of(2005, 1,2), LocalDate.of(2005, 1, 1),
                LocalDate.of(2005, 5, 3));
        Collection<LocalDate> expected = List.of(LocalDate.of(2005,1,1),
                LocalDate.of(2005, 1, 2), LocalDate.of(2005, 7, 1),
                LocalDate.of(2005, 5, 3));
        Collection<LocalDate> actual = date.sortDates(dateList);
        assertEquals(expected, actual);
    }

    @Test
    public void sortDates_date_ok() {
        List<LocalDate> dateList = List.of(LocalDate.of(2007, 2, 1),
                LocalDate.of(1996, 10,18), LocalDate.of(1998, 7, 25),
                LocalDate.now());
        Collection<LocalDate> expected = List.of(LocalDate.of(1996, 10,18),
                LocalDate.of(2007, 2, 1), LocalDate.now(),
                LocalDate.of(1998, 7, 25));
        Collection<LocalDate> actual = date.sortDates(dateList);
        assertEquals(expected, actual);
    }

    @Test
    public void sortDates_emptyList_ok() {
        List<LocalDate> dateList = Collections.emptyList();
        Collection<LocalDate> expected = Collections.emptyList();
        Collection<LocalDate> actual = date.sortDates(dateList);
        assertEquals(expected, actual);
    }

    @Test
    public void sortDates_null_notOk() {
        assertThrows(NullPointerException.class, () -> date.sortDates(null));
    }
}