package nti.newhorizons.newhorizons.data.local.room;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.data.entities.Category;
import nti.newhorizons.newhorizons.data.entities.Course;

public class DatabaseInitializer {

    public static void populateAsync(final AppDatabase db) {

        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    private static void populateWithTestData(AppDatabase db) {
        db.courseModel().deleteAll();
        db.categoryModel().deleteAll();

        List<Course> testCourses=TestDate.getCourses();
        for (Course course:testCourses) {
            db.courseModel().insertCourse(course);
        }

        List<Category> testCatogories=TestDate.getCategories();
        for (Category category:testCatogories) {
            db.categoryModel().insertCategory(category);
        }




    }


    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }
}
