package com.example.arduinosensors;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;

/**
 * Created by Mitar on 28.02.2017.
 */

public class BluetoothLostReceiver extends BroadcastReceiver {

    MainActivity main = null;

    public void setMainActivity(MainActivity main)
    {
        this.main = main;
    }

    @Override
    public void onReceive(Context context, Intent intent) {


      //  if intent.getAction().equals()android.bluetooth.device.action.ACL_DISCONNECTED

        Log.d("BLU", intent.getAction());



        if(BluetoothDevice.ACTION_ACL_DISCONNECTED.equals(intent.getAction()))
        {
           // Log.d("TAG", "O!!!");
            main.connectedBT=false;
        }
      //      if(Global.PosPrinterDeviceName != null && !Global.PosPrinterDeviceName.equals(""))
      //          main.connectPrinter(Global.PosPrinterDeviceName);
      //  }else
       // {
       //     Global.tryBluetoothReconnect = true;
       // }
    }
}