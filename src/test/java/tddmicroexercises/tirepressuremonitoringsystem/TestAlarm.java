package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.*;
import static org.junit.Assert.*;

public class TestAlarm {

    @Test
    public void foo() {
        Alarm alarm = new Alarm();
        assertEquals(false, alarm.isAlarmOn());
    }

    @Test @Ignore
    public void isAlarmOnAfterCeck() {
        Alarm alarm = new Alarm();
        alarm.check();
        assertEquals(false, alarm.isAlarmOn());
    }

    @Test
    public void isAlarmOnForHighPressure() {
        Alarm alarm = new Alarm();
        TestSensor testSensor = new TestSensor();
        testSensor.pressurePsiValue = 22;
        alarm.sensor = testSensor;
        alarm.check();
        assertEquals(true, alarm.isAlarmOn());
    }

    @Test
    public void isAlarmOnForLowPressure() {
        Alarm alarm = new Alarm();
        TestSensor testSensor = new TestSensor();
        testSensor.pressurePsiValue = 16;
        alarm.sensor = testSensor;
        alarm.check();
        assertEquals(true, alarm.isAlarmOn());
    }

    @Test
    public void isAlarmOnForNormalPressure() {
        Alarm alarm = new Alarm();
        TestSensor testSensor = new TestSensor();
        testSensor.pressurePsiValue = 17;
        alarm.sensor = testSensor;
        alarm.check();
        assertEquals(false, alarm.isAlarmOn());
    }
}
