package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();

    @Test
    public void waveSelection() { // выбор станции
        radio.wave = 8;
        int expected = 8;
        int actual = radio.getWave();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void moreMaximumWave() { // переключение после 9 станции
        radio.setWave(10);
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
    public void nextWave() { // следующая станция
        radio.setWave(7);
        radio.nextWave();

        int expected = 8;
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
    public void lessThanMinimumVolume() { // минимальная громкость
        radio.setVolume(0);
        radio.volumeDown();

        int expected = 0;
        int actual = radio.getVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextStationAfterMax() { // следующая станция после 9
        radio.setWave(9);
        radio.nextWave();

        int expected = 0;
        int actual = radio.getWave();
        Assertions.assertEquals(expected, actual);
    }
@Test
    public void prevStationAfterMin() { // предыдущая старнция после 1
        radio.setWave(0);
        radio.previousWave();

        int expected = 9;
        int actual = radio.getWave();
        Assertions.assertEquals(expected, actual);
    }
}