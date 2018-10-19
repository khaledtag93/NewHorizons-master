package nti.newhorizons.newhorizons.view.fragment.profile;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.view.activity.login.LoginActivity;
import nti.newhorizons.newhorizons.view.fragment.ProfileCourse.ProfileCourseFragment;
import nti.newhorizons.newhorizons.view.fragment.ProfilePersonal.ProfileFragmentPresenter;
import nti.newhorizons.newhorizons.view.fragment.ProfilePersonal.ProfilePersonal;


public class ProfileFragment extends Fragment {
    ProfilePresenter profilePresenter;

    TextView nameT, personalT, currentT, finishT, interstedT;
    ImageView addIMG, profileIMG;
    Button logOut;
    private ProfileFragmentPresenter profileFragmentPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        init(rootView);
        presentData(rootView);
        actions();
        /////
      // loadimage();
        return rootView;
    }

    private void init(View view) {

        nameT = view.findViewById(R.id.tv_profile_name);

        currentT = view.findViewById(R.id.tv_profile_current);
        personalT = view.findViewById(R.id.tv_profile_personalInfo);
        finishT = view.findViewById(R.id.tv_profile_fiinished);
        interstedT = view.findViewById(R.id.tv_profile_interested);

        logOut = view.findViewById(R.id.profile_personal_log_out);

        profileIMG = view.findViewById(R.id.profile_image);
        addIMG = view.findViewById(R.id.profile_addIMG);

        profilePresenter = new ProfilePresenter();

        //open fragment in first time
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_course_list_container, new ProfilePersonal());
        fragmentTransaction.commit();
    }

    private void actions() {
        currentT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment();
            }
        });
        interstedT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment();
            }
        });
        personalT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout_course_list_container, new ProfilePersonal());
                fragmentTransaction.commit();

            }
        });

        addIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                    startGallery();
                } else {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 2000);
                }
            }
        });

//        logOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getActivity().getBaseContext(), LoginActivity.class));
//            }
//        });


    }


    private void presentData(View view) {
//        profilePresenter.setProfilePhoto(view);
//        profilePresenter.getImage();

    }

    private void loadimage() {
        String path;
        profileFragmentPresenter = new ProfileFragmentPresenter();
        path=profileFragmentPresenter.GetFromShare(this.getContext());
        if (path.equals(null)||path.equals("")) {
            Toast.makeText(this.getContext(), "empty path", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this.getContext(), path, Toast.LENGTH_SHORT).show();


            Uri returnUri = Uri.parse((path));
            Bitmap bitmapImage = null;

            try {
                bitmapImage = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), returnUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            profileIMG.setImageBitmap(bitmapImage);
            profileFragmentPresenter = new ProfileFragmentPresenter();
        }
    }


    public void startGallery() {
        Intent cameraIntent = new Intent(Intent.ACTION_GET_CONTENT);
        cameraIntent.setType("image/*");
        if (cameraIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(cameraIntent, 1000);
        }
    }

    private void fragment() {

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_course_list_container, new ProfileCourseFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (resultCode == Activity.RESULT_OK) {
                if (requestCode == 1000) {
                    Uri returnUri = data.getData();
                    Bitmap bitmapImage = null;

                    bitmapImage = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), returnUri);
                    profileIMG.setImageBitmap(bitmapImage);
                    profileFragmentPresenter = new ProfileFragmentPresenter();
                    //////savs image uri to sharedprefrance
                    profileFragmentPresenter.SaveToShare(returnUri.toString(),this.getContext());
                    /////

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}