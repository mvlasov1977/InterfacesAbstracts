package org.example;

public abstract class MobilePhone {
    /*
     Створити та реалізувати інтерфейси, також використовувати успадкування та
     поліморфізм для наступних предметних областей: interface Mobile - abstract class MobilePhone - class Model.
     */
    boolean isPowerOn;
    boolean isCharging;
    boolean isNetworkAvailable;
     int volumeLevel;
     int batteryLevel;
     int networkLevel;

    public int getVolumeLevel() {
        return volumeLevel;
    }

    abstract public void setVolumeLevel(int volumeLevel);

    public int getBatteryLevel() {
        return batteryLevel;
    }

    abstract public void setBatteryLevel(int batteryLevel);

    public int getNetworkLevel() {
        return networkLevel;
    }

    abstract public void setNetworkLevel(int networkLevel);
}
