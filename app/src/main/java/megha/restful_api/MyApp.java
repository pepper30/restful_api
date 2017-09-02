package megha.restful_api;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by Megha Chauhan on 01-Sep-17.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
