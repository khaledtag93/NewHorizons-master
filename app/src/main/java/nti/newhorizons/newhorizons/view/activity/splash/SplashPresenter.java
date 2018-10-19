package nti.newhorizons.newhorizons.view.activity.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

import nti.newhorizons.newhorizons.view.activity.login.LoginActivity;
import nti.newhorizons.newhorizons.view.activity.main.MainActivity;

public class SplashPresenter {

    private Handler handler;
    private int status;
    private SplashActivity view;

    public SplashPresenter(SplashActivity splashActivity) {
        handler = new Handler();
        status = 0;
        view = splashActivity;

    }

    public void delayScreen() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (status < 100) {
                    status += 1;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                        }
                    });
                }


                Intent intent = new Intent(view, LoginActivity.class);
                view.startActivity(intent);
                view.finish();

            }
        }).start();
    }
}
