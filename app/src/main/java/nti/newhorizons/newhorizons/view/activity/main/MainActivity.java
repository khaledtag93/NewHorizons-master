package nti.newhorizons.newhorizons.view.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.view.activity.login.LoginActivity;
import nti.newhorizons.newhorizons.view.fragment.about.AboutFragment;
import nti.newhorizons.newhorizons.view.fragment.courses.CoursesFragment;
import nti.newhorizons.newhorizons.view.fragment.home.HomeFragment;
import nti.newhorizons.newhorizons.view.fragment.profile.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    MainPresenter presenter;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        init();
        presentData();
        actions();
    }

    private void actions() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        replaceFragment(new HomeFragment());
                        return true;
                    case R.id.navigation_courses:
                        replaceFragment(new CoursesFragment());
                        return true;
                    case R.id.navigation_profile:
                        replaceFragment(new ProfileFragment());
                        return true;
                    case R.id.navigation_signIn:
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        return true;
                    case R.id.navigation_about:
                        replaceFragment(new AboutFragment());
                        return true;
                }
                return false;
            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void presentData() {
        presenter.removeOneOfNavigationBottom();
    }

    private void init() {
        bottomNavigationView = findViewById(R.id.navigation);
        replaceFragment(new HomeFragment());
        presenter = new MainPresenter(this);

    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_main_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
//        replaceFragment(new HomeFragment());
    }


}
