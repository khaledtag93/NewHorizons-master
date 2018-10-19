package nti.newhorizons.newhorizons.view.activity.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.view.activity.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

    SplashPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        presenter = new SplashPresenter(this);
        presenter.delayScreen();


    }

}

