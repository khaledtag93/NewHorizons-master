package nti.newhorizons.newhorizons.view.fragment.category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.view.fragment.courseList.CourseListFragment;
import nti.newhorizons.newhorizons.view.fragment.courses.CatogrysSelection;
import nti.newhorizons.newhorizons.view.fragment.vendors.VendorsFragment;

public class CategoryFragment extends Fragment {
    CategoryPresenter presenter;
    GridView gridView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);

        init(rootView);
        presentData();
        actions();

        return rootView;
    }

    private void actions() {

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                swapFragment();
            }
        });
    }

    private void presentData() {
        presenter=new CategoryPresenter(this);
        presenter.setCategoryAdapter();
    }

    private void init(View rootView) {
        gridView = (GridView) rootView.findViewById (R.id.grid_view_categories);

    }
    private void swapFragment(){

        FragmentTransaction fragmentTransaction =getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.lfragment, new CourseListFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}