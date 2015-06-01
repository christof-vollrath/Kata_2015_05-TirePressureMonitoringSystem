package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestAlarmWithMock {

    @Test
    public void isAlarmOnForHighPressure() {
        Alarm alarm = new Alarm();
        Sensor sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(22.0);
        alarm.sensor = sensor;
        alarm.check();
        assertEquals(true, alarm.isAlarmOn());
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
