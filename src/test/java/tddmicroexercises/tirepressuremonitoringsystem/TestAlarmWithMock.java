package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestAlarmWithMock {

    @Mock
    Alarm alarm2;

    @Test
    public void isAlarmOnForHighPressure() {
        Alarm alarm = new Alarm();
        Sensor sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(22.0);
        System.out.println(sensor.getClass().getName());
        alarm.sensor = sensor;
        alarm.check();
        assertEquals(true, alarm.isAlarmOn());
    }

    @Test
    public void isAlarmOnForHighPressure2() {
        when(alarm2.sensor.popNextPressurePsiValue()).thenReturn(22.0);
        alarm2.check();
        assertEquals(true, alarm2.isAlarmOn());
    }

    @Test
    public void isAlarmOnForLowPressure() {
        Alarm alarm = new Alarm();
        Sensor sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(16.0);
        alarm.sensor = sensor;
        alarm.check();
        assertEquals(true, alarm.isAlarmOn());
    }

    @Test
    public void isAlarmOnForNormalPressure() {
        Alarm alarm = new Alarm();
        Sensor sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(17.0);
        alarm.sensor = sensor;
        alarm.check();
        assertEquals(false, alarm.isAlarmOn());
    }
}
