package com.example.dadu;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class DaduThread extends Thread{

    Handler uiHandler;

    int angka = 1;

    DaduThread(Handler uiHandler){
        this.uiHandler = uiHandler;
    }

    @Override
    public void run() {
        //kode yang dijalankan di sini
        //diproses di backgorund thread
        try {
            while (true) {
                angka = (int) Math.ceil(Math.random() * 6);
                Bundle bundle = new Bundle();
                bundle.putInt("angka", angka);
                Message message = uiHandler.obtainMessage();
                message.setData(bundle);
                uiHandler.sendMessage(message);
                Thread.sleep(100);
            }
        }catch (Exception e){}
    }
}