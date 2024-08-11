package telran.time;

public class TimePoint implements Comparable<TimePoint>{
    private float amount;
    private TimeUnit timeUnit;

    public TimePoint(float amount, TimeUnit timeUnit) {
        this.amount = amount;
        this.timeUnit = timeUnit;
    }
    @Override
    public int compareTo(TimePoint arg0) {
        return (int) TimeUnit.SECOND.between(arg0, this);
    }
    public float getAmount(){
        return amount;
    }
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
    @Override
    public boolean equals(Object obj) {
        return ((TimePoint) obj).compareTo(this) == 0;
    }
    public TimePoint convert(TimeUnit timeUnit) {
        float timePointSeconds = amount * this.timeUnit.getValueOfSeconds();
        float newAmount = timePointSeconds / timeUnit.getValueOfSeconds();
        return new TimePoint(newAmount, timeUnit);
    }
    public TimePoint with(TimePointAdjuster adjuster) {
        return adjuster.adjust(this);
    }

}