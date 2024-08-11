package telran.time;

import java.util.Arrays;

public class FutureProximityAdjuster implements TimePointAdjuster{
    TimePoint [] timePoints;
    public FutureProximityAdjuster(TimePoint [] timePoints) {
       timePoints = Arrays.copyOf(timePoints,timePoints.length);
       Arrays.sort(timePoints);
       this.timePoints = timePoints;
    }

    @Override
    public TimePoint adjust(TimePoint timePoint) {
       int start = 0;
       int end = timePoints.length-1;
       int res = -1;

       while(start <= end){
        int middle = (start+end) / 2;
        int compareM = timePoints[middle].compareTo(timePoint);
        if(compareM > 0){
            end = middle - 1;
            res = middle;
        }

        else {
            start = middle + 1;
        }
       }

       return res != -1 ? timePoints[res] : null;
    }
}
