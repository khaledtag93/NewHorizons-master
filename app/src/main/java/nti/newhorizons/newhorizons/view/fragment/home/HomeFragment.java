package nti.newhorizons.newhorizons.view.fragment.home;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.adapter.SliderImageAdapter;
import nti.newhorizons.newhorizons.data.entities.Course;
import nti.newhorizons.newhorizons.data.remote.retrofit.RetrofitClient;

public class HomeFragment extends Fragment {
    RecyclerView recyclerViewCategory;
    RecyclerView recyclerViewMostPopular;
    RecyclerView recyclerViewSuggested;
    HomePresenter presenter;

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] logo= {R.drawable.first,R.drawable.second,R.drawable.third};
    private ArrayList<Integer> logoArray = new ArrayList<Integer>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        init(rootView);
        actions();



        return rootView;

    }

    private void init(View rootView) {
        recyclerViewCategory = rootView.findViewById(R.id.rv_category);
        recyclerViewMostPopular = rootView.findViewById(R.id.rv_mostPopular);
        recyclerViewSuggested = rootView.findViewById(R.id.rv_suggested);
        presenter = new HomePresenter(this);


        for(int i=0;i<logo.length;i++)
            logoArray.add(logo[i]);

        mPager = (ViewPager)rootView.findViewById(R.id.pager);


        mPager.setAdapter(new SliderImageAdapter(getContext(),logoArray));
        CircleIndicator indicator = (CircleIndicator)rootView.findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == logo.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);
    }






    private void actions() {


        RetrofitClient.getRetrofitInstance();
        RetrofitClient.callCourseAPI();
    }


}
