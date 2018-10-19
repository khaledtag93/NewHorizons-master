package nti.newhorizons.newhorizons.view.fragment.ProfileCourse;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.adapter.ProfileCourseListAdapter;
import nti.newhorizons.newhorizons.data.entities.CourseTitleChild;
import nti.newhorizons.newhorizons.data.entities.CourseTitleParent;
import nti.newhorizons.newhorizons.data.entities.HollowDataCreator;

public class ProfileCourseFragment extends android.support.v4.app.Fragment {
    ProfileCoursePresenter presenter;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile_course, container, false);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.course_profile);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        ProfileCourseListAdapter adapter = new ProfileCourseListAdapter(this.getContext(),initData());
        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);

        recyclerView.setAdapter(adapter);
        init(rootView);
        presentData();
        actions();

        return rootView;
    }
    private List<ParentObject> initData() {
        HollowDataCreator titleCreator = HollowDataCreator.get(this.getContext());
        List<CourseTitleParent> titles = titleCreator.getAll();
        List<ParentObject> parentObject = new ArrayList<>();

        for(CourseTitleParent title:titles)
        {
            List<Object> childList = new ArrayList<>();
            childList.add(new CourseTitleChild("Add to contacts","Send message","odata",R.drawable.weee));
            title.setChildObjectList(childList);
            parentObject.add(title);
        }
        return parentObject;

    }
    private void init(View rootView) {
    }

    private void actions() {
    }

    private void presentData() {
    }
}