package org.example;

public interface Mobile {
     /*
     Створити та реалізувати інтерфейси, також використовувати успадкування та
     поліморфізм для наступних предметних областей: interface Mobile - abstract class MobilePhone - class Model.
     */
     void callStart(String callingNumber);
     void callStop(String callingNumber); // якщо декілька викликів одночасно
     void chargeStart();
     void chargeStop();
     int volumeUp();
     int volumeDown();
     void powerOn();
     void powerOff();
}
