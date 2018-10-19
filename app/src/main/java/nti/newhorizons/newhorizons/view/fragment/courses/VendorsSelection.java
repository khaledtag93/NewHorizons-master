package nti.newhorizons.newhorizons.view.fragment.courses;


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
import nti.newhorizons.newhorizons.view.fragment.category.CategoryFragment;
import nti.newhorizons.newhorizons.view.fragment.vendors.VendorsFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class VendorsSelection extends Fragment {
    private LinearLayout linearLayout1;
    private ImageView imageView1;

    public VendorsSelection() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_vendors_selection, container, false);
        init(rootView);
        presentData();
        actions();

        return rootView;    }


    private void actions() {
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapFragment();
                Toast.makeText(getActivity().getBaseContext(),"222", Toast.LENGTH_LONG).show();


            }
        });



    }

    private void presentData() {

    }

    private void init(View rootView) {
        imageView1=rootView.findViewById(R.id.ivVendorIcon);
    }

    private void swapFragment(){

        FragmentTransaction fragmentTransaction =getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.lfragment, new VendorsFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}