package nti.newhorizons.newhorizons.view.fragment.courses;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.view.activity.main.MainActivity;
import nti.newhorizons.newhorizons.view.fragment.category.CategoryFragment;
import nti.newhorizons.newhorizons.view.fragment.vendors.VendorsFragment;


public class CatogrysSelection extends Fragment {


    private LinearLayout linearLayout1;
    private ImageView imageView2;
    public CatogrysSelection() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_catogrys_selection, container, false);
        init(rootView);
        presentData();
        actions();

        return rootView;
    }


    private void actions() {
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getBaseContext(),"1111",Toast.LENGTH_LONG).show();

                swapFragment();

            }
        });



    }

    private void presentData() {

    }

    private void init(View rootView) {

        imageView2=rootView.findViewById(R.id.ivCategoryIcon);
    }

    private void swapFragment(){

        FragmentTransaction fragmentTransaction =this.getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.lfragment, new CategoryFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}