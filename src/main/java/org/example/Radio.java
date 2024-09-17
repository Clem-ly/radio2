package org.example;

public class Radio {
    private int wave;
    private int volume;
    private int numberStation = 10;
    private int minStation = 0;
    private int maxStation = numberStation - 1;
    private int minVolume = 0;
    private int maxVolume = 100;

    public Radio(int numberStation) { // конструктор для задания числа радиостанций
        this.maxStation = numberStation - 1;
    }

    public int getWave() {
        return wave;

    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int newVolume) { // ограничение громкости
        volume = newVolume;
        if (newVolume > maxVolume) {
            return;
        }
        if (newVolume < minVolume) {
            return;
        }
    }

    public void setWave(int newWave) { // ограничение станций
        if (newWave > maxStation) {
            return;
        }
        if (newWave < minStation) {
            return;
        }
        wave = newWave;

    }

    public void nextWave() { // следующая станция
        if (wave < maxStation) {
            wave = wave + 1;
        } else {
            wave = minStation;
        }
    }

    public void previousWave() { // предыдущая станция
        if (wave > minStation) {
            wave = wave - 1;
        } else {
            wave = maxStation;
        }
    }

    public void volumeUp() { // увеличение громкости на 1
        if (volume < maxVolume) {
            volume = volume + 1;
        } else {
            volume = maxVolume;
        }
    }

    public void volumeDown() { // уменьшение громкости на 1
        if (volume > minVolume) {
            volume = volume - 1;
        } else {
            volume = minVolume;
        }
    }
}