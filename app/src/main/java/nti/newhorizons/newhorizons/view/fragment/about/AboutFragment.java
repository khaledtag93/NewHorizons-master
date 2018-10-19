package nti.newhorizons.newhorizons.view.fragment.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.view.fragment.home.HomePresenter;

public class AboutFragment extends Fragment {
    ImageView imgfb, imglinked, imgtwitter, imgyoutube, imgweb;
    ImageView abbas, makram, mobtadian, october;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

        init(rootView);
        actions();

        return rootView;

    }

    private void init(View rootView) {
        imgfb = (ImageView) rootView.findViewById(R.id.iv_fb);
        imglinked = (ImageView) rootView.findViewById(R.id.iv_linkedin);
        imgtwitter = (ImageView) rootView.findViewById(R.id.iv_twitter);
        imgweb = (ImageView) rootView.findViewById(R.id.iv_web);
        imgyoutube = (ImageView) rootView.findViewById(R.id.iv_youtube);
        abbas = (ImageView) rootView.findViewById(R.id.iv_abbas);
        makram = (ImageView) rootView.findViewById(R.id.iv_makram);
        mobtadian = (ImageView) rootView.findViewById(R.id.iv_mobtadian);
        october = (ImageView) rootView.findViewById(R.id.iv_october);


    }

    private void actions() {
        imgfb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openUrL("https://www.facebook.com/New-Horizons-Cairo-199886997314180/");
            }
        });

        imglinked.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openUrL("https://www.linkedin.com/company/new-horizons-computer-learning-centers/?originalSubdomain=eg");
            }
        });

        imgyoutube.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openUrL("https://www.youtube.com/user/NewHorizonsCLC");
            }
        });


        imgtwitter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openUrL("https://twitter.com/NewHorizonsCLC");
            }
        });

        imgweb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openUrL("https://www.newhorizons.com/");
            }
        });
        abbas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openUrL("https://goo.gl/maps/rjaKxH7DPB12");
            }
        });
        makram.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openUrL("https://goo.gl/maps/eSQvGUGHq8y");
            }
        });
        mobtadian.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openUrL("https://goo.gl/maps/KLgqGoZZA5q");
            }
        });
        october.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }

    private void openUrL(String url) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
