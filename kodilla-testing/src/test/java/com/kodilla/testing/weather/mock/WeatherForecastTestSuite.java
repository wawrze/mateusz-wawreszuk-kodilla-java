package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;

import static org.mockito.Mockito.*;

public class WeatherForecastTestSuite {

    @Test
    public void testCalculateForecastWithMock() {
        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        HashMap<Integer,Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put(1,20.5);
        temperaturesMap.put(2,21.4);
        temperaturesMap.put(3,22.3);
        temperaturesMap.put(4,23.2);
        temperaturesMap.put(5,24.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //Then
        Assert.assertEquals(5, quantityOfSensors);
    }

}