package telran.time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TimePointUnitTest {
    TimePoint pointSeconds120 = new TimePoint(120, TimeUnit.SECOND);
    TimePoint pointSeconds60 = new TimePoint(60, TimeUnit.SECOND);
    TimePoint pointSeconds7200 = new TimePoint(7200, TimeUnit.SECOND);
    TimePoint pointMinutes2 = new TimePoint(2, TimeUnit.MINUTE);
    TimePoint pointMinutes5 = new TimePoint(5, TimeUnit.MINUTE);
    TimePoint pointMinutes120 = new TimePoint(120, TimeUnit.MINUTE);
    TimePoint pointHours2 = new TimePoint(2, TimeUnit.HOUR);
    TimePoint pointHours3 = new TimePoint(3, TimeUnit.HOUR);

    @Test
    void convertTest() {
        assertEquals(2, pointSeconds120.convert(TimeUnit.MINUTE).getAmount());
        assertEquals(120, pointMinutes2.convert(TimeUnit.SECOND).getAmount());
        assertEquals(7200, pointHours2.convert(TimeUnit.SECOND).getAmount());
        assertEquals(2, pointSeconds7200.convert(TimeUnit.HOUR).getAmount());
    }

    @Test
    void compareToTest() {
        assertTrue(0 == pointSeconds7200.compareTo(pointHours2));
        assertTrue(0 == pointSeconds120.compareTo(pointMinutes2));

        assertTrue(0 > pointSeconds120.compareTo(pointSeconds7200));
        assertTrue(0 > pointSeconds60.compareTo(pointHours2));
        assertTrue(0 > pointSeconds60.compareTo(pointMinutes5));
        assertTrue(0 > pointHours2.compareTo(pointHours3));

        assertTrue(0 < pointSeconds7200.compareTo(pointSeconds120));
        assertTrue(0 < pointHours2.compareTo(pointSeconds60));
        assertTrue(0 < pointHours3.compareTo(pointHours2));
        assertTrue(0 < pointHours3.compareTo(pointSeconds7200));
    }

    @Test
    void equalsTest() {
        assertTrue(pointSeconds7200.equals(pointHours2));
        assertTrue(pointSeconds120.equals(pointMinutes2));

        assertFalse(pointMinutes2.equals(pointSeconds60));
        assertFalse(pointHours3.equals(pointSeconds7200));
    }
    
    @Test
    void getAmountTest() {
        assertEquals(7200, pointSeconds7200.getAmount());
        assertEquals(5, pointMinutes5.getAmount());
        assertEquals(2, pointHours2.getAmount());
    }

    @Test
    void getTimeUnitTest() {
        assertEquals(TimeUnit.SECOND, pointSeconds60.getTimeUnit());
        assertEquals(TimeUnit.MINUTE, pointMinutes120.getTimeUnit());
        assertEquals(TimeUnit.HOUR, pointHours2.getTimeUnit());
    }
    

}