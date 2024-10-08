package telran.time;

public enum TimeUnit {
SECOND(1), MINUTE(60), HOUR(3600);
private int valueOfSeconds;
TimeUnit(int valuOfSeconds) {
    this.valueOfSeconds = valuOfSeconds;
}
public int getValueOfSeconds(){
    return valueOfSeconds;
}
public float between(TimePoint p1, TimePoint p2) {
    float p1unitTime = p1.getAmount() * p1.getTimeUnit().getValueOfSeconds();
    float p2unitTime = p2.getAmount() * p2.getTimeUnit().getValueOfSeconds();
    return (p2unitTime-p1unitTime)/valueOfSeconds;
}
}