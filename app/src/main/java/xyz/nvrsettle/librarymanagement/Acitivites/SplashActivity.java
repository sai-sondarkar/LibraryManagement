package xyz.nvrsettle.librarymanagement.Acitivites;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessaging;

import xyz.nvrsettle.librarymanagement.R;

public class SplashActivity extends AppCompatActivity {

    //    protected boolean _active = true;
    protected int _splashTime = 3000; // time to display the splash screen in ms


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.name);
        Typeface tt = Typeface.createFromAsset(getAssets(),"fonts/Rubik-Bold.ttf");
        tv.setTypeface(tt);

        FirebaseMessaging.getInstance().subscribeToTopic("everyone");


        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while ((waited < _splashTime)) {
                        sleep(100);
                        waited += 100;
                    }
                } catch (Exception e) {

                } finally {                    {

                    startActivity(new Intent(SplashActivity.this,
                            HomeActivity.class));}

                    finish();
                }
            };
        };

        splashTread.start();

    }
}
