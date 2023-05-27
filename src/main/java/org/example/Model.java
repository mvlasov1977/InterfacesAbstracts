package org.example;

import java.awt.*;
import java.util.concurrent.Callable;
import java.awt.color.*;
public class Model extends MobilePhone implements Mobile {
    /*
     Створити та реалізувати інтерфейси, також використовувати успадкування та
     поліморфізм для наступних предметних областей: interface Mobile - abstract class MobilePhone - class Model.
     */
    private String myModel;
    private Color myColor;
    private int myWeight;
    private int myBatteryCapacity;
    private int maxNetworkLevel;
    private int countSimCard;
    private int maxVolumeLevel;
    private int minVolumeLevel;
    public void Model(String myModel,Color myColor, int myWeight, int myBatteryCapacity,
                      int maxNetworkLevel ,int maxVolumeLevel, int minVolumeLevel, int countSimCard){
        this.myModel = myModel;
        this.myColor = myColor;
        this.myWeight = myWeight;
        this.myBatteryCapacity = myBatteryCapacity;
        this.maxNetworkLevel = maxNetworkLevel;
        this.countSimCard = countSimCard;
    }

    public String getMyModel() {
        return myModel;
    }

    public Color getMyColor() {
        return myColor;
    }

    public int getMyWeight() {
        return myWeight;
    }

    public int getMyBatteryCapacity() {
        return myBatteryCapacity;
    }

    public int getMaxNetworkLevel() {
        return maxNetworkLevel;
    }

    public int getCountSimCard() {
        return countSimCard;
    }

    public int getMaxVolumeLevel() {
        return maxVolumeLevel;
    }

    public int getMinVolumeLevel() {
        return minVolumeLevel;
    }

    @Override
    public void setVolumeLevel(int volumeLevel) {
        if ((volumeLevel >= minVolumeLevel) && (volumeLevel<= maxVolumeLevel)){
            this.volumeLevel = volumeLevel;
        }
    }

    @Override
    public void setBatteryLevel(int batteryLevel) {
        if ((batteryLevel >= 0) && (batteryLevel <= myBatteryCapacity)){
             this.batteryLevel = batteryLevel;
        }
    }


    @Override
    public void setNetworkLevel(int networkLevel) {
        if ((networkLevel >= 0) && (networkLevel <= maxNetworkLevel)){
            this.networkLevel = networkLevel;
        }
    }

    @Override
    public void callStart(String callingNumber) {
        System.out.println("Calling to: "+ callingNumber);
    }

    @Override
    public void callStop(String callingNumber) {
        System.out.println("Stop calling to: "+ callingNumber);
    }

    @Override
    public void chargeStart() {
        int currentBatteryLevel = getBatteryLevel();
        currentBatteryLevel++;
        setBatteryLevel(currentBatteryLevel);
        isCharging = true;
    }

    @Override
    public void chargeStop() {
        isCharging = false;
    }

    @Override
    public int volumeUp() {
        int currentVolumeLevel = getVolumeLevel();
        currentVolumeLevel++;
        setVolumeLevel(currentVolumeLevel);
        return getVolumeLevel();
    }

    @Override
    public int volumeDown() {
        int currentVolumeLevel = getVolumeLevel();
        currentVolumeLevel--;
        setVolumeLevel(currentVolumeLevel);
        return getVolumeLevel();
    }

    @Override
    public void powerOn() {
        int currentBatteryLevel = getBatteryLevel();
        if (currentBatteryLevel > 0){
            isPowerOn = true;
            isNetworkAvailable = true;
            System.out.println("Power on");
        }
    }

    @Override
    public void powerOff() {
        isPowerOn = false;
        isNetworkAvailable = false;
        System.out.println("Power down");
    }
}
