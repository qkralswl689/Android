package org.techtown.diary;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Myapplication extends Application {
    private static final String TAG = "MyApplication";
    public static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext(), new HurlStack(){
                @Override
                protected HttpURLConnection createConnection(URL url) throws IOException {
                    HttpURLConnection connection = super.createConnection(url);
                    connection.setInstanceFollowRedirects(false);

                    return connection;
                }
            });
        }
    }
    public static interface OnResponseListener{
        public void processResponse(int requestCode, int responseCode, String response);
    }
    public static void send(final int requestCode, final int requestMethod, final String url,
                            final Map<String,String > parmas,
                            final OnResponseListener listener){
        StringRequest request = new StringRequest{
            requestMethod,
            url,
            new Response.Listener<String>() {
             @Override
             public void onResponse(String response) {
                 Log.d(TAG,"Response for " + requestCode + " -> " + response);
                 
                 if (listener != null) {
                     listener.processResponse(requestCode,200,response);
                 }
             }
            },
            
        
    }
}
