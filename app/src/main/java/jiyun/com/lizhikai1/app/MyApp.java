package jiyun.com.lizhikai1.app;

import android.app.Application;

public class MyApp extends Application {
    private static MyApp myApp;
        @Override
        public void onCreate() {
            super.onCreate();
            myApp=this;
        }

        public static MyApp getMyApp() {
            if (myApp==null){
                synchronized (MyApp.class){
                    if (myApp==null){
                        myApp=new MyApp();
                    }
                }
            }
            return myApp;
        }
}
