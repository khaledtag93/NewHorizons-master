package nti.newhorizons.newhorizons.view.fragment.ProfilePersonal;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.view.fragment.ProfileCourse.ProfileCourseFragment;
import nti.newhorizons.newhorizons.view.fragment.profile.ProfilePresenter;

public class ProfilePersonal extends Fragment {

    TextView nameT,phoneT,emailT;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile_personal_info, container, false);

        init(rootView);
        presentData();
        actions();

        return rootView;

    }

    private void init(View view) {

        nameT=view.findViewById(R.id.profile_personal_name);
        phoneT=view.findViewById(R.id.profile_personal_phone);
        emailT=view.findViewById(R.id.profile_personal_email);
    }

    private void actions() {

    }


    private void presentData() {

    }

}
