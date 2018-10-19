package nti.newhorizons.newhorizons.view.fragment.home;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import nti.newhorizons.newhorizons.data.entities.Category;
import nti.newhorizons.newhorizons.data.entities.Course;
import nti.newhorizons.newhorizons.data.local.room.AppDatabase;
import nti.newhorizons.newhorizons.data.local.room.DatabaseInitializer;

public class HomeFragmentViewModel extends AndroidViewModel {
    public LiveData<List<Course>> mostPopularCourses;
    public LiveData<List<Course>> suggestedCourses;
    public LiveData<List<Category>> catogries;

    private AppDatabase mDb;


    public HomeFragmentViewModel(@NonNull Application application) {
        super(application);

        mDb = AppDatabase.getInMemoryDatabase(this.getApplication());
        DatabaseInitializer.populateAsync(mDb);

        mostPopularCourses = mDb.courseModel().loadMostPopularCourses();
        suggestedCourses = mDb.courseModel().loadSuggestedCourses();
        catogries = mDb.categoryModel().loadAllCategories();
    }


}
