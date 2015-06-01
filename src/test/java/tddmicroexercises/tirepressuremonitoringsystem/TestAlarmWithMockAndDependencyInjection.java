package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestAlarmWithMockAndDependencyInjection {

    @Mock Sensor sensor;
    @InjectMocks Alarm alarm = new Alarm(); // Mock sensor will automatically injected into alarm

    @Test
    public void isAlarmOnForHighPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(22.0);
        alarm.check();
        assertEquals(true, alarm.isAlarmOn());
    }

    @Test
    public void isAlarmOnForLowPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(16.0);
        alarm.check();
        assertEquals(true, alarm.isAlarmOn());
    }

    @Test
    public void isAlarmOnForNormalPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(17.0);
        alarm.check();
        assertEquals(false, alarm.isAlarmOn());
    }
}
