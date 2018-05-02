package com.example.tinku.gpsleep;

import android.app.IntentService;
import android.content.Intent;

public class RecognizedService extends IntentService {
    public RecognizedService(){
        super("RecognizedService");
    }
    public RecognizedService(String name){
        super(name);
    }

    protected void onHandleIntent(Intent intent){

    }
}
