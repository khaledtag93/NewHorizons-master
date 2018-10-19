package nti.newhorizons.newhorizons.view.activity.courseDetails;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nti.newhorizons.newhorizons.R;

public class courseDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


    }
}
