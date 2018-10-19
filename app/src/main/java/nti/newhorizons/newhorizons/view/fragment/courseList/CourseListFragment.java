package nti.newhorizons.newhorizons.view.fragment.courseList;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.data.entities.Course;
import nti.newhorizons.newhorizons.view.activity.courseDetails.courseDetails;
import nti.newhorizons.newhorizons.view.fragment.ProfileCourse.ProfileCourseFragment;

public class CourseListFragment extends Fragment{
    ListView lvCourses;
    CourseListPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_course_list, container, false);

        init(rootView);
        presentData();
        actions();

        return rootView;
    }

    private void actions() {
        lvCourses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), courseDetails.class);
                intent.putExtra("Course",new Course());
                startActivity(intent);
            }
        });
    }

    private void presentData() {
        presenter=new CourseListPresenter(this);
        presenter.setCourseListAdapter();

    }

    private void init(View rootView) {
        lvCourses = (ListView) rootView.findViewById(R.id.lvCourse);

    }

    private void swapFragment(){

        FragmentTransaction fragmentTransaction =getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.lfragment, new ProfileCourseFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}