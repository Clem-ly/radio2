package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio(25);

    @Test
    public void switchinToZeroStation() { // переключение на нулевую станцию
        radio.setWave(8);
        radio.setWave(0);
        int expected = 0;
        int actual = radio.getWave();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNextStation() { // переключение на следующую станцию
        radio.setWave(17);
        radio.nextWave();
        int expected = 18;
        int actual = radio.getWave();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void waveSelection() { // выбор станции
        radio.setWave(8);
        int expected = 8;
        int actual = radio.getWave();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void moreMaximumWave() { // переключение после последней станции
        radio.setWave(24);
        radio.nextWave();
        int expected = 0;
        int actual = radio.getWave();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void lessThanMinimumWave() { // выбор станции меньше минимального
        radio.setWave(-1);

        int expected = 0;
        int actual = radio.getWave();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void previousWave() { // предыдущая станция
        radio.setWave(7);
        radio.previousWave();

        int expected = 6;
        int actual = radio.getWave();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchingAfterZero() { // предыдущая станция
        radio.setWave(0);
        radio.previousWave();

        int expected = 24;
        int actual = radio.getWave();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void stationLimitValues() { // переключение после последней станции
        radio.setWave(26);
        radio.nextWave();
        int expected = 1;
        int actual = radio.getWave();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void stationLimitValues2() { // переключение после последней станции
        radio.setWave(-1);
        radio.previousWave();
        int expected = 24;
        int actual = radio.getWave();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextVolume() { // увеличение громоксти на 1
        radio.setVolume(59);
        radio.volumeUp();

        int expected = 60;
        int actual = radio.getVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void previousVolume() { // уменьшение громкости на 1
        radio.setVolume(59);
        radio.volumeDown();

        int expected = 58;
        int actual = radio.getVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void moreMaximumVolume() { // максимальная громкость
        radio.setVolume(100);
        radio.volumeUp();

        int expected = 100;
        int actual = radio.getVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void volumeLimitValues() { // максимальная громкость
        radio.setVolume(101);
        radio.volumeUp();

        int expected = 100;
        int actual = radio.getVolume();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void volumeLimitValues2() { // максимальная громкость
        radio.setVolume(-1);
        radio.volumeUp();

        int expected = 0;
        int actual = radio.getVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void lessThanMinimumVolume() { // минимальная громкость
        radio.setVolume(0);
        radio.volumeDown();

        int expected = 0;
        int actual = radio.getVolume();
        Assertions.assertEquals(expected, actual);
    }
}