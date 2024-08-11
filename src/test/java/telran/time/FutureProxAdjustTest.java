package telran.time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class FutureProxAdjustTest {
    TimePoint pointSeconds120 = new TimePoint(120, TimeUnit.SECOND);
    TimePoint pointMinutes2 = new TimePoint(2, TimeUnit.MINUTE);
    TimePoint pointHours2 = new TimePoint(2, TimeUnit.HOUR);
    TimePoint pointHours3 = new TimePoint(3, TimeUnit.HOUR);
    TimePoint pointSeconds7200 = new TimePoint(7200, TimeUnit.SECOND);
    TimePoint pointMinus2Hours = new TimePoint(-2, TimeUnit.HOUR);
    TimePoint pointMinus2Minutes = new TimePoint(-2, TimeUnit.MINUTE);
    TimePoint pointMinus3Hours = new TimePoint(-3, TimeUnit.HOUR);

    TimePoint pointSeconds2 = new TimePoint(2, TimeUnit.SECOND);
    TimePoint pointSeconds20 = new TimePoint(20, TimeUnit.SECOND);
    TimePoint pointSeconds0 = new TimePoint(0, TimeUnit.SECOND);




 @Test
    void withAdjusterTest() {
        // time plus
        PlusTimePointAdjuster plus2Hours = new PlusTimePointAdjuster(2, TimeUnit.HOUR);
        PlusTimePointAdjuster plus360Minutes = new PlusTimePointAdjuster(360, TimeUnit.MINUTE);
        PlusTimePointAdjuster plus7200Seconds = new PlusTimePointAdjuster(7200, TimeUnit.SECOND);
        PlusTimePointAdjuster minus120Minutes = new PlusTimePointAdjuster(-120, TimeUnit.MINUTE);

        assertEquals(4, pointHours2.with(plus2Hours).getAmount());
        assertEquals(9, pointHours3.with(plus360Minutes).getAmount());
        assertEquals(0, pointMinus2Hours.with(plus7200Seconds).getAmount());
        assertEquals(0, pointHours2.with(minus120Minutes).getAmount());

       
        TimePoint[] timePoints = { pointSeconds120, pointHours2, pointMinus2Hours, pointSeconds7200,
                pointMinutes2, pointSeconds20, pointSeconds0 
            };

        FutureProximityAdjuster futureProx = new FutureProximityAdjuster(timePoints);


        assertEquals(pointMinus2Hours, pointMinus3Hours.with(futureProx));
        assertEquals(pointSeconds20, pointSeconds2.with(futureProx));
        assertEquals(pointSeconds0, pointMinus2Minutes.with(futureProx));
        assertEquals(pointSeconds0, pointMinus2Minutes.with(futureProx));
        assertEquals(null, pointHours2.with(futureProx));
    
    }
}
