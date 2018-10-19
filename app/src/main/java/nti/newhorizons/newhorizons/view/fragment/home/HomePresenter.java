package nti.newhorizons.newhorizons.view.fragment.home;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import nti.newhorizons.newhorizons.adapter.HomeCategoryAdapter;
import nti.newhorizons.newhorizons.adapter.MostPopularAdapter;
import nti.newhorizons.newhorizons.data.entities.Course;
import nti.newhorizons.newhorizons.data.entities.Category;

public class HomePresenter {
    private HomeFragment view;
    private HomeFragmentViewModel mViewModel;


    HomePresenter(HomeFragment view) {
        this.view = view;
        mViewModel = ViewModelProviders.of(view).get(HomeFragmentViewModel.class);

        // subscribe and update data automatically.
        subscribeMostPopularCourses();
        subscribeSuggestedCourses();
        subscribeCategories();
    }

    private void setMostPopularAdapter(List<Course> courses) {
        MostPopularAdapter mostPopularAdapter = new MostPopularAdapter(view.getActivity(), courses);
        view.recyclerViewMostPopular.setLayoutManager(new LinearLayoutManager(view.getActivity(), LinearLayoutManager.HORIZONTAL, true));
        view.recyclerViewMostPopular.setAdapter(mostPopularAdapter);
    }

    private void setSuggestedCoursesAdapter(List<Course> courses) {
        MostPopularAdapter mostPopularAdapter = new MostPopularAdapter(view.getActivity(), courses);
        view.recyclerViewSuggested.setLayoutManager(new LinearLayoutManager(view.getActivity(), LinearLayoutManager.HORIZONTAL, true));
        view.recyclerViewSuggested.setAdapter(mostPopularAdapter);
    }

    private void setCatogoryAdapter(List<Category> categories) {
        HomeCategoryAdapter categoryAdapter = new HomeCategoryAdapter(view.getActivity(), categories);
        view.recyclerViewCategory.setLayoutManager(new LinearLayoutManager(view.getActivity(), LinearLayoutManager.HORIZONTAL, true));
        view.recyclerViewCategory.setAdapter(categoryAdapter);
    }

    private void subscribeMostPopularCourses() {
        mViewModel.mostPopularCourses.observe(view, new Observer<List<Course>>() {
            @Override
            public void onChanged(final List<Course> courses) {
                setMostPopularAdapter(courses);
            }
        });
    }

    private void subscribeSuggestedCourses() {
        mViewModel.suggestedCourses.observe(view, new Observer<List<Course>>() {
            @Override
            public void onChanged(final List<Course> courses) {
                setSuggestedCoursesAdapter(courses);
            }
        });
    }

    private void subscribeCategories() {
        mViewModel.catogries.observe(view, new Observer<List<Category>>() {
            @Override
            public void onChanged(final List<Category> categories) {
                setCatogoryAdapter(categories);
            }
        });
    }
}
