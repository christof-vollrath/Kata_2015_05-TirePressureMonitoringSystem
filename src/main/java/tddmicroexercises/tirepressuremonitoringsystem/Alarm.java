package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private final double LowPressureTreshold = 17;
    private final double HighPressureTreshold = 21;

    Sensor sensor = new Sensor();

    boolean alarmOn = false;

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        alarmOn = ! (LowPressureTreshold <= psiPressureValue && psiPressureValue <= HighPressureTreshold);
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
