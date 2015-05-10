package ohiovr.com.boundserviceexample;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import android.os.Binder;

public class MyService extends Service {

    private String TAG = "TestService";

    private IBinder myBinder = new MyBinder();

    public MyService() {
        Log.d(TAG, "constructor called");
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate called");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind done");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return false;
    }

    public class MyBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }


    // Methods used by the binding client components

    public void methodOne() {
        Log.d(TAG, "method one was called");
    }

    public void methodTwo() {
        Log.d(TAG, "method two was called");
    }

}