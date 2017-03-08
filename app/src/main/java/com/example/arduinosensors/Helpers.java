package com.example.arduinosensors;

/**
 * Created by Mitar on 08.03.2017.
 */

public class Helpers {

    double LastSpeed = 0;
    double LastVolt = 0;

    static double ADC2Temp(int RawADC) {
        double Temp;
        Temp = Math.log(10000.0 * ((1024.0 / RawADC - 1)));
        Temp = 1 / (0.001129148 + (0.000234125 + (0.0000000876741 * Temp * Temp)) * Temp);
        Temp = Temp - 273.15;
        //Temp = (Temp * 9.0)/ 5.0 + 32.0;
        return Temp;
    }

    double ADC2Speed(int RawADC) {

        double tmp = ((((2 * Math.PI * 32) * RawADC) / 2) / 27.7777777778);
        tmp = (tmp - LastSpeed) * 0.2;
        LastSpeed = LastSpeed + tmp;
        return LastSpeed;
    }

    double ADC2Volt(int RawADC) {


        double tmp = RawADC*(5.0 / 1023.0)*24.9;
        if (LastVolt==0) LastVolt=tmp;

        tmp = (tmp - LastVolt) * 0.02;
        LastVolt = LastVolt + tmp;
        return LastVolt;
    }

    double Volt2Precent(double V) {

        double tmp = 100 - (66.2 - V) * 9.5;
        if (tmp < 0) tmp = 0;
        return tmp;
    }

}
