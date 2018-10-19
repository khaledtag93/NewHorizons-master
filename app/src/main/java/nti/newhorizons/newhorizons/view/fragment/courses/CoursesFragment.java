package nti.newhorizons.newhorizons.view.fragment.courses;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.view.fragment.category.CategoryFragment;
import nti.newhorizons.newhorizons.view.fragment.courseList.CourseListFragment;
import nti.newhorizons.newhorizons.view.fragment.vendors.VendorsFragment;

public class CoursesFragment extends Fragment{
    @Nullable
    CoursesPresenter coursesPresenter;
    private LinearLayout linearLayout1,linearLayout2;
    private ImageView imageView1,imageView2;
    private EditText searchContent;
    VendorsFragment vendorsFragment=new VendorsFragment();
    CategoryFragment categoryFragment=new CategoryFragment();
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_courses, container, false);
        View rootView1 = inflater.inflate(R.layout.fragment_vendors_selection, container, false);
        coursesPresenter=new CoursesPresenter();

        init(rootView);
        presentData();
        actions();
        return rootView;
    }

    private void presentData() {

    }
    private void actions() {
        searchContent.setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                                actionId == EditorInfo.IME_ACTION_DONE ||
                                event != null &&
                                        event.getAction() == KeyEvent.ACTION_DOWN &&
                                        event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                            if (event == null || !event.isShiftPressed()) {
                                // the user is done typing.

                                swapFragment();
                                return true; // consume.
                            }
                        }
                        return false; // pass on to other listeners.
                    }
                }
        );


    }

    private void init(View rootView) {

        searchContent=(EditText)rootView.findViewById(R.id.etSearch);
    }

    private void swapFragment(){

        FragmentTransaction fragmentTransaction =getActivity().getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.lfragment, new CourseListFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}